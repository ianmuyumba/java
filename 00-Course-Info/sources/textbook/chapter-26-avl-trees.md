# Chapter 26 AVL Trees

[Source index](README.md) · [Unit lesson](../../README.md)

> Source: Java eBook - Introduction to Java Programming - 10th Edition.pdf

> Searchable PDF transcription. Page text preserves extraction order; diagrams, table alignment and code indentation may require the archived PDF. Use the unit README for edited study notes.


## PDF page 988

<details>
<summary>Page text</summary>

```text
AVL TREES
Objectives
■ To know what an AVL tree is (§26.1).
■ To understand how to rebalance a tree using the LL rotation, 
LR rotation, RR rotation, and RL rotation (§26.2).
■ To design the AVLTree class by extending the BST class (§26.3).
■ To insert elements into an AVL tree (§26.4).
■ To implement tree rebalancing (§26.5).
■ To delete elements from an AVL tree (§26.6).
■ To implement the AVLTree class (§26.7).
■ To test the AVLTree class (§26.8).
■ To analyze the complexity of search, insertion, and deletion operations 
in AVL trees (§26.9).
CHAPTER
26
```

</details>


## PDF page 989

<details>
<summary>Page text</summary>

```text
966 Chapter 26  AVL Trees
26.1 Introduction
AVL Tree is a balanced binary search tree.
Chapter  25 introduced binary search trees. The search, insertion, and deletion times for a 
binary tree depend on the height of the tree. In the worst case, the height is O(n). If a tree 
is perfectly balanced –i.e., a complete binary tree—its height is log n. Can we maintain a 
perfectly balanced tree? Yes, but doing so will be costly. The compromise is to maintain a 
well-balanced tree—that is, the heights of every node’s two subtrees are about the same. This 
chapter introduces AVL trees. Web Chapters 40 and 41 introduce 2–4 trees and red–black trees.
AVL trees are well balanced. AVL trees were invented in 1962 by two Russian computer 
scientists, G. M. Adelson-Velsky and E. M. Landis (hence the name AVL). In an AVL tree, 
the difference between the heights of every node’s two subtrees is 0 or 1. It can be shown that 
the maximum height of an AVL tree is O(log n).
The process for inserting or deleting an element in an AVL tree is the same as in a regular 
binary search tree, except that you may have to rebalance the tree after an insertion or dele-
tion operation. The balance factor of a node is the height of its right subtree minus the height 
of its left subtree. A node is said to be balanced if its balance factor is -1,0, or 1. A node is 
considered left-heavy if its balance factor is -1, and right-heavy if its balance factor is +1.
Pedagogical Note
For an interactive GUI demo to see how an AVL tree works, go to www.cs.armstrong.edu/
liang/animation/web/AVLTree.html, as shown in Figure 26.1.
Key
Point
perfectly balanced tree
well-balanced tree
AVL tree
O(log n)
balance factor
balanced
left-heavy
right-heavy
AVL tree animation on 
Companion Website
FIGURE 26.1 The animation tool enables you to insert, delete, and search elements.
26.2 Rebalancing Trees
After inserting or deleting an element from an AVL tree, if the tree becomes 
unbalanced, perform a rotation operation to rebalance the tree.
If a node is not balanced after an insertion or deletion operation, you need to rebalance it. The 
process of rebalancing a node is called rotation. There are four possible rotations: LL, RR, 
LR, and RL.
Key
Point
rotation
```

</details>


## PDF page 990

<details>
<summary>Page text</summary>

```text
26.2 Rebalancing Trees  967
LL rotation: An LL imbalance occurs at a node A, such that A has a balance factor of -2
and a left child B with a balance factor of -1 or 0, as shown in Figure 26.2a. This type of 
imbalance can be fixed by performing a single right rotation at A, as shown in Figure 26.2b.
RR rotation: An RR imbalance occurs at a node A,  such that A has a balance factor of 
+2 and a right child B with a balance factor of +1 or 0, as shown in Figure 26.3a. This type 
of imbalance can be fixed by performing a single left rotation at A, as shown in Figure 26.3b.
LL rotation
LL imbalance
RR rotation
RR imbalance
FIGURE 26.2 An LL rotation fixes an LL imbalance.
A /H110022
B/H110021 or 0
T2
T3
T1h /H11001 1
h
h
T2’s height is h or
h /H11001 1
T2’s height is h or
h /H11001 1
h /H11001 1
A 0 or /H110021
B0 or 1
T2 T3
T1
hh
(a) (b)
FIGURE 26.3 An RR rotation fixes an RR imbalance.
A /H110012
B /H110011 or 0
T2
T3
T1 h /H11001 1
h
h
T2’s height is
h or h /H11001 1
T2’s height is
h or h /H11001 1
h /H11001 1
A0 or /H110011
B 0 or /H110021
T2T3
T1
hh
(a) (b)
LR rotation: An LR imbalance occurs at a node A,  such that A has a balance factor of -2
and a left child B with a balance factor of +1, as shown in Figure 26.4a. Assume B’s right child 
isC. This type of imbalance can be fixed by performing a double rotation (first a single left 
rotation at B and then a single right rotation at A), as shown in Figure 26.4b.
RL rotation: An RL imbalance occurs at a node A,  such that A has a balance factor of +2
and a right child B with a balance factor of -1, as shown in Figure 26.5a. Assume B’s left child 
isC. This type of imbalance can be fixed by performing a double rotation (first a single right 
rotation at B and then a single left rotation at A), as shown in Figure 26.5b.
26.1 What is an AVL tree? Describe the following terms: balance factor, left-heavy, and 
right-heavy.
26.2 Show the balance factor of each node in the trees shown in Figure 26.6.
26.3 Describe LL rotation, RR rotation, LR rotation, and RL rotation for an AVL tree.
LR rotation
LR imbalance
RL rotation
RL imbalance
✓Point✓
Check
```

