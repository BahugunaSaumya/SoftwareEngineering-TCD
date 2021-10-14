class Node:
    def __init__(self, d, l=None, ri=None):
        self.d = d
        self.l = l
        self.ri = ri
 
 

def CheckNode(root, node):
 

    if root is None:
        return False

    if root == node:
        return True
    return CheckNode(root.l, node) or CheckNode(root.ri, node)
 
 
def Findlca(root, lca, x, y):
 
    
    if root is None:
        return False, lca
 
    if root == x or root == y:
        return True, root
 
    
    l, lca = Findlca(root.l, lca, x, y)
 
   
    ri, lca = Findlca(root.ri, lca, x, y)
 
    
    if l and ri:

        
        lca = root
 

    return (l or ri), lca
 
 

def FindLCA(root, x, y):
 
    
    lca = None
 
    
    if CheckNode(root, y) and CheckNode(root, x):
        lca = Findlca(root, lca, x, y)[1]
 
  
    if lca:
       # print("LCA is", lca.d)
        return lca.d
    else:
     #   print("LCA does not exist")
        return 0

#
if __name__ == '__main__':
 
    
 """"
    root = Node(90)
    root.l = Node(48)
    root.ri = Node(92)
    root.l.ri = Node(50)
    root.ri.l = Node(91)
    root.ri.ri = Node(93)
    root.ri.l.l = Node(90.5)
    root.ri.ri.ri = Node(94)
 
    FindLCA(root, root.ri.l.l, root.ri.ri)
    FindLCA(root, root.ri.l.l, Node(100))
    FindLCA(root, root.ri.l.l, root.ri.l.l)
    FindLCA(root, root.ri.l.l, root.ri.l)
    FindLCA(root, root.l, root.ri.l) # """