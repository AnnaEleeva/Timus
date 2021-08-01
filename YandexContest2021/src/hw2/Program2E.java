package hw2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

//коровяк
public class Program2E {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
       // Path path = Paths.get("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw2\\input2E.txt");
       // Scanner scanner = new Scanner(path);
        String countUsers=scanner.nextLine();
        String [] strings =scanner.nextLine().split(" "); //числа одной строки в массив
        int[] arrayUsers = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray(); //массив строк в массив чисел
      //  int[] arrayUsersCopy= Arrays.copyOf(arrayUsers,arrayUsers.length);
        int max=-1;
       // ArrayList<Integer> vasilIndex=new ArrayList<>();
        //ищем максимум
        for(int i=0;i<arrayUsers.length;i++){
            if(arrayUsers[i]>max){
                max=arrayUsers[i];
            }
        }
      //  System.out.println("max "+max);
        //ищем максимальный счет Василия
        int vasilMax=-1;
        boolean wasWinner=false;
        for(int i=0;i<arrayUsers.length-2;i++){
            if(arrayUsers[i]==max){
                wasWinner=true;
            }
            if((wasWinner)&&(arrayUsers[i+1]%10==5)&&(arrayUsers[i+1]>arrayUsers[i+2])&&(arrayUsers[i+1]>vasilMax)){
                vasilMax=arrayUsers[i+1];
            }
        }
        if(vasilMax==-1){
            System.out.println(0);
            return;
        }
      //  System.out.println("vasilMax "+vasilMax);
        //определяем какое место занял Василий
        int vasilPlace=1;
        for(int i=0;i<arrayUsers.length;i++){
            if(arrayUsers[i]>vasilMax){
                vasilPlace++;
            }
        }
        //System.out.println("vasilPlace "+vasilPlace);
       System.out.println(vasilPlace);


    }


}
