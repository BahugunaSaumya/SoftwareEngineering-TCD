

import java.util.*;


//import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;

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

public
Scanner sc =new Scanner(System.in); 
static Node r = null;

    public static Node Insert(int item){

        Node temp=new Node(item);
    
        if (r == null)
         {r = temp;}
    
        Node prev, cur;
        prev=null;
        cur=r;
        while(cur!=null)            /* traverse until correct position is found*/
        {
            prev=cur;
            if (item==cur.d && item!=0){
                System.out.println("Duplicates Not allowed");
                temp=null;
                return null;
            }
            else if (item<cur.d)
                    cur=cur.l;
                 else
                    cur=cur.ri;
        }
        if (item<prev.d)
            prev.l = temp;
        else
            prev.ri = temp;
        
        return temp;
    }
   public static boolean Search (int item){
        Node temp = r;
        while(temp != null)
        {
            if (temp.d == item)
                { return true;}
            else
            {
                if (item<temp.d)
                
                temp=temp.l;
                else{
                    temp=temp.ri; }
        }
       
    }
        return false;
}
    public static Node LCA(int x, int y)
    {
        // return if the tree is empty or `x` or `y` is not present
        // in the tree
        if (r == null || !Search(x) || !Search(y)) {
            return null;
        }
 
        // start from the root node
        Node curr = r;
 
        // traverse the tree
        while (curr != null)
        {
            // if both `x` and `y` is smaller than the root, LCA exists in the
            // left subtree
            if (curr.d > Integer.max(x, y)) {
                curr = curr.l;
            }
 
            // if both `x` and `y` are greater than the root, LCA exists in the
            // right subtree
            else if (curr.d < Integer.min(x, y)) {
                curr = curr.ri;
            }
 
            // if one key is greater (or equal) than the root and one key is
            // smaller (or equal) than the root, then the current node is LCA
            else {
                return curr;
            }
        }
        return curr;
    }

    Node Create(int item){
        int x,c;
        Node temp=new Node(item);

        //Node y;
        if (item>0)
        {
            if (r == null)
            {r = temp; }
       
    
            System.out.println("Enter next item after "+item+" ");
            x=sc.nextInt();
        
            Node v=Insert(x);
             if(v!=null){
                  c=x;
                Create(x);
             }
             else{
                 
             }
            System.out.println("Enter next item after "+item+" ");
            x=sc.nextInt();
            Insert(x);
            Create(x);
            return null;
            
        }


        return null;
     

        
    
    
    }



    void Createtree(){

        int item;
       
        System.out.println("Creating the Binary search tree , enter appropriate values: ");
        item =sc.nextInt();
        //Insert(item);
        Create(item);
        int a,b;
         System.out.println(" Enter 0 to EXIT!!");
           
      
         System.out.println("Enter the nodes to be checked");
        
         a=sc.nextInt();  
         while(a!=0){   
        b=sc.nextInt();
        Node lca =LCA(a,b);
        if(lca!=null){
            System.out.println("Lowest common ancestor is = " +lca.d);
        }

        else {
            System.out.println("No Lowest ancestor found");
        }
    }
    


    }
/*

    static class NW
        {
            public Node n;
            NW(Node n){
            this.n=n;
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

*/
public static void main(String[] args)
{

Main m = new Main();

m.Createtree();




    /*

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
// this is just to test the auto Commit feature
*/
}

}

