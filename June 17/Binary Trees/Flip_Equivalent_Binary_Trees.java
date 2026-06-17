import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Flip_Equivalent_Binary_Trees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        boolean same = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean opp = flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
        return same || opp;
    }

    // Build tree from level order input (-1 represents null)
    public TreeNode buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) return null;
        
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();
            
            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;
            
            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flip_Equivalent_Binary_Trees solution = new Flip_Equivalent_Binary_Trees();

        // Input first tree
        System.out.print("Enter number of nodes for Tree 1: ");
        int n1 = scanner.nextInt();
        int[] tree1 = new int[n1];
        System.out.println("Enter " + n1 + " values for Tree 1 (use -1 for null, level order):");
        for (int i = 0; i < n1; i++) {
            tree1[i] = scanner.nextInt();
        }

        // Input second tree
        System.out.print("Enter number of nodes for Tree 2: ");
        int n2 = scanner.nextInt();
        int[] tree2 = new int[n2];
        System.out.println("Enter " + n2 + " values for Tree 2 (use -1 for null, level order):");
        for (int i = 0; i < n2; i++) {
            tree2[i] = scanner.nextInt();
        }

        // Build trees
        TreeNode root1 = solution.buildTree(tree1);
        TreeNode root2 = solution.buildTree(tree2);

        // Check if flip equivalent
        boolean result = solution.flipEquiv(root1, root2);
        
        System.out.println("\nAre the trees flip equivalent? " + result);

        scanner.close();
    }
}
