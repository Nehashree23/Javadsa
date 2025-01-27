import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ListToBinaryTree {
    
    public static TreeNode list2BinaryTree(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null; 
        }
		TreeNode root = new TreeNode(list.get(0));
		Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
		int i = 1; 
		while (!queue.isEmpty() && i < list.size()) {
            TreeNode current = queue.poll();
		if (i < list.size()) {
                current.left = new TreeNode(list.get(i));
				i++;
                queue.add(current.left);
            }
		if (i < list.size()) {
                current.right = new TreeNode(list.get(i));
				i++;
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        TreeNode root = list2BinaryTree(list);

        System.out.print("In-order Traversal of the Binary Tree: ");
        inOrderTraversal(root);
    }
}
