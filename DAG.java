package DAG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DAG {
	private int ver;
	private int ed;
	private ArrayList<Integer>[] adj;
	private int[] idig;
	private boolean mar[];
	private boolean cyclic;
    private boolean stack[];
    Scanner sc=new Scanner(System.in);
	@SuppressWarnings("unchecked")
	public DAG(int V)            // V= number of vertices graph has
	{
	    this.ver = V;
	    this.ed = 0;
	    idig = new int[V];                                //indegree 
	    adj = (ArrayList<Integer>[]) new ArrayList[V];                //creating an empty adjacent arraylist of size V
	    for (int v = 0; v < V; v++) {                                   
	        adj[v] = new ArrayList<Integer>();                        
	    }
	    mar = new boolean[V];
	    stack = new boolean[V];
	}

	 
    public int Vertices() 
        {return ver;}
    
    public int Edge() 
        {return ed;}
    
 private int checkver(int v)                   // checks for the value passed
{if (v < 0 || v >= ver)
        	{return -1;
        	}
        
        	
        else
        	{return 1;}
        
}
	
	public int indegree(int v) 
	{		if(checkver(v)<0){
			return -1;
		}                                                               //returns the indegree of a vertex v
		else{
			return idig[v];
		}
	}

	public int outdegree(int v) {                                       // returns the out degree of vertex v
		if(checkver(v)<0){
			return -1;
		}
		else{
			return adj[v].size();
		}
    }

		public Iterable<Integer> adj(int v){ //vertices adjacent to v; iterates through the list 
		return adj[v];
		}

		public void addEdge(int v, int w) { 		//Adds a directed edge going from v to w

	        if (v >= 0 && v < adj.length && w >= 0 && w < adj.length) {
	            addEdge(adj, v, w);
	        }
	    }

	    public void addEdge(ArrayList<Integer>[] adj, int v, int w) {
	        ArrayList<Integer> list = adj[v];
	            list.add(w);                          // adds w to the list of connected to v
	            ed++;
	    }


	public boolean cyclic() {

        return cyclic;
    }

	 public void findCycle(int v) {

	        mar[v] = true;
	        stack[v] = true;

	        for (int w : adj(v)) {                     
	            if(!mar[w]) {
	                findCycle(w);
	            } else if (stack[w]) {
	                cyclic = true;
	                return;
	            }
	        }

	        stack[v] = false;
	    }


	 public ArrayList<Integer> findLCA(int v1, int v2) {

	        ArrayList<Integer> LCA = new ArrayList<>();                                     
	        Queue<Integer> depth = new LinkedList<>();
	        Queue<Integer> followingdepth = new LinkedList<>();
	        if (v1 == v2) {
	        	LCA.add(v1);
	            return LCA;
	        }
	        boolean[] ver1Ancestors = new boolean[adj.length];
	        ArrayList<Integer>[] table = flip(adj);
	        Arrays.fill(ver1Ancestors, false);

	        ver1Ancestors[v1] = true;
	        for(int v : table[v1]) {
	            markAncestors(table, ver1Ancestors, v);
	        }
	        for(int v : table[v2]) {
	            depth.add(v);
	        }

	        while(!depth.isEmpty()) {
	                int ver = depth.remove();
	                if(ver1Ancestors[ver]) {
	                	LCA.add(ver);
	                }
	                if(LCA.isEmpty()) {
	                    for (int w : table[ver]) {
	                    	followingdepth.add(w);
	                    }
	                }

	            depth = followingdepth;
	            followingdepth = new LinkedList<>();
	        }
	        return LCA;
	    }

	    public void markAncestors(ArrayList<Integer>[] parentTable, boolean[] v1Ancestors, int ver) {
	        v1Ancestors[ver] = true;
	        for(int vertice : parentTable[ver]) {
	            markAncestors(parentTable, v1Ancestors, vertice);
	        }
	    }
	    public ArrayList<Integer>[] flip(ArrayList<Integer>[] adj) {                                       //returns a reverse or flipped array list by assign the value for each vertex and its list to revrse and passing th evalue back
	        ArrayList<Integer>[] flip = (ArrayList<Integer>[]) new ArrayList[adj.length];
	        for(int i = 0; i < flip.length;  i++) {
	            flip[i] = new ArrayList<>();
	        }
	        for(int vertice = 0; vertice < adj.length; vertice++) {
	            for(int w : adj[vertice]) {
	                addEdge(flip, w, vertice);
	            }
	        }
	        return flip;
	    }
	    
	    
	    public int create() {
	    	int v1,v2,m=1;
	    	
	    	do {
	    	System.out.println("Enter the two vertxes to connect a directed edge");
	    	v1=sc.nextInt();
	    	v2=sc.nextInt();
	    	addEdge(v1,v2);
	    	System.out.println("Enter 0 to exit");
	    	m=sc.nextInt();
	    	}while(m!=0);
	   int c=checkcycle();
	   if(c==0) {
		   System.out.println("The graph is acyclic");
		   return 1;
	   }
	   else {
		   return 0;
	   }	    	
	    }
		public int checkcycle() {
			if(cyclic)
			{
				return 1;
			}
			
			else{
				return 0;
			}
		}	
	    
	    }    
