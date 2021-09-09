

#include <fstream>
#include <math.h>
#include <iostream>


using namespace std;


void rbinarySearch(long long* array, int sizeArray, long long x);
int main()
{

    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw6\\Program6B_test.txt");


    int array1Size=0;
    input >> array1Size;

    int array2Size = 0;
    input >> array2Size;


    long long* array1 = new long long[array1Size];
    long long x;
    for (int i= 0; i < array1Size; i++) {
        input >> x;
        array1[i] =x;
    }

    long long* array2 = new long long[array2Size];
    long long y;
    for (int i = 0; i < array2Size; i++) {
        input >> y;
        array2[i] = y;
    }


    for (int i = 0; i < array2Size;i++) {
        rbinarySearch(array1, array1Size, array2[i]);
    }

}

 void rbinarySearch(long long* array, int sizeArray, long long x) {
      int l = 0;
      int r =sizeArray - 1;
      int m;
      while (l < r) {
          m = (l + r + 1) / 2;
          if (array[m] <= x) //проверяем все хорошо или все плохо
          {
              l = m;
              // System.out.println("r " + r);
          }
          else {
              r = m - 1;
              // System.out.println("l " + l);
          }
      }

      long long minDif = abs(array[l] - x);
      long long answer = array[l];

      //System.out.println("index "+ l);
      if (l - 1 >= 0) {
          if ((abs(array[l - 1] - x)) < minDif) {
              minDif = abs(array[l - 1] - x);
              answer = array[l - 1];
          }
      }
      if (l + 1 < sizeArray) {
          long long z2 = array[l + 1];
          long long z3 = x;
          long long z4 = z2 - z3;
          long long z = abs(array[l + 1] - x);
          if ((abs(array[l + 1] - x)) < minDif) {
              minDif = abs(array[l + 1] - x);
              answer = array[l + 1];

          }
      }


      cout<<answer<<endl;
      // return l;
  }