package hw4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
//DEPOSIT name sum  - зачислить или создать клиента и начислить
//WITHDRAW name sum - снять или создать клиента и снять
//BALANCE name  - узнать остаток или выведите ERROR
// TRANSFER name1 name2 sum - перевести с клиента1 на клиента2
//INCOME p - начислить всем клиентам, у которых открыты счета, p% от суммы счета.
//           Проценты начисляются только клиентам с положительным остатком
//           начисляется только целое число денежных единиц. Дробная часть начисленных процентов отбрасывается.


public class Program4G {
    public static  HashMap<String,Integer> accountMap=new HashMap<>();
    public static void main(String[] args) throws IOException {

        String fileName = "C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4G_test.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(" ");
            switch (str[0]) {
                case ("DEPOSIT"):
                    deposit(str[1], Integer.parseInt(str[2]));
                    break;
                case ("WITHDRAW"):
                    withdraw(str[1], Integer.parseInt(str[2]));
                    break;
                case ("BALANCE"):
                    balance(str[1]);
                    break;
                case ("TRANSFER"):
                    transfer(str[1],str[2], Integer.parseInt(str[3]));
                    break;
                case ("INCOME"):
                    income(Integer.valueOf(str[1]));
                    break;
            }


        }
    }
    public static void deposit(String name, int sum){
        //если клиент есть в базе
        if(accountMap.containsKey(name)){
            accountMap.put(name,accountMap.get(name)+sum);
        }else{ //если клиента в базе нет
            accountMap.put(name,sum);
        }
    }

    public static void withdraw(String name, int sum){
        //если клиент есть в базе
        if(accountMap.containsKey(name)){
            accountMap.put(name,accountMap.get(name)-sum);
        }else{ //если клиента в базе нет
            accountMap.put(name,-sum);
        }
    }

    public static void balance(String name){
        //если клиент есть в базе
        if(accountMap.containsKey(name)){
            System.out.println(accountMap.get(name));
        }else{ //если клиента в базе нет
            System.out.println("ERROR");
        }
    }

    public static void transfer(String name1,String name2,int sum){
       withdraw(name1,sum);
       deposit(name2,sum);
    }
    public static void income(Integer p){
        for(String e: accountMap.keySet()){
            if(accountMap.get(e)>0){
                accountMap.put(e, accountMap.get(e)+(int) Math.floor(accountMap.get(e)*p/100.0));
            }
        }
    }
}
