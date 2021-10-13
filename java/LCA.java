package java;


import java.util.*;


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

    public static Node Insert(int item){            //This function inserts the number by traversing to the left if the number is less than the 
                                                //root and to right if the number is greater than root regardless of the sequence it is entered in
        Node temp=new Node(item);
    
        if (r == null)
         {r = temp;}
    
        Node prev, cur;
        prev=null;
        cur=r;
        while(cur!=null)            
        {
            prev=cur;
            if (item==cur.d && item!=0){
                System.out.println("Duplicates Not allowed");           // it also checks for the duplicate entries
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
       
        if (r == null || !Search(x) || !Search(y)) {
            return null;
        }
 

        Node curr = r;
 
      
        while (curr != null)
        {
        
            if (curr.d > Integer.max(x, y)) {
                curr = curr.l;
            }
 
           
            else if (curr.d < Integer.min(x, y)) {
                curr = curr.ri;
            }
 
            else {
                return curr;
            }
        }
        return curr;
    }

    Node Create(int item){                                     //This function assigns root and calls insert if the item is not zero
        int x;
        Node temp=new Node(item); 

                                                                                     
        if (item>0)
        {
            if (r == null)
            {r = temp; }
       
            System.out.println("Enter next item after "+item+" ");                            
            x=sc.nextInt();
            Node v=Insert(x);
             if(v!=null){                                             // as the insert function returns null for a duplicate entry 
                                                                       // this statement recursively calls itself with the non duplicate number 
                  
                Create(x);
             }
             else{
                  Create(item);
             }
            System.out.println("Enter next item after "+item+" ");
            x=sc.nextInt();
            v=Insert(x);
            if(v!=null){
                  
                Create(x);
             }
             else{
                  Create(item);
             }
            return null;
            
        }
    

        return null;
     

        
    
    
    }
    void Createtree(){

        int item;                                    // This function is to call the create function to minimize statements in the main function
       
        System.out.println("Creating the Binary search tree , enter appropriate values: ");
        item =sc.nextInt();
        Create(item);
        int a,b;
         System.out.println(" Enter 0 to EXIT!!");
           int t= sc.nextInt();
         while(t!=0){ 
            
         System.out.println("Enter the nodes to be checked");             //}
        
         a=sc.nextInt();  
                                                                      // These  statemets asks after every call to LCA if the user wans to countinue or exit  
        b=sc.nextInt();
        Node lca =LCA(a,b);
        if(lca!=null){
            System.out.println("Lowest common ancestor is = " +lca.d);
        }

        else {
            System.out.println("No Lowest ancestor found");
        }
        System.out.println(" Enter 0 to EXIT!!");
            t=sc.nextInt();                                                  // }
        
    }return;
    
    

    }

public static void main(String[] args)
{

Main m = new Main();

m.Createtree();


}

}
