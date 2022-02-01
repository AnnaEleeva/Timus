package p10_tree;

public class p2t101SymmetricTree {
    public static void main(String[] args) {
        TreeNode t0=new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(3),new TreeNode(4)));
//        TreeNode t1=  new TreeNode( new TreeNode(2), new TreeNode(3));
//        TreeNode t2=  new TreeNode( new TreeNode(3), new TreeNode(2));
        System.out.println(isSymmetric(t0));

    }
    public static boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left,root.right);

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; //если обе null
        if(p ==null || q == null) return false; //если у одного есть вершина, а у другого нет
        //если вершины есть, но значения разные
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }
}