</details>


## PDF page 991

<details>
<summary>Page text</summary>

```text
968 Chapter 26  AVL Trees
FIGURE 26.4 An LR rotation fixes an LR imbalance.
B0 or /H110021 0 or 1
C 0
T2T1 hh
A
T4T3 hh
(a) (b)
A /H110022
B/H110011
T1
T4
h
h
/H110021, 0 or 1C
T3T2 hh
T2 and T3 may have
different heights, but
at least one has
height of h.
FIGURE 26.5 An RL rotation fixes an RL imbalance.
A0 or /H110021 0 or 1
C 0
T2T1 hh
B
T4T3 hh
(a) (b)
A /H110012
B/H110021
T4
T1
h
h
0, /H110021, or 1 C
T3T2 hh
T2 and T3 may have
different heights, but
at least one 
has height of h.
FIGURE 26.6 A balance factor determines whether a node is balanced.
(a) (b)
55
60
45
100
67 107
87
55
60
45
100
67 107
87 187105
```

</details>


## PDF page 992

<details>
<summary>Page text</summary>

```text
26.3 Designing Classes for AVL Trees  969
26.3 Designing Classes for AVL Trees
Since an AVL tree is a binary search tree, AVLTree is designed as a subclass of BST.
An AVL tree is a binary tree, so you can define the AVLTree class to extend the BST class, as 
shown in Figure 26.7. TheBST and TreeNode classes were defined in Section 25.2.5.
Key
Point
FIGURE 26.7 TheAVLTree class extends BST with new implementations for the insert and delete methods.
AVLTree<E extends Comparable<E>>
+AVLTree()
+AVLTree(objects: E[])
#createNewNode(): AVLTreeNode<E>
+insert(e: E): boolean
+delete(e: E): boolean
-updateHeight(node:
  AVLTreeNode<E>): void
Creates an empty AVL tree.
Creates an AVL tree from an array of objects.
Overrides this method to create an AVLTreeNode.
Returns true if the element is added successfully.
Balances the nodes in the path from the node for
     the element to the root if needed.
BST<E extends Comparable<E>>
1
m
Link
0
-balancePath(e: E): void
Returns the balance factor of the node.-balanceFactor(node:
  AVLTreeNode<E>): int
Performs LL balance.-balanceLL(A: TreeNode,
  parentOfA: TreeNode<E>): void
Performs LR balance.-balanceLR(A: TreeNode<E>,
  parentOfA: TreeNode<E>): void
Performs RR balance.-balanceRR(A: TreeNode<E>,
  parentOfA: TreeNode<E>): void
Performs RL balance.-balanceRL(A: TreeNode<E>,
  parentOfA: TreeNode<E>): void
AVLTreeNode<E>
#height: int
TreeNode<E>
Returns true if the element is removed from the
     tree successfully.
Resets the height of the specified node.
In order to balance the tree, you need to know each node’s height. For convenience, store 
the height of each node in AVLTreeNode and define AVLTreeNode to be a subclass of 
BST.TreeNode. Note that TreeNode is defined as a static inner class in BST.AVLTreeNode
will be defined as a static inner class in AVLTree.TreeNode contains the data fields element,
left, and right, which are inherited by AVLTreeNode. Thus, AVLTreeNode contains four 
data fields, as shown in Figure 26.8.
AVLTreeNode
FIGURE 26.8 AnAVLTreeNode contains the protected data fields element,height,
left, and right.
#element: E
#height: int
#left: TreeNode<E>
#right: TreeNode<E>
node: AVLTreeNode<E>
```

</details>


## PDF page 993

<details>
<summary>Page text</summary>

