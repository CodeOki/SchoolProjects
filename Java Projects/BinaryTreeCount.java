class BinaryTree {

   class Node {
      int key;
      Node left, right;

   public Node(int item) {
      key = item;
      left = right = null;
   }
   }

   Node root;
  
   int counter;
   int counterEven;
   int counterOdd;
  
   BinaryTree() {
      root = null;
      counter = counterEven = counterOdd = 0;
   }

   void insert(int key) {
      root = insertNode(root, key);
   }


   private Node insertNode(Node root, int key) {
   if (root == null) {
      root = new Node(key);
      return root;
   }


   if(key <= root.key)
   root.left = insertNode(root.left, key);
  

   else if (key > root.key)
   root.right = insertNode(root.right, key);

   return root;
   }


   void inorder() {
      inorderTraversal(root);
   }


private void inorderTraversal(Node root)  {
   if(root != null) {
   inorderTraversal(root.left);
  
   if(++counter % 10 == 0) {
   System.out.println(" " + root.key + ", ");
   } else {
   System.out.print(" " + root.key + ", ");
   }
  
   inorderTraversal(root.right);
   }
}
  
void preorder() {
   preorderTraversal(root);
}

private void preorderTraversal(Node root) {
   if(root != null) {
      if(++counter % 10 == 0) {
         System.out.println(" " + root.key + ", ");
      } else {
         System.out.print(" " + root.key + ", ");
      }
      preorderTraversal(root.left); 
      preorderTraversal(root.right);
   }
}
  
void postorder() {
   postorderTraversal(root);
}

private void postorderTraversal(Node root) {
   if(root != null) {
      postorderTraversal(root.left);
      postorderTraversal(root.right);

   if(++counter % 10 == 0) {
      System.out.println(" " + root.key + ", ");
      } else {
      System.out.print(" " + root.key + ", ");
      }
   }
}  
   int count() {
      countNodes(root);
      return counter;
   }
  
private void countNodes(Node root) {    
   if(root != null) {
      countNodes(root.left);
      counter++;
      countNodes(root.right);
   }
}
  
int countEven() {
   countEvenNodes(root);
   return counterEven;
}
  
private void countEvenNodes(Node root) {    
   if(root != null) {
      countEvenNodes(root.left);
   if(root.key % 2 == 0)
       counterEven++;
       countEvenNodes(root.right);
   }
   }
  
int countOdd() {
   countOddNodes(root);
   return counterOdd;
}
  
private void countOddNodes(Node root) {    
   if(root != null) {
      countOddNodes(root.left);
   if(root.key % 2 != 0)
       counterOdd++;
      countOddNodes(root.right);
   }
   }
} 

public class BinaryTreeCount {
   public static void main(String[] args) {
       int setOne[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,-999};
       int setTwo[] = {3,1,5,17,14,62,-999};
       int setThree[] = {17,12,75,12,37,60,90,11,15,35,45,53,67,97,95,-999};
       int setFour[] = {150,40,60,39,34,27,10,82,15,-999};
       int setFive[] = {43,6,9,-999};
       int setSix[] = {14,15,13,17,18,12,16,94,46,34,74,-999};      
      
       BinaryTree btOne = new BinaryTree();
       int c = 0;
      
       while(setOne[c] != -999)
           btOne.insert(setOne[c++]);
      
       System.out.println("\n **************** Inorder Traversal **************** ");
       btOne.inorder();
       
       System.out.println("\n **************** Preorder Traversal **************** ");
       btOne.preorder();
      
       System.out.println("\n **************** Postorder Traversal **************** ");
       btOne.postorder();
      
       System.out.println("\n Number of nodes in set 1: " + btOne.count());

       c = 0;
       while(setTwo[c] != -999)
           btOne.insert(setTwo[c++]);
      
       c = 0;
       while(setThree[c] != -999)
           btOne.insert(setThree[c++]);
      
       c = 0;
       while(setFour[c] != -999)
           btOne.insert(setFour[c++]);
      
       c = 0;
       while(setFive[c] != -999)
           btOne.insert(setFive[c++]);
      
       c = 0;
       while(setSix[c] != -999)
           btOne.insert(setSix[c++]);
      
       System.out.println("\n **************** Inorder Traversal **************** ");
       btOne.inorder();
      
       System.out.println("\n **************** Pre order Traversal **************** ");
       btOne.preorder();
      
       System.out.println("\n **************** Post order Traversal **************** ");
       btOne.postorder();
              
       System.out.println("\n Number of nodes in Binary Tree: " + btOne.count());
      
       System.out.println("\n Number of Even value in Binary Tree: " + btOne.countEven());
      
       System.out.println("\n Number of Odd value in Binary Tree: " + btOne.countOdd());
   }
}