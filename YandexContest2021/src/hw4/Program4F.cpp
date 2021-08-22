

#include <fstream>
#include <map>
#include <iostream>

using namespace std;

int main()
{
    map <string, map <string, long> > mp;


    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4F_test.txt");


    string surname;
    string product;
    long count;
    //читаем первые слова в каждой строке (фамилии)
    while (input >> surname) {
        //читаем продукт
        input >> product;
        input >> count;


             mp[surname][(product] += count;


    }

    for (auto now : mp) {
        cout << now.first << ": "<< "\n";


        for (auto now2 : now.second) {
            cout << now2.first << " " << now2.second << endl;
        }

    }

}
