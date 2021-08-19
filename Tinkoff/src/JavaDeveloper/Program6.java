//Люся с Дуней, не сговариваясь, подарили друг другу по дереву. Разумеется, они сразу же решили с ними во что-нибудь сыграть.
//
//        ﻿\textit{Прим. Дерево~--- связный граф из $n$ вершин и $n - 1$ ребра, который не содержит циклов}Прим. Дерево — связный граф из n вершин и n−1 ребра, который не содержит циклов﻿
//
//        Игра с деревом выглядит следующим образом﻿~- −﻿игрок должен выбрать вершину в своем дереве. Эта вершина становится корнем дерева. Количество очков, которое набрал игрок, определяется как максимальная глубина какой-либо вершины в получившемся корневом дереве. Глубиной вершины ﻿vv﻿ в дереве с корнем ﻿rr﻿ считается количество вершин на простом пути от ﻿rr﻿ до ﻿vv﻿.
//
//
//        Люся с Дуней договорились одновременно выбрать вершину, а затем сравнить количество набранных очков в игре. Тот, кто набирает больше очков, побеждает. Если набрано одинаковое количество очков, то не побеждает никто.
//
//
//        Люся знает, что Дуня выбрала вершину так, чтобы получить максимальное количество очков. Ее заинтересовал вопрос﻿~- −﻿ а не могло ли случиться так, что Люся выиграет, вне зависимости от того, какую вершину выберет? Помогите ей ответить на этот вопрос.
//
//

package JavaDeveloper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program6 {

    public static void main(String[] args) throws IOException {
        String fileName = "D:\\Загрузки\\demo (2)\\Timus\\Tinkoff\\src\\JavaDeveloper\\Program6.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        int countL= Integer.parseInt(scanner.nextLine());

        for(int i=0;i<countL;i++){
            String[] pairStr=scanner.nextLine().split(" ");
            int[] pair = Arrays.stream(pairStr).mapToInt(Integer::parseInt).toArray();

        }


    }

    class Node {
        int data;
        List<Node> children;

        public Node (int data, List<Node> children) {
            this.data = data;
            this.children = children;
        }
        public Node (int data) {
            this.data = data;
            this.children = null;
        }
    }

    static int findDepth(Node root) {
        int deepest = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                deepest = Math.max(deepest, findDepth(child));
            }
        }
        return deepest+1;
    }
}