```text
970 Chapter 26  AVL Trees
In the BST class, the createNewNode() method creates a TreeNode object. This method 
is overridden in the AVLTree class to create an AVLTreeNode. Note that the return type 
of the createNewNode() method in the BST class is TreeNode, but the return type of 
the createNewNode() method in the AVLTree class is AVLTreeNode. This is fine, since 
AVLTreeNode is a subclass of TreeNode.
Searching for an element in an AVLTree is the same as searching in a regular binary tree, 
so the search method defined in the BST class also works for AVLTree.
Theinsert and delete methods are overridden to insert and delete an element and per-
form rebalancing operations if necessary to ensure that the tree is balanced.
26.4 What are the data fields in the AVLTreeNode class?
26.5 True or false: AVLTreeNode is a subclass of TreeNode?
26.6 True or false: AVLTree is a subclass of BST.
26.4 Overriding the insert Method
Inserting an element into an AVL tree is the same as inserting it to a BST, except that 
the tree may need to be rebalanced.
A new element is always inserted as a leaf node. As a result of adding a new node, the heights 
of the new leaf node’s ancestors may increase. After inserting a new node, check the nodes 
along the path from the new leaf node up to the root. If an unbalanced node is found, perform 
an appropriate rotation using the algorithm in Listing 26.1.
LISTING 26.1 Balancing Nodes on a Path
 1  balancePath(E e) {
 2    Get the path from the node that contains element e to the root, 
 3      as illustrated in Figure 26.9;
 4 for each node A in the path leading to the root {
 5      Update the height of A; 
 6      Let parentOfA denote the parent of A, 
 7        which is the next node in the path, or null if A is the root;
 8
 9 switch (balanceFactor(A)) {
10 case -2: if balanceFactor(A.left) == -1 or 0
11                   Perform LL rotation; // See Figure 26.2
12 else
13                   Perform LR rotation; // See Figure 26.4
14 break;
15 case +2: if balanceFactor(A.right) == +1 or 0
16                   Perform RR rotation; // See Figure 26.3
17 else
18                   Perform RL rotation; // See Figure 26.5
19      } // End of switch
20    } // End of for
21  } // End of method
The algorithm considers each node in the path from the new leaf node to the root. Update 
the height of the node on the path. If a node is balanced, no action is needed. If a node is not 
balanced, perform an appropriate rotation.
26.7 For the AVL tree in Figure 26.6a, show the new AVL tree after adding element 40.
What rotation do you perform in order to rebalance the tree? Which node was 
unbalanced?
createNewNode()
✓Point✓
Check
Key
Point
get the path
update node height
get parent node
is balanced?
LL rotation
LR rotation
RR rotation
RL rotation
✓Point✓
Check
```

</details>


## PDF page 994

<details>
<summary>Page text</summary>

```text
26.5 Implementing Rotations  971
26.8 For the AVL tree in Figure  26.6a, show the new AVL tree after adding element 
50. What rotation do you perform in order to rebalance the tree? Which node was 
unbalanced?
26.9 For the AVL tree in Figure  26.6a, show the new AVL tree after adding element 
80. What rotation do you perform in order to rebalance the tree? Which node was 
unbalanced?
26.10 For the AVL tree in Figure  26.6a, show the new AVL tree after adding element 
89. What rotation do you perform in order to rebalance the tree? Which node was 
unbalanced?
26.5 Implementing Rotations
An unbalanced tree becomes balanced by performing an appropriate rotation operation.
Section 26.2, Rebalancing Trees, illustrated how to perform rotations at a node. Listing 26.2 
gives the algorithm for the LL rotation, as illustrated in Figure 26.2.
LISTING 26.2 LL Rotation Algorithm
 1  balanceLL(TreeNode A, TreeNode parentOfA) {
 2    Let B be the left child of A. 
 3
 4 if (A is the root) 
 5      Let B be the new root
 6 else {
 7 if (A is a left child of parentOfA)
 8        Let B be a left child of parentOfA;
 9 else
10        Let B be a right child of parentOfA;
11    }
12
13    Make T2 the left subtree of A by assigning B.right to A.left; 
14    Make A the right child of B by assigning A to B.right;
15    Update the height of node A and node B; 
16  } // End of method
Note that the height of nodes A and B can be changed, but the heights of other nodes in the 
tree are not changed. You can implement the RR, LR, and RL rotations in a similar manner.
Key
Point
left child of A
reconnect B’s parent
move subtrees
adjust height
FIGURE 26.9 The nodes along the path from the new leaf node may become unbalanced.
New node contains element e
root
parentOfA
A
```

</details>


## PDF page 995

<details>
<summary>Page text</summary>

