class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int x) {
        this.val = x;
    }
}

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }
 
    //recursive
    public void preorder(TreeNode root) {
        if(root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //iteration stack
    public void preorderIterative(TreeNode root) {
        if(root == null) return;
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.val + " ");

            if(current.right != null) {
                stack.push(current.right);
            } 

            if(current.left != null) {
                stack.push(current.left);
            }
        }

    }

    public void inorder(TreeNode root ) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public void postorder(TreeNode root) {
        if(root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        System.out.print("Preorder traversal: ");
        tree.preorder(tree.root);
        tree.preorderIterative(tree.root);
        System.out.println();

        System.out.print("Inorder traversal: ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(tree.root);
        System.out.println();;
    }
}




