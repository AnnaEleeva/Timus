// Program3B.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
// Пересечение двух сетов(множеств)

#include <fstream>
#include <set>
#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;
int main()
{

    set <int> st1;
    set <int> st2;
    set <int> st3;

    std::string line1;
    getline(std::cin, line1);

    std::string line2;
    getline(std::cin, line2);


    int num;
    int countNum = 0;
    std::stringstream line_steam1(line1);
    std::stringstream line_steam2(line2);

    //считаем числа в строке
    while (!line_steam1.eof()) {
        line_steam1 >> num; //читает только float пропуская все ненужные символы
        st1.insert(num);
    }

    while (!line_steam2.eof()) {
        line_steam2 >> num; //читает только float пропуская все ненужные символы
        st2.insert(num);
    }

    set_intersection(st1.begin(), st1.end(), st2.begin(), st2.end(), std::inserter(st3, st3.begin()));


    set <int>::iterator it;

    for (it = st3.begin(); it != st3.end(); ++it)
        cout << *it << " ";






 /*   ifstream input("input.txt");
    int ch;

    while (input >> ch) {

        st1.insert(ch);
    }

    cout << st1.size() << endl;*/
}