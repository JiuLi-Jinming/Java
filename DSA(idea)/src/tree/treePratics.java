package tree;

public class treePratics
{
    public void printTree(TreeNode root)
    {
        if (root == null) return;
        System.out.print(root.val + ' ');
        if (root.left != null) {
            printTree(root.left);
        } else if (root.right != null) {
            printTree(root.right);
        }
        System.out.println();
    }

    public TreeNode invertTree(TreeNode root)
    {
return root;
    }

    public static void main(String[] args) {
        int ary[] = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(ary.length);

    }
}
