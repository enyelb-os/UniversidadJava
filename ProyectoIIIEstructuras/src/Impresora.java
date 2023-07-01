public class Impresora {
	private TrabajoImp trabajos[];
	private int reciente[]=new int[6];
	private int n;
	Impresora(int N){
		trabajos=new TrabajoImp[N];
		n=0;
	}
	public int getN(){
		return trabajos.length;
	}
	public int getn(){
		return n;
	}
	public boolean esVacio(){
		return n==0;
	}
	public boolean esLLeno(){
		return n==getN();
	}
	private void intercambiar(int a, int b){
		TrabajoImp aux;
		aux=trabajos[a];
		trabajos[a]=trabajos[b];
		trabajos[b]=aux;
	}
	private boolean menor(int a,int b){
		return trabajos[a].getPrioridad()>trabajos[b].getPrioridad();
	}
	//-------------------------------------------------//
	private void inReciente(int a){
		for(int i=4;i>=0;i--){
			int b=reciente[i];
			reciente[i+1]=b;
		}
		reciente[0]=a;
	}
	private int reciente(){	
		if(n>5){
			for(int i=0;i<6;i++){
				if(reciente[0]==reciente[i]){
					return 1;
				}
			}
		}
		return 0;
	}
	//-------------------------------------------------//
	private void elevar(int k){
		while(k>0){
			if(menor((k-1)/2,k)){
				intercambiar(k,(k-1)/2);
			}
			k=(k-1)/2;
		}
	}
	public void insertar(String nombre,int id,int p_usuario,int n_paginas,boolean i_o){
		if(!esLLeno()){
			trabajos[n]=new TrabajoImp(nombre,id,p_usuario,n_paginas,i_o);
			inReciente(id);
			trabajos[n].setIReciente(reciente());
			elevar(n);
			n++;
		}
		else{
			System.out.println("Cola LLena");
		}
	}
	private void insertar(String nombre,int id,int p_usuario,int n_paginas,boolean i_o,int i_reciente){
		if(!esLLeno()){
			trabajos[n]=new TrabajoImp(nombre,id,p_usuario,n_paginas,i_o,i_reciente);
			elevar(n);
			n++;
		}
		else{
			System.out.println("Cola LLena");
		}
	}
	//--------------------------------------------------//
	private void descender(int k){ 
		while((2*(k+1)<n || 2*k+1<n) && (menor(k,2*k+1) || menor(k,2*(k+1)))){
			if(menor(2*(k+1),2*k+1)){
				intercambiar(2*k+1,k);
				k=2*k+1;
			}
			else{
				intercambiar(2*(k+1),k);
				k=2*(k+1);
			}
		}
	}
	public TrabajoImp extraer(){
		if(!esVacio()){
			n--;
			TrabajoImp aux=trabajos[0];
			trabajos[0]=trabajos[n];
			descender(0);
			trabajos[n]=null;
			return aux;
		}
		else{
			System.out.println("COLA VACIA");
			return null;
		}
	}
	//---------------------------------------------------------//
	public void mostrarConsola(){
		Impresora temp=new Impresora(getN());
		while(!esVacio()){
			TrabajoImp aux=extraer();
			System.out.println(aux.getPrioridad()+" "+aux.getID());
			temp.insertar(aux.getNombre(),aux.getID(),aux.getPUsuario(),aux.getNPaginas(),aux.getIoE(),aux.getIReciente());
		}
		while(!temp.esVacio()){
			TrabajoImp aux=temp.extraer();
			insertar(aux.getNombre(),aux.getID(),aux.getPUsuario(),aux.getNPaginas(),aux.getIoE(),aux.getIReciente());
		}
	}
	public String[][] mostrar(){
		TrabajoImp aux;
		String trabajos[][]=new String[getn()][6];
		Impresora temp=new Impresora(getN());
		for(int i=0;i<getn()+temp.getn();i++){
			aux=extraer();
			trabajos[i][0]=Integer.toString(aux.getPrioridad());
			trabajos[i][1]=aux.getNombre();
			trabajos[i][2]=Integer.toString(aux.getID());
			if(aux.getPUsuario()==1){
				trabajos[i][3]="Alta";
			}
			else if(aux.getPUsuario()==2){
				trabajos[i][3]="Media";
			}
			else{
				trabajos[i][3]="Baja";
			}
			trabajos[i][4]=Integer.toString(aux.getNPaginas());
			if(aux.getIReciente()==0)
				trabajos[i][5]="F";
			else
				trabajos[i][5]="V";
			temp.insertar(aux.getNombre(),aux.getID(),aux.getPUsuario(),aux.getNPaginas(),aux.getIoE(),aux.getIReciente());
		}
		while(!temp.esVacio()){
			aux=temp.extraer();
			insertar(aux.getNombre(),aux.getID(),aux.getPUsuario(),aux.getNPaginas(),aux.getIoE(),aux.getIReciente());
		}
		return trabajos;
	}
}