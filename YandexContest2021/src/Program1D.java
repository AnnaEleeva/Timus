import java.util.Scanner;
public class Program1D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();

        System.out.println(getSolution(a,b,c));
    }

    public static String getSolution(int a, int b, int c){

         if(c<0){
            return "NO SOLUTION";
        }else{
            double firstPart=((c*c)-(double)b);

            if(firstPart==0.0 && a!=0){
                return String.valueOf(0);
            } else
                if(firstPart==0.0 && a==0){
                    return "MANY SOLUTIONS";
                } else
                    if(firstPart!=0.0 && a==0){
                        return "NO SOLUTION";
                    }



          //  if(((c*c)-(double)b)<0) return "NO SOLUTION";
            double result=(((c*c)-(double)b)/a);
            if(result%1!=0)   return"NO SOLUTION";
            else   return String.valueOf((int)result);
        }
    }
}
