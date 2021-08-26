

#include <fstream>
#include <math.h>
#include <iostream>


using namespace std;
int rsq(int* prefixSum, int l, int r);
int* makePrefixSumLeftToRight(int* array, int sizeArray);
int* makePrefixSumRightToLeft(int* array, int sizeArray);
int main()
{



    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw5\\Program5C_test.txt");



    //кол-во горных пиков
    int mountainPeaksCount=0;
    input >> mountainPeaksCount;


    int* mountainPeaksRise = new int[mountainPeaksCount - 1];
    //получим первую вершину (пик) - чтобы высчитать насколько поднялись или опустились от первой до второй вершины
    int x;
    input >> x;
    int oldY;
    input >> oldY;

    //подъемы и спуски - их на 1 меньше чем пиков
    int i;
    for ( i= 0; i < mountainPeaksCount - 1; i++) {
        input >> x;
        int y;
        input >> y;
        mountainPeaksRise[i] = y - oldY;
      //  cout <<i<<" " <<mountainPeaksRise[i]<<" "<< (sizeof(mountainPeaksRise) / sizeof(int)) <<endl;
        oldY = y;
    }

    int* prefixSumLeftToRight = makePrefixSumLeftToRight(mountainPeaksRise, mountainPeaksCount - 1);
    int* prefixSumRightToLeft = makePrefixSumRightToLeft(mountainPeaksRise, mountainPeaksCount - 1);

    //кол-во маршрутов
    int trackCount;
    input >> trackCount;
    //нумерация маршрутов с 0
    for (int j = 0; j < trackCount; j++) {

        int trackStartPeakIndex;// = Integer.parseInt(trackStartEnd[0]);
        input >> trackStartPeakIndex;
        int trackEndPeakIndex;// = Integer.parseInt(trackStartEnd[1]);
        input >> trackEndPeakIndex;
        //создаем массив префиксных сумм, а по нему уже высчитываем каждый маршрут
        //если маршрут слева-направо (нормально) - считаем положительные (подъемы)
        if (trackStartPeakIndex < trackEndPeakIndex) {

            int result = rsq(prefixSumLeftToRight, trackStartPeakIndex, trackEndPeakIndex);
            cout<<result<<endl;
        }
        //иначе считаем отрицательные (подъемы)
        else {
            int result = rsq(prefixSumRightToLeft, trackStartPeakIndex, trackEndPeakIndex);
            cout << result << endl;
        }

    }


}

 int* makePrefixSumRightToLeft(int* array,int sizeArray) {
    int* prefixSum = new int[sizeArray + 1];
    for (int i = 1; i < sizeArray + 1; i++) {

        if (array[i - 1] < 0) {
            prefixSum[i] = prefixSum[i - 1] + abs(array[i - 1]);
        }
        else {
            prefixSum[i] = prefixSum[i - 1];
        }

    }
    return prefixSum;

}

 int* makePrefixSumLeftToRight(int* array, int sizeArray) {
    int* prefixSum = new int[sizeArray + 1];
    for (int i = 1; i < sizeArray + 1; i++) {

        if (array[i - 1] > 0) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }
        else {
            prefixSum[i] = prefixSum[i - 1];
        }

    }
    return prefixSum;

}
 int rsq(int* prefixSum, int l, int r) {
    return abs(prefixSum[r - 1] - prefixSum[l - 1]);
}

