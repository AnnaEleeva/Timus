package p10_tree;

import java.util.ArrayList;
import java.util.List;

public class p4t113PathSumII2 {
    public static void main(String[] args) {
        TreeNode t2=  new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode t3 = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),null),null),new TreeNode(2,null, new TreeNode(3, new TreeNode(5),new TreeNode(4))));

        pathSum(t3,10);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> resulti = new ArrayList<>();
        pathSum2(result,resulti,root,targetSum);
        return result;
    }
    public static  void pathSum2(List<List<Integer>> result, List<Integer> resulti, TreeNode root, int targetSum){
        if (root==null) return;
        if(targetSum== root.val && root.right==null && root.left==null){
            List<Integer> resultiCP=new ArrayList<>(resulti);
            resultiCP.add(root.val);
            result.add(resultiCP);
        }
        List<Integer> resulticpy1 = new ArrayList<>(resulti);
        List<Integer> resulticpy2 = new ArrayList<>(resulti);
        resulticpy1.add(root.val);
        resulticpy2.add(root.val);
         pathSum2(result, resulticpy1,root.left,targetSum-root.val);
         pathSum2(result, resulticpy1,root.right,targetSum-root.val);

    }

}
