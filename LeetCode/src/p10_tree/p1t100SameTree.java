package p10_tree;

public class p1t100SameTree {
    public static void main(String[] args) {
      TreeNode t1=  new TreeNode(1, new TreeNode(2), new TreeNode(3));
      TreeNode t2=  new TreeNode(1, new TreeNode(3), new TreeNode(2));
        System.out.println(isSameTree(t1,t2));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true; //если обе null
        if(p ==null || q == null) return false; //если у одного есть вершина, а у другого нет
       //если вершины есть, но значения разные
        if(p.val!=q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}