```text
972 Chapter 26  AVL Trees
26.6 Implementing the delete Method
Deleting an element from an AVL tree is the same as deleing it from a BST, except that 
the tree may need to be rebalanced.
As discussed in Section 25.3, Deleting Elements from a BST, to  delete an element from a 
binary tree, the algorithm first locates the node that contains the element. Let current point 
to the node that contains the element in the binary tree and parent point to the parent of the 
current node. The current node may be a left child or a right child of the parent node. 
Two cases arise when deleting an element.
Case 1: The current node does not have a left child, as shown in Figure 25.10a. To delete 
the current node, simply connect the parent node with the right child of the current
node, as shown in Figure 25.10b.
The height of the nodes along the path from the parent node up to the root may have 
decreased. To ensure that the tree is balanced, invoke
balancePath(parent.element); // Defined in Listing 26.1
Case 2: The current node has a left child. Let rightMost point to the node that contains 
the largest element in the left subtree of the current node and parentOfRightMost point 
to the parent node of the rightMost node, as shown in Figure 25.12a. The rightMost node 
cannot have a right child but it may have a left child. Replace the element value in the current
node with the one in the rightMost node, connect the parentOfRightMost node with the 
left child of the rightMost node, and delete the rightMost node, as shown in Figure 25.12b.
The height of the nodes along the path from parentOfRightMost up to the root may have 
decreased. To ensure that the tree is balanced, invoke
balancePath(parentOfRightMost); // Defined in Listing 26.1
26.11 For the AVL tree in Figure 26.6a, show the new AVL tree after deleting element 
107. What rotation do you perform in order to rebalance the tree? Which node was 
unbalanced?
26.12 For the AVL tree in Figure  26.6a, show the new AVL tree after deleting element 
60. What rotation do you perform in order to rebalance the tree? Which node was 
unbalanced?
26.13 For the AVL tree in Figure 26.6a, show the new AVL tree after deleting element 55. What 
rotation did you perform in order to rebalance the tree? Which node was unbalanced?
26.14 For the AVL tree in Figure 26.6b, show the new AVL tree after deleting elements 67
and 87. What rotation did you perform in order to rebalance the tree? Which node 
was unbalanced?
26.7 The AVLTree Class
TheAVLTree class extends the BST class to override the insert and delete
methods to rebalance the tree if necessary.
Listing 26.3 gives the complete source code for the AVLTree class.
LISTING 26.3 AVLTree.java
  1 public class AVLTree<E extends Comparable<E>> extends BST<E> {
  2 /** Create an empty AVL tree */
  3 public AVLTree() {
Key
Point
✓Point✓
Check
Key
Point
no-arg constructor
```

</details>


## PDF page 996

<details>
<summary>Page text</summary>

```text
26.7 The AVLTree Class 973
  4    }
  5
  6 /** Create an AVL tree from an array of objects */
  7 public AVLTree(E[] objects) {
  8 super(objects);
  9    }
 10
 11    @Override /** Override createNewNode to create an AVLTreeNode */
 12 protected AVLTreeNode<E> createNewNode(E e) {
 13 return new AVLTreeNode<E>(e);
 14    }
 15
 16    @Override /** Insert an element and rebalance if necessary */
 17 public boolean insert(E e) {
 18 boolean successful = super.insert(e);
 19 if (!successful)
 20 return false; // e is already in the tree
 21 else {
 22        balancePath(e); // Balance from e to the root if necessary
 23      }
 24
 25 return true; // e is inserted
 26    }
 27
 28 /** Update the height of a specified node */
 29 private void updateHeight(AVLTreeNode<E> node) {
 30 if (node.left == null && node.right == null) // node is a leaf
 31        node.height = 0;
 32 else if (node.left == null) // node has no left subtree
 33        node.height = 1 + ((AVLTreeNode<E>)(node.right)).height;
 34 else if (node.right == null) // node has no right subtree
 35        node.height = 1 + ((AVLTreeNode<E>)(node.left)).height;
 36 else
 37        node.height = 1 +
 38          Math.max(((AVLTreeNode<E>)(node.right)).height,
 39          ((AVLTreeNode<E>)(node.left)).height);
 40    }
 41
 42 /** Balance the nodes in the path from the specified
 43 * node to the root if necessary
 44 */
 45 private void balancePath(E e) {
 46      java.util.ArrayList<TreeNode<E>> path = path(e); 
 47 for (int i = path.size() - 1; i >= 0; i—–) {
 48        AVLTreeNode<E> A = (AVLTreeNode<E>)(path.get(i)); 
 49        updateHeight(A); 
 50        AVLTreeNode<E> parentOfA = (A == root) ? null : 
 51          (AVLTreeNode<E>)(path.get(i - 1));
 52
 53 switch (balanceFactor(A)) {
 54 case -2:
 55 if (balanceFactor((AVLTreeNode<E>)A.left) <= 0) {
 56              balanceLL(A, parentOfA); // Perform LL rotation
 57            }
 58 else {
 59              balanceLR(A, parentOfA); // Perform LR rotation
 60            }
 61 break;
 62 case +2:
constructor
create AVL tree node
override insert
balance tree
update node height
balance nodes
get path
consider a node
update height
get height
left-heavy
LL rotation
LR rotation
right-heavy
```

</details>


## PDF page 997

<details>
<summary>Page text</summary>

