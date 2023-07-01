public class TrabajoImp {
	private String nombre;
	private int id;
	private int p_usuario;
	private int n_paginas;
	private int i_reciente;
	private boolean i_e;
	TrabajoImp(String nombre, int id,int p_usuario,int n_paginas,boolean i_e){
		this.nombre=nombre;
		this.id=id;
		this.p_usuario=p_usuario;
		this.n_paginas=n_paginas;
		this.i_e=i_e;
	}
	TrabajoImp(String nombre, int id,int p_usuario,int n_paginas,boolean i_e,int i_reciente){
		this.nombre=nombre;
		this.id=id;
		this.p_usuario=p_usuario;
		this.n_paginas=n_paginas;
		this.i_e=i_e;
		this.i_reciente=i_reciente;
	}
	public String getNombre(){
		return nombre;
	}
	public int getID(){
		return id;
	}
	public int getPUsuario(){
		return p_usuario;
	}
	public int getNPaginas(){
		return n_paginas;
	}
	public int getIReciente(){
		return i_reciente;
	}
	public int getPrioridad(){
		return(p_usuario*n_paginas)+(100*i_reciente);
	}
	public boolean getIoE(){
		return i_e;
	}
	public void setIReciente(int i_reciente){
		this.i_reciente=i_reciente;
	}
}
//------------------------------------------------//
class TrabajoImpInterno extends TrabajoImp{
	TrabajoImpInterno(String nombre,int id, int p_usuario, int n_paginas,boolean i_e) {
		super(nombre,id, p_usuario, n_paginas,i_e);
	}
	TrabajoImpInterno(String nombre,int id, int p_usuario, int n_paginas,boolean i_e,int reciente) {
		super(nombre,id, p_usuario, n_paginas,i_e,reciente);
	}
	public int getCosto(){
		return 0;
	}
}
//-----------------------------------------------//
class TrabajoImpExterno extends TrabajoImp {
	private int costo=150;
	TrabajoImpExterno(String nombre,int id, int p_usuario, int n_paginas,boolean i_e) {
		super(nombre,id, p_usuario, n_paginas,i_e);
	}
	TrabajoImpExterno(String nombre,int id, int p_usuario, int n_paginas,boolean i_e,int reciente) {
		super(nombre,id, p_usuario, n_paginas,i_e,reciente);
	}
	public int getCosto(){
		return getNPaginas()*costo;
	}
}
