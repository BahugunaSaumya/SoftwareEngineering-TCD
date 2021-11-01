package DAG;
import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;
import org.junit.Test;


	import static org.junit.Assert.*;
	 public class DAGdynamic {
		 
		  	 @Test
	   public void testForAddingEdges() {
			  Scanner sc= new Scanner(System.in);   
		        System.out.println("Test 1 -To verify if the creation of graph is correct or not");
		     	 System.out.println("Enter the maximum vertices required for the graph ");
			    int n = sc.nextInt();
		        DAG graph = new DAG(n);

		
             graph.create();

                System.out.println("Enter the number of edges");
                int m=sc.nextInt();
		        assertEquals(m, graph.Edge());
		        
		        System.out.println("Enter the number of vertices to check");
		        int ver = sc.nextInt();
		        assertEquals(ver,graph.Vertices()); 
  
              
              

              }
		  	 @Test
             public void cycle(){
		  		  Scanner sc= new Scanner(System.in);
		  		  System.out.println("Test to check the cycle");
			     	 System.out.println("Enter the maximum vertices required for the graph ");
				    int n = sc.nextInt();
                        int p=1;
				    DAG graph = new DAG(n);
			      
			        
			
	             graph.create();

	                System.out.println("Enter the vertex you want ot check for cycle");
	                int m=sc.nextInt();
			        graph.findCycle(m);
			      do {  System.out.println("Enter 1 for cyclic and 2 for acyclic");
			        int ch=sc.nextInt();
			        if(ch==1) {
			        assertEquals(true,graph.cyclic());
			        }
			        else { assertFalse(graph.cyclic());}
			      System.out.println("Enter 0 to exit and any number to continue");
			      p= sc.nextInt();
			      }while(p!=0);
	            	              }
                      
	 
		     
		  	 
		  	 
		  	 
		  	 
			@Test
				public void testForDirectedGraph(){
				Scanner sc= new Scanner(System.in);   
				 System.out.println("Test -To verify if the graph is Directed or not");	
				 System.out.println("Enter the maximum vertices required for the graph ");
				    int n = sc.nextInt();
			        DAG graph = new DAG(n);
					
			         graph.create();
		            	  System.out.println("Enter the number you want to check connected nodes for");
							int m= sc.nextInt();
System.out.println("Enter rhe Indegree");
int j= sc.nextInt();
		            	  assertEquals(j, graph.indegree(m));
		            	  System.out.println("Enter the outdegree");
		            	  int p= sc.nextInt();
					assertEquals(p, graph.outdegree(m));
					
					System.out.println("Enter the number of nodes should be connected to " +m);
				    int k = sc.nextInt();
				    String arr[]= new String [k];
				    for (int i=0; i<k;i++) {
				    System.out.println("Enter the values for nodes connected to the " +m);
				    String val = sc.next();
				    arr[i]=val;
				    }
				    
					
				  
					assertEquals(arr, graph.adj(m).toString());
	
			}

				@Test
				public void Degree(){
					DAG graph = new DAG(6);
				
					assertEquals("", -1, graph.indegree(-3));
			
					assertEquals(-1, graph.outdegree(8));
				}

	


				

				 @Test
				    public void LCA() {
					 System.out.println("Test to check LCA");	
                  Scanner sc=new Scanner (System.in);
                  System.out.println("Enter the maximum vertices required for the graph ");
				    int n = sc.nextInt();
			        DAG graph = new DAG(n);
	
			      graph.create();
int m=1;

		  do {
				System.out.println("Enter the nodes to check the LCA");
				int l=sc.nextInt();
				int o= sc.nextInt();
			  ArrayList<Integer> lca = graph.findLCA(l, o);
				        System.out.println("Enter the LCA expected");
				        String e= sc.next();
				        String result = "["+e+"]";
				 assertEquals(result, lca.toString());
		  System.out.println("Enter 0 to exit else enter any value to conitnue");
		  m=sc.nextInt();
		  }while(m!=0);
				    
				 }
             
				 
				   
				    }


	 