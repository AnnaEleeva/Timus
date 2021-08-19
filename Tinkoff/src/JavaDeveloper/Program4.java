//У Петра Васильевича есть ﻿nn﻿ банковских счетов. Он устал следить за всеми карточками и решил наконец-то перевести деньги на один счет.
//
//
//        Процесс, проводимый Петром Васильевичем, выглядит так: он берет один из своих банковских счетов, переводит все деньги с этого счета на другой, затем закрывает пустой счет. Процесс закончится, когда у Петра Васильевича останется ровно один счет.
//
//
//        При переводе ﻿АА﻿ рублей с одного счета на другой счет с ﻿ВВ﻿ рублями Петр Васильевич платит банку комиссию ﻿5\%5%﻿ от суммы ﻿A + BA+B﻿.
//
//
//        Помогите Петру Васильевичу определить минимальную сумму, которую придется потратить на комиссию.
//
//
//        Формат входных данных
//
//        В первой строке вводится число ﻿nn﻿ ﻿(2 \le n \le 10^5)(2≤n≤10
//        5
//        )﻿﻿~- −﻿ количество банковских счетов.
//
//
//        В следующей строке вводится ﻿nn﻿ чисел﻿~- −﻿ суммы, лежащие на банковских счетах Петра Васильевича. Каждое число ﻿-−﻿ натуральное, не превосходящее ﻿1000010000﻿.
//
//
//        Формат выходных данных
//
//        Определите минимальную сумму, которая потратится на комиссию.
//
//        ﻿﻿
//
//        Замечание
//
//        В первом примере Петр Васильевич сначала объединит счета с суммами ﻿1010﻿ и ﻿1111﻿, потратив ﻿1.051.05﻿ на комиссию, затем объединит счета с суммами ﻿1212﻿ и ﻿1313﻿, потратив на комиссию ﻿1.251.25﻿ рубля. Дальше он объединит два получившихся счета (﻿2121﻿ и ﻿2525﻿ рублей соответственно), заплатив ﻿2.302.30﻿ рублей. В итоге он потратит ﻿4.604.60﻿, а потратить меньше было нельзя ﻿﻿﻿-−﻿ можете проверить все возможные способы. ﻿﻿
//
//        Во втором примере Петр Васильевич просто объединяет два доступных счета.


        package JavaDeveloper;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {

//        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\Tinkoff\\src\\JavaDeveloper\\Program4.txt";
//        Path path = Paths.get(fileName);
//        Scanner scanner = new Scanner(path);
        Scanner scanner = new Scanner(System.in);

        int countN= Integer.parseInt(scanner.nextLine());

        String [] countAccountStr =scanner.nextLine().split(" ");
        int[] countAccount = Arrays.stream(countAccountStr).mapToInt(Integer::parseInt).toArray();

        ArrayList<Integer> arrayNumbersList=new ArrayList<>();
        for(int e:countAccount){
            arrayNumbersList.add(e);
        }

        double comissionSum=0;

        while (arrayNumbersList.size()>1){
            int min1=getMinNumber(arrayNumbersList);
            arrayNumbersList=getNewArrayListWithoutNumber(arrayNumbersList,min1);
            int min2=getMinNumber(arrayNumbersList);
            arrayNumbersList=getNewArrayListWithoutNumber(arrayNumbersList,min2);

            comissionSum+=0.05*(min1+min2);
            arrayNumbersList.add(min1+min2);
        }
        System.out.printf("%.2f",comissionSum);


    }



    //поиск минимального значения в листе
    public static Integer getMinNumber (ArrayList<Integer> arrayList){
        int minNum = Integer.MAX_VALUE;


        for (int e = 0; e < arrayList.size(); e++) {
            if (arrayList.get(e) <= minNum) {
                minNum = arrayList.get(e);

            }
        }
        return  minNum;
    }

    //получение нового листа без какого-то элемента
    public  static ArrayList<Integer> getNewArrayListWithoutNumber(ArrayList<Integer> arrayList,Integer x){
        //добавим все, кроме x
        boolean wasX=false;

        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        for(int e:arrayList){
            if(e==x&&!wasX){
                wasX=true;
                continue;
            }
            newArrayList.add(e);

        }
        return newArrayList;
    }


}
