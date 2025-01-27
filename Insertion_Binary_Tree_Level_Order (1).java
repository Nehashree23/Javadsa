import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {

 	public static Node buildTree(List<Integer> list) {
        if (list == null || list.isEmpty()) return null;

        Node root = new Node(list.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1; 
        while (!queue.isEmpty() && i < list.size()) {
            Node current = queue.poll();

            if (i < list.size() && list.get(i) != null) {
                current.left = new Node(list.get(i));
                queue.add(current.left);
            }
            i++;

            if (i < list.size() && list.get(i) != null) {
                current.right = new Node(list.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public void insertLevelOrder(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = new Node(key);
                return;
            } else {
                queue.add(current.left); 
            }

            if (current.right == null) {
                current.right = new Node(key);
                return;
            } else {
                queue.add(current.right);  
            }
        }
    }

    
	
	public void levelOrder(Node root) { 
        if (root == null) return;  
        Queue<Node> queue = new LinkedList<>();  
        queue.add(root);  

        while (!queue.isEmpty()) { 
            Node current = queue.poll();  
			System.out.print(current.data + " ");  
			
			if (current.left != null) queue.add(current.left); 
            if (current.right != null) queue.add(current.right); 
        }
    }
}

public class Insertion_Binary_Tree_Level_Order {
    public static void main(String[] args) {
        List<Integer> treeList = new ArrayList<>();
        treeList.add(50);
        treeList.add(30);
        treeList.add(70);
        treeList.add(null);  
        treeList.add(40);
        treeList.add(60);
        treeList.add(80);
		BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(treeList); 

        System.out.println("Level Order Traversal:");
        tree.levelOrder(root);  
        System.out.println();
		
		System.out.println("After inserting 60:");
        tree.insertLevelOrder(root, 100);
		
		System.out.println("Level Order Traversal:");
        tree.levelOrder(root);  
        System.out.println();
    }
}
