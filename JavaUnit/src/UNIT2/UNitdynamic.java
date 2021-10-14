
	package UNIT2;

	import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;



	public class UNitdynamic {

	@Test
	public void testLCA(){

	Main m = new Main();
	m.Createtree();
	   int a, b,c;
	   @SuppressWarnings("resource")
	Scanner sc=new Scanner(System.in);
	   System.out.println(" Enter 0 to EXIT!!");
       int t= sc.nextInt();
     while(t!=0){ 
    System.out.println("Enter the nodes to be checked");
 
    a=sc.nextInt();  
    b=sc.nextInt();
    System.out.println("Enter the correct ancestor to conduct the test");
      c= sc.nextInt();
  
   Node lca =Main.LCA(a,b);                                                            
	  assertEquals(c,lca.d);
       System.out.println("This Test passed " +c+" is indeed the LCA for the binary search tree"); // The test keeps on repeating until 0 is entered or the test fails
     System.out.println(" Enter 0 to EXIT!!");
     t=sc.nextInt();
     
}
       Main f =new Main();                                         //this is a static call to check what it repeats for 0 
       f.Create(0);
    System.out.println("Entering Test 2");
       Node lca2= Main.LCA(0, 0);
       assertEquals(0,lca2.d);

     
     }

	
	}


	


