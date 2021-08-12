
import java.util.Scanner;
public class Program1209 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

//1 10 100 1000 10000 100000 1000000 10000000
//0 1  2    3    4      5
        int countPositions= scanner.nextInt();

        for(int i=0; i<countPositions;i++){

            int position=scanner.nextInt(); //           8


            int places=0;


            int j=0;
            while (true){

                places=places+j+1;
              if(position<=places){
                  if(position==(places-j)){
                      System.out.print(1+" ");
                      break;
                  }
                  else {
                      System.out.print(0+" ");
                      break;
                  }
              }
              j=j+1;
          }



        }
    }
}
