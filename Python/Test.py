import unittest
import LCA as b 
 #from LCA import Node
root = b.Node(90)
root.l = b.Node(48)
root.ri = b.Node(92)
root.l.ri = b.Node(50)
root.ri.l = b.Node(91)
root.ri.ri = b.Node(93)
root.ri.l.l = b.Node(90.5)
root.ri.ri.ri = b.Node(94)
e = b.Node(15)
e.l = b.Node(10)                                     #constructing a different tree to check the code
e.ri = b.Node(25)
e.l.ri = b.Node(12)
e.ri.l = b.Node(20)
e.ri.ri = b.Node(30)
e.ri.l.l = b.Node(18)
e.ri.l.l.ri = b.Node(22)
e.l.l= b.Node(8)
e.l.l.l= b.Node(6)
e.l.l.ri=b.Node(9)
"""
b.FindLCA(root, root.ri.l.l, root.ri.ri)
b.FindLCA(root, root.ri.l.l, b.Node(100))
b.FindLCA(root, root.ri.l.l, root.ri.l.l)
b.FindLCA(root, root.ri.l.l, root.ri.l)
b.FindLCA(root, root.l, root.ri.l)
"""
class LCATest(unittest.TestCase):
 def test_Node(self):
  self.assertEqual(b.FindLCA(root, root.l, root.ri.l),90)
  self.assertEqual(b.FindLCA(root, root.ri.l.l, root.ri.l.l),90.5)


 def test_Node2(self):
  self.assertEqual(b.FindLCA(root, root.ri.l.l, b.Node(100)),0)
  self.assertEqual(b.FindLCA(e, e.l.l.l, e.l.ri),10)
 
 def test_Node3(self):
  self.assertEqual(b.FindLCA(e,e.ri.l,e.l.l.l),15) 
  self.assertEqual(b.FindLCA(e, e.ri.l.l, e.ri.ri),25)
  
  
  
  
  
  if __name__ == '__main__':
     unittest.main()
