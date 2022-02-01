package p10_tree;

public class p3t110BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode t0=new TreeNode(1,new TreeNode(2,null,new TreeNode(3,new TreeNode(4),null)),new TreeNode(2,null,new TreeNode(3,new TreeNode(4),null)));
        TreeNode t1=  new TreeNode(1, new TreeNode(3),null);
        TreeNode t2=  new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));

        TreeNode t3 = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),null),null),new TreeNode(2,null, new TreeNode(3, null,new TreeNode(4))));
        System.out.println(isBalanced(t3));

    }
    public static boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(root.left==null && root.right==null) return true;

        int x = heightOfBinaryTree(root.left);
        int y= heightOfBinaryTree(root.right);
      //  System.out.println(x);
      //  System.out.println(y);
        if(x==-1 || y==-1) return false;
        return (Math.abs(x-y)<=1);


    }
    public static int heightOfBinaryTree(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }
        else
        {
            if(heightOfBinaryTree(node.left)==-1 || heightOfBinaryTree(node.right)==-1) return -1;
            if( Math.abs(heightOfBinaryTree(node.left)-heightOfBinaryTree(node.right))>1) return -1;
            return 1 +
                    Math.max(heightOfBinaryTree(node.left),
                            heightOfBinaryTree(node.right));
        }
    }
    public static int height (TreeNode node){
        int h=0;
        if(node.left!=null||node.right!=null) h++;
        int s1=0;
        int s2=0;
        if(node.left!=null)
            s1=height(node.left);
        if(node.right!=null)
            s2=height(node.right);

        return Math.max(Math.max(h,s1),s2)+1; //загадочный +1 -почему?
    }
}
