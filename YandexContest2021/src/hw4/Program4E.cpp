

#include <fstream>
#include <map>
#include <set>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    map <int, int> dict;

    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4E_test.txt");


   int w;
   int h;
   int countButtons;
   input >> countButtons;
   for (int i = 0; i < countButtons;i++) {
       input >> w;
       input >> h;



        if (dict.find(w) == dict.end()) {//если нет такого ключа
            dict.insert(make_pair(w,h));
            //cout << 0 << " ";
        }
        else { //если такой ключ есть
            map <int, int> ::iterator it;
            it = dict.find(w);
            int oldHight = it->second;
            if (oldHight < h) {
                //Удаляем старый элемент
                dict.erase(w);
                dict.insert(make_pair(w, h));
            }

        }

    }

    long sum=0;

    int  hight;
    for (auto it = dict.cbegin(); it != dict.cend(); ++it) {

        hight = it->second;
        sum += hight;

    }
     cout << sum;


}