```text
974 Chapter 26  AVL Trees
 63 if (balanceFactor((AVLTreeNode<E>)A.right) >= 0) {
 64              balanceRR(A, parentOfA); // Perform RR rotation
 65            }
 66 else {
 67              balanceRL(A, parentOfA); // Perform RL rotation
 68            }
 69        }
 70      }
 71    }
 72
 73 /** Return the balance factor of the node */
 74 private int balanceFactor(AVLTreeNode<E> node) {
 75 if (node.right == null) // node has no right subtree
 76 return -node.height;
 77 else if (node.left == null) // node has no left subtree
 78 return +node.height;
 79 else
 80 return ((AVLTreeNode<E>)node.right).height -
 81          ((AVLTreeNode<E>)node.left).height;
 82    }
 83
 84 /** Balance LL (see Figure 26.2) */
 85 private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
 86      TreeNode<E> B = A.left; // A is left-heavy and B is left-heavy
 87
 88 if (A == root) {
 89        root = B;
 90      }
 91 else {
 92 if (parentOfA.left == A) {
 93          parentOfA.left = B;
 94        }
 95 else {
 96          parentOfA.right = B;
 97        }
 98      }
 99
100      A.left = B.right; // Make T2 the left subtree of A
101      B.right = A; // Make A the left child of B
102      updateHeight((AVLTreeNode<E>)A); 
103      updateHeight((AVLTreeNode<E>)B);
104    }
105
106 /** Balance LR (see Figure 26.4) */
107 private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
108      TreeNode<E> B = A.left; // A is left-heavy
109      TreeNode<E> C = B.right; // B is right-heavy
110
111 if (A == root) {
112        root = C;
113      }
114 else {
115 if (parentOfA.left == A) {
116          parentOfA.left = C;
117        }
118 else {
119          parentOfA.right = C;
120        }
RR rotation
RL rotation
get balance factor
LL rotation
update height
LR rotation
```

</details>


## PDF page 998

<details>
<summary>Page text</summary>

```text
26.7 The AVLTree Class 975
121      }
122
123      A.left = C.right; // Make T3 the left subtree of A
124      B.right = C.left; // Make T2 the right subtree of B
125      C.left = B;
126      C.right = A;
127
128 // Adjust heights
129      updateHeight((AVLTreeNode<E>)A); 
130      updateHeight((AVLTreeNode<E>)B);
131      updateHeight((AVLTreeNode<E>)C);
132    }
133
134 /** Balance RR (see Figure 26.3) */
135 private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
136      TreeNode<E> B = A.right; // A is right-heavy and B is right-heavy
137
138 if (A == root) {
139        root = B;
140      }
141 else {
142 if (parentOfA.left == A) {
143          parentOfA.left = B;
144        }
145 else {
146          parentOfA.right = B;
147        }
148      }
149
150      A.right = B.left; // Make T2 the right subtree of A
151      B.left = A;
152      updateHeight((AVLTreeNode<E>)A); 
153      updateHeight((AVLTreeNode<E>)B);
154    }
155
156 /** Balance RL (see Figure 26.5) */
157 private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
158      TreeNode<E> B = A.right; // A is right-heavy
159      TreeNode<E> C = B.left; // B is left-heavy
160
161 if (A == root) {
162        root = C;
163      }
164 else {
165 if (parentOfA.left == A) {
166          parentOfA.left = C;
167        }
168 else {
169          parentOfA.right = C;
170        }
171      }
172
173      A.right = C.left; // Make T2 the right subtree of A
174      B.left = C.right; // Make T3 the left subtree of B
175      C.left = A;
176      C.right = B;
177
178 // Adjust heights
update height
RR rotation
update height
RL rotation
```

</details>


## PDF page 999

<details>
<summary>Page text</summary>

```text
976 Chapter 26  AVL Trees
179      updateHeight((AVLTreeNode<E>)A); 
180      updateHeight((AVLTreeNode<E>)B);
181      updateHeight((AVLTreeNode<E>)C);
182    }
183
184    @Override /** Delete an element from the AVL tree.
185 * Return true if the element is deleted successfully
186 * Return false if the element is not in the tree */
187 public boolean delete(E element) {
188 if (root == null)
189 return false; // Element is not in the tree
190
191 // Locate the node to be deleted and also locate its parent node
192      TreeNode<E> parent = null;
193      TreeNode<E> current = root;
194 while (current != null) {
195 if (element.compareTo(current.element) < 0) {
196          parent = current;
197          current = current.left;
198        }
199 else if (element.compareTo(current.element) > 0) {
200          parent = current;
201          current = current.right;
202        }
203 else
204 break; // Element is in the tree pointed by current
205      }
206
207 if (current == null)
208 return false; // Element is not in the tree
209
210 // Case 1: current has no left children (See Figure 25.10)
211 if (current.left == null) {
212 // Connect the parent with the right child of the current node
213 if (parent == null) {
214          root = current.right;
215        }
216 else {
217 if (element.compareTo(parent.element) < 0)
218            parent.left = current.right;
219 else
220            parent.right = current.right;
221
222 // Balance the tree if necessary
223          balancePath(parent.element); 
224        }
225      }
226 else {
227 // Case 2: The current node has a left child
228 // Locate the rightmost node in the left subtree of
229 // the current node and also its parent
230        TreeNode<E> parentOfRightMost = current;
231        TreeNode<E> rightMost = current.left;
232
233 while (rightMost.right != null) {
234          parentOfRightMost = rightMost;
235          rightMost = rightMost.right; // Keep going to the right
236        }
237
update height
override delete
balance nodes
```

</details>


## PDF page 1000

<details>
<summary>Page text</summary>

