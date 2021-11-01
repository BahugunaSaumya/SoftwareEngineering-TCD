package DAG;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
 public class Dagstatic {

	 @Test
	    public void testForAddingEdges() {

	        DAG graph = new DAG(8);
	        graph.addEdge(8,7);
	        graph.addEdge(7,1);
	        graph.addEdge(1, 5);
	        graph.addEdge(5, 9);
	        assertEquals(false,graph.cyclic());
	        assertEquals(2, graph.Edge());
	        assertEquals(8, graph.Vertices());
	    }
	 public void testForDirectedGraph(){
			DAG graph = new DAG(10);
			graph.addEdge(1, 2);
			graph.addEdge(1, 3);
			graph.addEdge(3, 4);
			graph.addEdge(4, 5);
			graph.addEdge(4, 6);
            assertEquals(0, graph.indegree(4));
			assertEquals(2, graph.outdegree(4));
			String ans = "[5, 6]";
			assertEquals(ans, graph.adj(4).toString());
		}
			@Test
			public void cycle(){
				DAG graph = new DAG(20);
				graph.addEdge(5, 8);
				graph.addEdge(8, 9);
				graph.addEdge(10, 5);
				graph.findCycle(5);
				assertFalse(graph.cyclic());
			}

			 @Test
			    public void LCA() {



			        DAG graph = new DAG(22);

			     
			        graph.addEdge(18, 22); 
			        graph.addEdge(18, 15); 
			   
			        graph.addEdge(15, 20); 
			        graph.addEdge(20, 5); 
			        graph.addEdge(20, 14);
			  
			        graph.addEdge(1, 3); 
			    
			        graph.addEdge(3, 4);
			     
			        graph.addEdge(3, 2); 
			    
			        graph.addEdge(2, 9); 
			        graph.addEdge(9, 6); 
			        graph.addEdge(9, 7); 

			   
			 ArrayList<Integer> lca = graph.findLCA(4, 2);
		        String result = "[3]";
		        assertEquals(result, lca.toString());

		        lca = graph.findLCA(4, 6);
		        result = "[3]";
		        assertEquals(result, lca.toString());

		        lca = graph.findLCA(20, 20);
		        result = "[20]";
		        assertEquals(result, lca.toString());

		        lca = graph.findLCA(6,7);
		        result = "[9]";
		        assertEquals(result, lca.toString());

		        lca = graph.findLCA(1, 4);
		        result = "[1]";
		        assertEquals(result, lca.toString());

		    
		        lca = graph.findLCA(5,14);
		        result = "[20]";
		        assertEquals(result, lca.toString());


		    }


 }