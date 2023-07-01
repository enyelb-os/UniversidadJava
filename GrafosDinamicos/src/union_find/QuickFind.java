package union_find;

public class QuickFind {
	
	private int[] id;
	private int count;
	
	public QuickFind(int n){
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++)
			id[i] = i;
	}
	
	public int count(){ 
		return count; 
	}
	public boolean conectados(int p, int q){ 
		return find(p) == find(q); 
	}
	public int find(int p){
		return id[p];
	}
	public void union(int p,int q){
		if (!conectados(p,q)){
			int pID=find(p);
			int qID=find(q);
			for (int i = 0; i < id.length; i++){
				if (id[i] == pID ){ 
					id[i] = qID;
				}
			}
			System.out.println(p+" "+q);
			count--;
		}
	}
	public void mostrarIDs(){
		System.out.println("Ids");
		for(int i=0;i<id.length;i++){
			System.out.println(i+" "+id[i]);
		}
	}

}
