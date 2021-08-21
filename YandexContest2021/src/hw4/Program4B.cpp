
#include <fstream>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    map <string, int> dict;

    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4B_test.txt");


    string s;
    while (input >> s) {


        if (dict.find(s) == dict.end()) {
            dict.insert(make_pair(s,0));
            cout << 0 << " ";
        }
        else {
            map <string, int> ::iterator it;
            it = dict.find(s);
            int count = it->second;
            count=count+1;

            //Удаляем старый элемент
            dict.erase(s);
            dict.insert(make_pair(s, count));
            cout <<count<< " ";
        }

    }

}