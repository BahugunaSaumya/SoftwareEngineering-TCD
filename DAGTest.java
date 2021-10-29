package DAG;
import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.Test;
import org.junit.Test;


	import static org.junit.Assert.*;
	 public class DAGTest {

		
				 @Test
				    public void testLowestCommonAncestor() {



				        DAG graph = new DAG(22);

				        graph.addEdge(10, 5); 
				        graph.addEdge(10, 15);
				        graph.addEdge(15, 20); 
				        graph.addEdge(20, 13); 
				        graph.addEdge(20, 14);
				        graph.addEdge(5, 3);
				        graph.addEdge(3, 1); 
				        graph.addEdge(3, 2); 
				        graph.addEdge(2, 4); 
				        graph.addEdge(4, 6); 
				        graph.addEdge(4, 7); 
				        ArrayList<Integer> lca = graph.findLCA(1, 2);
				        assertEquals(3, lca);
				        lca = graph.findLCA(1, 6);
				        assertEquals(3, lca);
				        lca = graph.findLCA(30, 30);
				        assertEquals(30, lca);
                        lca = graph.findLCA(6,7);
				         assertEquals(4, lca);

				  
				    }


	 }