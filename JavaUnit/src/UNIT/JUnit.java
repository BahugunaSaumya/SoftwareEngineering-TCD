package UNIT;

//	import java.util.*;


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
 
    public static int FindLCA(Node r, Node x, Node y)
    {
        
        Node lca = null;
 
       
        
        NW LCA = new NW(lca);
 
        if (Nodecheck(r, y) && Nodecheck(r, x))
        {
            FindLCA(r, LCA, x, y);
            lca = LCA.n;
        }
 
        
        if (lca != null) {
            System.out.println(lca.d);
        	return lca.d;
            
        }
        else {
            return 0;
        }
    

    }

}