```text
26.7 The AVLTree Class 977
238 // Replace the element in current by the element in rightMost
239        current.element = rightMost.element;
240
241 // Eliminate rightmost node
242 if (parentOfRightMost.right == rightMost)
243          parentOfRightMost.right = rightMost.left;
244 else
245 // Special case: parentOfRightMost is current
246          parentOfRightMost.left = rightMost.left; 
247
248 // Balance the tree if necessary
249        balancePath(parentOfRightMost.element); 
250      }
251
252      size—–;
253 return true; // Element inserted
254    }
255
256 /** AVLTreeNode is TreeNode plus height */
257 protected static class AVLTreeNode<E extends Comparable<E>>
258 extends BST.TreeNode<E> {
259 protected int height = 0; // New data field
260
261 public AVLTreeNode(E e) {
262 super(e);
263      }
264    }
265  } 
The AVLTree class extends BST. Like the BST class, the AVLTree class has a no-arg 
constructor that constructs an empty AVLTree (lines 3–4) and a constructor that creates an 
initialAVLTree from an array of elements (lines 7–9).
The createNewNode() method defined in the BST class creates a TreeNode. This 
method is overridden to return an AVLTreeNode (lines 12–14).
The insert method in AVLTree is overridden in lines 17–26. The method first invokes 
theinsert method in BST, then invokes balancePath(e) (line 22) to ensure that the tree 
is balanced.
The balancePath method first gets the nodes on the path from the node that contains 
elemente to the root (line 46). For each node in the path, update its height (line 49), check its 
balance factor (line 53), and perform appropriate rotations if necessary (lines 53–69).
Four methods for performing rotations are defined in lines 85–182. Each method is invoked 
with two TreeNode arguments—A and parentOfA—to perform an appropriate rotation at 
nodeA. How each rotation is performed is illustrated in Figures 26.2–26.5. After the rotation, 
the heights of nodes A,B, and C are updated (lines 102, 129, 152, 179).
Thedelete method in AVLTree is overridden in lines 187–264. The method is the same 
as the one implemented in the BST class, except that you have to rebalance the nodes after 
deletion in two cases (lines 224, 249).
26.15 Why is the createNewNode method defined protected?
26.16 When is the updateHeight method invoked? When is the balanceFactor method 
invoked? When is the balancePath method invoked?
26.17 What are data fields in the AVLTree class?
26.18 In the insert and delete methods, once you have performed a rotation to balance 
a node in the tree, is it possible that there are still unbalanced nodes?
balance nodes
innerAVLTreeNode class
node height
constructors
insert
balancePath
rotations
delete
✓Point✓
Check
```

</details>


## PDF page 1001

<details>
<summary>Page text</summary>

```text
978 Chapter 26  AVL Trees
26.8 Testing the AVLTree Class
This section gives an example of using the AVLTree class.
Listing 26.4 gives a test program. The program creates an AVLTree initialized with an array 
of the integers 25,20, and 5 (lines 4–5), inserts elements in lines 9–18, and deletes elements 
in lines 22–28. Since AVLTree is a subclass of BST and the elements in a BST are iterable, the 
program uses a foreach loop to traverse all the elements in lines 33–35.
LISTING 26.4 TestAVLTree.java
 1 public class TestAVLTree {
 2 public static void main(String[] args) {
 3 // Create an AVL tree
 4 AVLTree<Integer> tree = new AVLTree<>(new Integer[]{25,
 5 20, 5});
 6      System.out.print("After inserting 25, 20, 5:");
 7      printTree(tree);
 8
 9      tree.insert(34);
10      tree.insert(50);
11      System.out.print("\nAfter inserting 34, 50:");
12      printTree(tree);
13
14      tree.insert(30);
15      System.out.print("\nAfter inserting 30");
16      printTree(tree);
17
18      tree.insert(10);
19      System.out.print("\nAfter inserting 10");
20      printTree(tree);
21
22 tree.delete( 34);
23      tree.delete(30);
24      tree.delete(50);
25      System.out.print("\nAfter removing 34, 30, 50:");
26      printTree(tree);
27
28      tree.delete(5);
29      System.out.print("\nAfter removing 5:");
30      printTree(tree);
31
32      System.out.print("\nTraverse the elements in the tree: ");
33 for (int e: tree) {
34        System.out.print(e + " ");
35      }
36    }
37
38 public static void printTree(BST tree) {
39 // Traverse tree
40      System.out.print("\nInorder (sorted): ");
41      tree.inorder();
41      System.out.print("\nPostorder: ");
43      tree.postorder();
44      System.out.print("\nPreorder: ");
45      tree.preorder();
46      System.out.print("\nThe number of nodes is " + tree.getSize());
Key
Point
create an AVLTree
insert 34
insert 50
insert 30
insert 10
delete 34
delete 30
delete 50
delete 5
for-each loop
```

</details>


## PDF page 1002

<details>
<summary>Page text</summary>

