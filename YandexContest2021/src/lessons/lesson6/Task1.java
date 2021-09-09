/*
В управляющий совет школы входят родители, учителя и учащиеся,
причем родителей должно быть не менее одной трети от общего числа
членов совета. В настоящий момент в совет входит N человек, из них K родителей.
Сколько родителей нужно дополнительно ввести в совет, чтобы их число стало не меньше трети от общего числа членов совета?
(K+M)/(N+M)>=1/3

Будем искать M - минимальное кол-во родителей которых нужно добавить
L=0
R=N
Деление заменим умножением
 */
package lessons.lesson6;

public class Task1 {
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
        return(k+m)*3>=n+m;
    }
}
