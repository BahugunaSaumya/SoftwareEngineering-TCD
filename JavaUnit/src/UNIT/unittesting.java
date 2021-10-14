package UNIT;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class unittesting {

@Test
public void testLCA(){

Node r = new Node(55);
r.l = new Node(22);
r.ri = new Node(66);
r.l.ri = new Node(44);
r.ri.l = new Node(65);
r.ri.ri = new Node(68);
r.ri.l.l = new Node(60);
r.ri.ri.ri = new Node(70);
Assertions.assertAll("Test for the Binary tree 1",
() ->   assertEquals(66,Main.FindLCA(r, r.ri.l.l, r.ri.ri)),
() ->   assertEquals(55,Main.FindLCA(r, r.ri.l, r.l)),
() -> assertEquals(68,Main.FindLCA(r, r.ri.ri.ri, r.ri.ri))
);
Node e = new Node(15);
e.l = new Node(10);                                     //constructing a different tree to check the code
e.ri = new Node(25);
e.l.ri = new Node(12);
e.ri.l = new Node(20);
e.ri.ri = new Node(30);
e.ri.l.l = new Node(18);
e.ri.l.l.ri = new Node(22);
e.l.l= new Node(8);
e.l.l.l= new Node(6);
e.l.l.ri=new Node(9);
Assertions.assertAll("should return true if the Node is present",
() -> assertEquals(10,Main.FindLCA(e, e.l.l.l, e.l.ri)),
() -> assertEquals(15,Main.FindLCA(e,e.ri.l,e.l.l.l)),
() -> assertEquals(25,Main.FindLCA(e, e.ri.l.l, e.ri.ri)) );
}


}
