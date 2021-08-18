// Program3C.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//
#include <fstream>
#include <set>
#include <iostream>
#include <algorithm>
using namespace std;


int main()
{
    //std::cout << "Hello World!\n";


    ifstream input("D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3C_test");
    int countA;
    input >> countA;
    int countB;
    input >> countB;

    set <int> stA;
    set <int> stB;
    set <int> stResult;

    set <int> resultA;
    set <int> resultB;

    //читаем и записываем в сет Ани
    int brickA;
    for (int i = 1; i < countA+1; i++) {
        input >> brickA;
        stA.insert(brickA);

    }
    //читаем и записываем в сет Бори
    int brickB;
    for (int i = 1; i < countB+1; i++) {
        input >> brickB;
        stB.insert(brickB);

    }

    //находим пересечение
    set_intersection(stA.begin(), stA.end(), stB.begin(), stB.end(), std::inserter(stResult, stResult.begin()));

    //находим уникальные у Ани
    set_difference(stA.begin(), stA.end(), stResult.begin(), stResult.end(), inserter(resultA, resultA.begin()));
    //находим уникальные у Бори
    set_difference(stB.begin(), stB.end(), stResult.begin(), stResult.end(), inserter(resultB, resultB.begin()));

    set <int>::iterator it;

    cout << stResult.size() << endl;
    for (it = stResult.begin(); it != stResult.end(); ++it)
        cout << *it << " ";
    cout << endl;

    cout << resultA.size() << endl;
    for (it = resultA.begin(); it != resultA.end(); ++it)
        cout << *it << " ";
    cout << endl;

    cout << resultB.size() << endl;
    for (it = resultB.begin(); it != resultB.end(); ++it)
        cout << *it << " ";


}


