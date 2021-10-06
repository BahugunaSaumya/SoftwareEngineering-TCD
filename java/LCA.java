import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

class Node{


    int d;
    Node l= null;
    Node ri= null;
    Node(int d)
    {
        this.d= d;
    }

}
class Main{
    static class NW
        {
            public Node n;
            NW(Node n){
            this.n=n;
        
            }
        }
    
 public static boolean Nodecheck( Node r, Node n)
 {
     if(r==null)
     {
     return false;
     }
    
 else if( r ==n) {
     return true;
}
    return Nodecheck(r.l , n) || Nodecheck(r.ri,n);

}

public static boolean FindLCA( Node r, NW lca, Node x, Node y)
{
    if(r==null){
        return false;
    }

        
        if (r == x || r == y)
        {
            
            lca.n = r;
            return true;
        }
 
       
        boolean l = FindLCA(r.l, lca, x, y);
 
       
        boolean ri = FindLCA(r.ri, lca, x, y);
 
        
        if (l && ri) {
            lca.n = r;
        }
 
       
        return l || ri;
    }
 
    public static void FindLCA(Node r, Node x, Node y)
    {
        
        Node lca = null;
 
       
        
        NW LCA = new NW(lca);
 
        if (Nodecheck(r, y) && Nodecheck(r, x))
        {
            FindLCA(r, LCA, x, y);
            lca = LCA.n;
        }
 
        
        if (lca != null) {
            System.out.println("LCA is " + lca.d);
        }
        else {
            System.out.print("LCA does not exist\n");
        }
    }
 





public static void main(String[] args)
{

    Node r = new Node(55);
    r.l = new Node(22);
    r.ri = new Node(66);
    r.l.ri = new Node(44);
    r.ri.l = new Node(65);
    r.ri.ri = new Node(68);
    r.ri.l.l = new Node(60);
    r.ri.ri.ri = new Node(70);

    FindLCA(r, r.ri.l.l, r.ri.ri);
    FindLCA(r, r.ri.l.l, new Node(100));
    FindLCA(r, r.ri.l.l, r.ri.l.l);
    FindLCA(r, r.ri.l.l, r.ri.l);
    FindLCA(r, r.l, r.ri.l);
}
@Test
public void testFindLCA()
{
    assertEquals(expected, actual, message);
}
{

}

}

