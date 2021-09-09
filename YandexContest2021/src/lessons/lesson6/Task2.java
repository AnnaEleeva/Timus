/*
Юра решил подготовиться к собеседованию в Яндекс. Он выбрал на сайте leetcode N задач.
В первый день Юра решил K задач. А  в каждый следующий день он решал на одну задачу больше, чем в предыдущий день
Сколько дней уйдет у Юры на подготовку к собеседованию?
a1=k - сколько решил в первый день


 */
package lessons.lesson6;

public class Task2 {
    public static void main(String[] args) {
        int n=9;
        int k=2;
        int result= lbinsearch(0,n,n,k);
        System.out.println(result);

    }
    public static int lbinsearch(int l,int r,int n, int k){
        int m;
        while (l<r){
            m= (l + r) / 2;
            if(check(m,n,k))
                r=m;
            else
                l=m+1;
        }
        return l;
    }
    public static boolean check(int m,int n, int k){
        //арифметическая прогрессия
        return ((k + (k + m - 1)) * m) / 2 >= n; //все хорошо, если задач больше N, и плохо если меньше - значит надо ему еще порешать (левый бин поиск:сначала все плохо, а с какого-то момента все хорошо)
    }
}
