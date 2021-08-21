

#include <fstream>
#include <map>
#include <set>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    map <string, int> dict;
    set <string> st;

    ifstream input("C:\\Users\\1\\IdeaProjects\\Timus\\YandexContest2021\\src\\hw4\\Program4B_test.txt");


    string s;
    while (input >> s) {


        if (dict.find(s) == dict.end()) {
            dict.insert(make_pair(s,1));
            //cout << 0 << " ";
        }
        else {
            map <string, int> ::iterator it;
            it = dict.find(s);
            int count = it->second;
            count=count+1;

            //Удаляем старый элемент
            dict.erase(s);
            dict.insert(make_pair(s, count));
            //cout <<count<< " ";
        }




    }

    int currentMax = -1;
    string arg_max;
    for (auto it = dict.cbegin(); it != dict.cend(); ++it) {

        if (it->second > currentMax) {
            arg_max = it->first;
            currentMax = it->second;
        }
    }

    for (auto it = dict.cbegin(); it != dict.cend(); ++it) {

        if (it->second == currentMax) {
            st.insert(it->first);
        }
    }

    if (st.size() > 0)
        cout << *(st.begin());


}
