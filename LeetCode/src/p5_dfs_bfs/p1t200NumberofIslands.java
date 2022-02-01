package p5_dfs_bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class p1t200NumberofIslands {
    public static void main(String[] args) {

        char [][] islands=new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};

        char [][] islands2=new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};

        char [][] islands3=new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}};

        char [][] islands4=new char[][]{
                {'1','1','1','1','1','1'},
                {'1','0','0','0','0','1'},
                {'1','0','1','1','0','1'},
                {'1','0','0','0','0','1'},
                {'1','1','1','1','1','1'}};

        System.out.println(numIslands(islands4));

    }

    public static int numIslands(char[][] grid) {
        int countRows= grid.length;
        int countColumns=grid[0].length;
        int [][] mark=new int [countRows][countColumns];

        int countIslands=0;

        //идем по двумерному массиву
        for (int i=0;i<countRows;i++){
            for(int j=0;j<countColumns;j++){
                //если точка земля и не помечена - помечены те, которые уже входят в какой-то остров
                if(grid[i][j]=='1'&&mark[i][j]==0){
                    //ищем весь остров от этой точки
                    mark=bfs(i,j,grid,mark); //найти от найденной земли соседние и пометить что все соседние точки входят в остров
                    countIslands++; //нашли еще один остров
                }
                //if(grid[i][j]=='1'&&mark[i][j]!=0){} //значит точка уже значится в каком-то острове
            }
        }

        return countIslands;
    }

    public static int[][] bfs(int iE, int jE, char[][] grid, int[][] mark){
        int countRows= grid.length;
        int countColumns=grid[0].length;

        int[][] visited=mark; //помеченные сюда
        Queue<int[]> queue=new ArrayDeque<>();//[i,j]
        queue.add(new int []{iE,jE});

        while (!queue.isEmpty()){
            int i=queue.peek()[0];
            int j=queue.peek()[1];


            //если нашли соседнюю землю и она не помечена
            //cнизу
            if((i<countRows-1) && grid[i+1][j]=='1' && visited[i+1][j]==0) {
                queue.add(new int []{i+1,j});
                visited[i+1][j]=1;
            }
            //справа
            if((j<countColumns-1) && grid[i][j+1]=='1' && visited[i][j+1]==0){
                queue.add(new int []{i,j+1});
                visited[i][j+1]=1;
            }
            //сверху
            if((i>0) && grid[i-1][j]=='1' && visited[i-1][j]==0){
                queue.add(new int []{i-1,j});
                visited[i-1][j]=1;
            }
            //слева
            if((j>0) && grid[i][j-1]=='1' && visited[i][j-1]==0){
                queue.add(new int []{i,j-1});
                visited[i][j-1]=1;
            }

            //добавили в очередь всех соседей - можем убрать из очереди точку
            queue.poll();
        }
        return visited;
    }
}
