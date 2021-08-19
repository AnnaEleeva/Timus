//Вы пришли в магазин, в котором находится ﻿nn﻿ скатертей. Вам нужно купить самую дешевую скатерть для вашего прямоугольного стола размера ﻿W \times HW×H﻿. У каждой скатерти есть свои габариты ﻿w_i \times h_iw
//        i
//        ​
//        ×h
//        i
//        ​
//        ﻿, а также своя стоимость в ﻿c_ic
//        i
//        ​
//        ﻿ единиц.
//
//
//        Считается, что скатерть покрывает стол, если верхнюю поверхность стола не видно под скатертью. Найдите самую дешевую скатерть, покрывающую стол.
//
//
//        Формат входных данных
//
//        В первой строке вводится натуральное число ﻿nn﻿ ﻿(1 \le n \le 1000)(1≤n≤1000)﻿﻿~- −﻿ количество скатертей в магазине.
//
//
//        Во второй строке вводятся два натуральных числа ﻿WW﻿, ﻿HH﻿ ﻿(1 \le W,\,H \le 1000)(1≤W,H≤1000)﻿﻿~- −﻿ размеры вашего стола.
//
//
//        Во следующих ﻿nn﻿ строках вводятся натуральные числа ﻿w_i,\,h_i,\,c_iw
//        i
//        ​
//        ,h
//        i
//        ​
//        ,c
//        i
//        ​
//        ﻿ ﻿(1 \le w_i,\,h_i,\,c_i \le 1000)(1≤w
//        i
//        ​
//        ,h
//        i
//        ​
//        ,c
//        i
//        ​
//        ≤1000)﻿﻿~- −﻿габариты скатерти и ее стоимость.
//
//
//        Формат выходных данных
//
//        Выведите одно число — оптимальную стоимость покупки скатерти.
//
//
//        Замечание
//
//        Рассмотрим все данные в примере скатерти:
//
//        1. Первая скатерть размера ﻿5 \times 45×4﻿, она не налезет на стол ﻿5 \times 65×6﻿
//
//        2. Вторая скатерть размера ﻿6 \times 76×7﻿, она налезет на стол ﻿5 \times 65×6﻿ и стоит ﻿1010﻿ единиц
//
//        3. Третья скатерть размера ﻿6 \times 56×5﻿, налезет на стол, если ее повернуть. Стоит она ﻿55﻿ единиц, за счет чего оказывается самой дешевой из доступных

package JavaDeveloper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int countTablecloth= Integer.parseInt(scanner.nextLine());

        String[] tableStr=scanner.nextLine().split(" ");
        int[] tableXY = Arrays.stream(tableStr).mapToInt(Integer::parseInt).toArray();

        int min = 5000;
        for(int i=0;i<countTablecloth;i++){
            String[] tripleStr=scanner.nextLine().split(" ");
            int[] tripleXYC = Arrays.stream(tripleStr).mapToInt(Integer::parseInt).toArray();
            if(((tableXY[0]<=tripleXYC[0])&&(tableXY[1]<=tripleXYC[1]))||((tableXY[0]<=tripleXYC[1])&&(tableXY[1]<=tripleXYC[0]))){
                if(tripleXYC[2]<min){
                    min=tripleXYC[2];
                }
            }
        }
        System.out.println(min);
    }
}
