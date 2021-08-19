//Бабушка подарила Лизе две коробки с конфетами: в первой коробке ﻿AA﻿ конфет, а во второй — ﻿BB﻿ конфет. Мама Лизы не разрешает ей есть больше, чем ﻿NN﻿ конфет в день. Сколько конфет сегодня сможет съесть Лиза (при условии, что ей хочется съесть как можно больше конфет)?
//
//
//        Формат входных данных
//
//        В трех строках вводятся три целых положительных числа: ﻿AA﻿, ﻿BB﻿, ﻿NN﻿ (﻿1 \le A, B, N \le 10001≤A,B,N≤1000﻿).
//
//
//        Формат выходных данных
//
//        Выведите одно число — максимальное количество конфет, которое может съесть Лиза.
//
//
//        Замечание
//
//        В первом примере Лиза может съесть ﻿22﻿ конфеты из первой коробки и ﻿33﻿ конфеты из второй коробки. Во втором примере мама Лизы не разрешит ей съесть больше, чем одну конфету.


package JavaDeveloper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) throws IOException {
        String fileName = "input.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        //Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int z=scanner.nextInt();

        if(x+y<z){
            System.out.println(x+y);
        }else{
            System.out.println(z);
        }
    }
}
