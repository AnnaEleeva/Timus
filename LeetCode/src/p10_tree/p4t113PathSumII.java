package p10_tree;
//Не смогла решить без рекурсии.Да и с рекурсией мутновато - рекурсивно уменьшается target
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p4t113PathSumII {
    public static void main(String[] args) {
        TreeNode t2=  new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        TreeNode t3 = new TreeNode(1,new TreeNode(2,new TreeNode(3,new TreeNode(4),null),null),new TreeNode(2,null, new TreeNode(3, new TreeNode(5),new TreeNode(4))));

        pathSum(t3,10);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int countPaths=0;//число путей от корня до листа = targetSum
        List<List<Integer>> res =new ArrayList<>();
        int sum=0;
        List<Integer> sList=new ArrayList<>();

        Stack<TreeNode> stack=new Stack<>();


        stack.push(root);

        while (!stack.empty()){
            TreeNode node= stack.pop();
            sum+=node.val;
            sList.add(node.val);
            if(node.left!=null)stack.push(node.left);
            if(node.right!=null) stack.push(node.right);
            if(node.left==null && node.right==null) {
                if(sum==targetSum) {
                    countPaths++;
                    res.add(sList);
                }
            }
        }

        System.out.println(countPaths);

        return null;
    }
}
