// Program3C.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//
#include <fstream>
#include <set>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;


int main()
{
    //std::cout << "Hello World!\n";


    ifstream input("D:\\Загрузки\\demo (2)\\Timus\\YandexContest2021\\src\\hw3\\Program3E_test");

    set <int> st;

    int x;
    for (int i = 0; i < 3; i++) {
        input >> x;
        st.insert(x);
    }

    int number;
    input >> number;

    std::string s = to_string(number);

    int countAddButtons = 0;
    set<int> resSet;

    for (int i = 0; i < s.size();i++) {

        int n = number % 10;
        number = number / 10;
        if (!st.count(n)) {
            resSet.insert(n);
        }
    }

    cout << resSet.size();




}