```text
26.8 Testing the AVLTree Class 979
Figure 26.10 shows how the tree evolves as elements are added to the tree. After 25 and 20
are added, the tree is as shown in Figure 26.10a. 5 is inserted as a left child of 20, as shown in 
Figure 26.10b. The tree is not balanced. It is left-heavy at node 25. Perform an LL rotation to 
result in an AVL tree, as shown in Figure 26.10c.
After inserting 34, the tree is shown in Figure 26.10d. After inserting 50, the tree is as 
shown in Figure 26.10e. The tree is not balanced. It is right-heavy at node 25. Perform an RR 
rotation to result in an AVL tree, as shown in Figure 26.10f.
After inserting 30, the tree is as shown in Figure 26.10g. The tree is not balanced. Perform 
an RL rotation to result in an AVL tree, as shown in Figure 26.10h.
After inserting 10, the tree is as shown in Figure 26.10i. The tree is not balanced. Perform 
an LR rotation to result in an AVL tree, as shown in Figure 26.10j.
After inserting 25, 20, 5:
Inorder (sorted): 5 20 25 
Postorder: 5 25 20 
Preorder: 20 5 25 
The number of nodes is 3
After inserting 34, 50:
Inorder (sorted): 5 20 25 34 50 
Postorder: 5 25 50 34 20 
Preorder: 20 5 34 25 50 
The number of nodes is 5
After inserting 30
Inorder (sorted): 5 20 25 30 34 50 
Postorder: 5 20 30 50 34 25 
Preorder: 25 20 5 34 30 50 
The number of nodes is 6
After inserting 10
Inorder (sorted): 5 10 20 25 30 34 50 
Postorder: 5 20 10 30 50 34 25 
Preorder: 25 10 5 20 34 30 50 
The number of nodes is 7
After removing 34, 30, 50:
Inorder (sorted): 5 10 20 25 
Postorder: 5 20 25 10 
Preorder: 10 5 25 20 
The number of nodes is 4
After removing 5:
Inorder (sorted): 10 20 25 
Postorder: 10 25 20 
Preorder: 20 10 25 
The number of nodes is 3
Traverse the elements in the tree: 10 20 25
47      System.out.println();
48    }
49  }
```

</details>


## PDF page 1003

<details>
<summary>Page text</summary>

```text
980 Chapter 26  AVL Trees
Figure 26.11 shows how the tree evolves as elements are deleted. After deleting 34, 30,
and50, the tree is as shown in Figure 26.11b. The tree is not balanced. Perform an LL rotation 
to result in an AVL tree, as shown in Figure 26.11c.
After deleting 5, the tree is as shown in Figure 26.11d. The tree is not balanced. Perform 
an RL rotation to result in an AVL tree, as shown in Figure 26.11e.
26.19 Show the change of an AVL tree when inserting 1,2,3,4,10,9,7,5,8,6 into the 
tree, in this order.
26.20 For the tree built in the preceding question, show its change after 1,2,3,4,10,9,7,
5,8,6 are deleted from the tree in this order.
26.21 Can you traverse the elements in an AVL tree using a foreach loop?
✓Point✓
Check
FIGURE 26.10 The tree evolves as new elements are inserted.
Need LL rotation
at node 25
Need RR rotation
at node 25
RL rotation at
node 20
LR rotation at
node 20
25
20 20
5
25
5
20
25 5
20
25
34
5
20
34
25 50
20
25
5
34
30 50 5
10
25
34
30 5020
5
20
25
34
50
20
25
5
34
30 50
10
5
20
34
25 50
30
(a) Insert 25, 20
(e) Insert 50 (f) Balanced (g) Insert 30
(h) Balanced (i) Insert 10 (j) Balanced
(b) Insert 5 (c) Balanced (d) Insert 34
```

</details>


## PDF page 1004

<details>
<summary>Page text</summary>

```text
26.9 AVL Tree Time Complexity Analysis  981
26.9 AVL Tree Time Complexity Analysis
Since the height of an AVL tree is O(log n), the time complexity of the search,
insert, and delete methods in AVLTree is O(log n).
The time complexity of the search,insert, and delete methods in AVLTree depends on 
the height of the tree. We can prove that the height of the tree is O(log n).
Let G(h) denote the minimum number of the nodes in an AVL tree with height h. Obvi-
ously, G(1) is 1 and G(2) is 2. The minimum number of nodes in an AVL tree with height 
h Ú 3 must have two minimum subtrees: one with height h - 1 and the other with height 
h - 2. Thus,
G(h) = G(h - 1) + G(h - 2) + 1
Recall that a Fibonacci number at index i can be described using the recurrence relation 
F(i) = F(i - 1) + F(i - 2). Therefore, the function G(h) is essentially the same as F(i). It 
can be proven that
h 6 1.4405 log(n + 2) - 1.3277
where n is the number of nodes in the tree. Hence, the height of an AVL tree is O(log n).
Thesearch,insert, and delete methods involve only the nodes along a path in the tree. 
TheupdateHeight and balanceFactor methods are executed in a constant time for each 
node in the path. The balancePath method is executed in a constant time for a node in the 
path. Thus, the time complexity for the search,insert, and delete methods is O(log n).
26.22 What is the maximum/minimum height for an AVL tree of 3 nodes, 5 nodes, and 7 
nodes?
26.23 If an AVL tree has a height of 3, what maximum number of nodes can the tree have? 
What minimum number of nodes can the tree have?
26.24 If an AVL tree has a height of 4, what maximum number of nodes can the tree have? 
What minimum number of nodes can the tree have?
Key
Point
tree height
✓Point✓
Check
FIGURE 26.11 The tree evolves as elements are deleted from the tree.
5
10
25
34
30 5020
5
10
25
205
10
25
20
(a) Delete 34, 30, 50 (b) After 34, 30, 50 are deleted
(d) After 5 is deleted (e) Balanced
(c) Balanced
LL rotation
at node 25
RL rotation at 10
10
20
25
20
25
10
```

