#include <fstream>
#include <math.h>
#include <iostream>


using namespace std;

void binarySearch(int* array, int sizeArray, int x);
int main()
{

    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw6\\Program6A_test.txt");

    int array1Size=0;
    input >> array1Size;

    int array2Size = 0;
    input >> array2Size;


    int* array1 = new int[array1Size];
    int x;
    for (int i= 0; i < array1Size; i++) {
        input >> x;
        array1[i] =x;
    }

    int* array2 = new int[array2Size];
    int y;
    for (int i = 0; i < array2Size; i++) {
        input >> y;
        array2[i] = y;
    }


    for (int i = 0; i < array2Size;i++) {
        binarySearch(array1, array1Size, array2[i]);
    }

}

  void binarySearch(int* array,int sizeArray, int x) {
     int l = 0;
     int r = sizeArray - 1;
     int m;
     while (l < r) {
         m = (l + r) / 2;
         if (array[m] >= x) //проверяем все хорошо или все плохо
         {
             r = m;
             // System.out.println("r " + r);
         }
         else {
             l = m + 1;
             // System.out.println("l " + l);
         }
     }

     if (array[l] == x) cout << "YES" << endl;
     else cout<<"NO"<<endl;
     // return l;

 }