</details>


## PDF page 1005

<details>
<summary>Page text</summary>

```text
982 Chapter 26  AVL Trees
CHAPTER SUMMARY
1. An AVL tree is a well-balanced binary tree. In an AVL tree, the difference between the 
heights of two subtrees for every node is 0 or 1.
2. The process for inserting or deleting an element in an AVL tree is the same as in a regu-
lar binary search tree. The difference is that you may have to rebalance the tree after an 
insertion or deletion operation.
3. Imbalances in the tree caused by insertions and deletions are rebalanced through subtree 
rotations at the node of the imbalance.
4. The process of rebalancing a node is called a rotation. There are four possible rotations: 
LL rotation, LR rotation, RR rotation, and RL rotation.
5. The height of an AVL tree is O(log n). Therefore, the time complexities for the search,
insert, and delete methods are O(log n).
QUIZ
Answer the quiz for this chapter online at www.cs.armstrong.edu/liang/intro10e/quiz.html.
PROGRAMMING EXERCISES
*26.1 (Display AVL tree graphically) Write a program that displays an A VL tree along 
with its balance factor for each node.
26.2 (Compare performance) Write a test program that randomly generates 500,000 
numbers and inserts them into a BST, reshuffles the 500,000 numbers and per-
forms a search, and reshuffles the numbers again before deleting them from 
the tree. Write another test program that does the same thing for an AVLTree.
Compare the execution times of these two programs.
***26.3 (AVL tree animation ) Write a program that animates the A VL tree insert,
delete, and search methods, as shown in Figure 26.1.
**26.4 (Parent reference forBST) Suppose that the TreeNode class defined in BST con-
tains a reference to the node’s parent, as shown in Programming Exercise 25.15.
Implement the AVLTree class to support this change. Write a test program that 
adds numbers 1,2, . . . , 100 to the tree and displays the paths for all leaf nodes.
**26.5 (The kth smallest element ) You can find the kth smallest element in a BST in 
O(n) time from an inorder iterator. For an A VL tree, you can find it in O(log n)
time. To achieve this, add a new data field named size in AVLTreeNode to 
store the number of nodes in the subtree rooted at this node. Note that the size of 
KEY TERMS
AVL tree 966
balance factor 966
left-heavy 966
LL rotation 967
LR rotation 967
perfectly balanced tree 966
right-heavy 966
RL rotation 967
rotation 966
RR rotation 967
well-balanced tree 966
```

</details>


## PDF page 1006

<details>
<summary>Page text</summary>

```text
Programming Exercises  983
a node v is one more than the sum of the sizes of its two children. Figure 26.12 
shows an A VL tree and the size value for each node in the tree.
FIGURE 26.12  The size data field in AVLTreeNode stores the number of nodes in the sub-
tree rooted at the node.
20
5
25
34
30 50
size: 6
size: 1
size: 2
size: 1 size: 1
size: 3
  In the AVLTree class, add the following method to return the kth smallest ele-
ment in the tree.
public E find(int k)
  The method returns null if k<1  or k > the size of the tree. This method 
can be implemented using the recursive method find(k,root) ,  which returns 
the kth smallest element in the tree with the specified root. Let A and B be the left 
and right children of the root, respectively. Assuming that the tree is not empty 
and k … root.size,find(k,root)  can be recursively defined as follows:
find(k, root) = E
root.element, if A is null and k is 1;
B.element, if A is null and k is 2;
find(k, A), if k 6 = A.size;
root.element, if k = A.size + 1;
find(k - A.size - 1, B), if k 7 A.size + 1;
  Modify the insert and delete methods in AVLTree to set the correct value 
for the size property in each node. The insert and delete methods will still 
be in O(log n) time. The find(k) method can be implemented in O(log n) time. 
Therefore, you can find the kth smallest element in an A VL tree in O(log n) time.
  Use the following main method to test your program:
import java.util.Scanner;
public class Exercise26_05 {
public static void main(String[] args) {
  AVLTree<Double> tree = new AVLTree<>();
  Scanner input = new Scanner(System.in);
  System.out.print("Enter 15 numbers: ");
for (int i = 0; i < 15; i++) {
    tree.insert(input.nextDouble());
  }
  System.out.print("Enter k: ");
  System.out.println("The " + k + "th smallest number is " + 
    tree.find(k));
  }
}
**26.6 (TestAVLTree) Design and write a complete test program to test if the AVLTree
class in Listing 26.4 meets all requirements.
```

</details>


## PDF page 1007

<details>
<summary>Page text</summary>

```text
This page intentionally left blank
```

</details>
