#include <fstream>
#include <map>
#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    map <string, string> sinonimsDict;

    ifstream input("input.txt");
    int countStrings;
    input >> countStrings;

    string s1;
    string s2;
    for (int i = 0; i < countStrings; i++) {
        input >> s1;
        input >> s2;
        sinonimsDict.insert(make_pair(s1, s2));
        sinonimsDict.insert(make_pair(s2, s1));
    }
    string word;
    input >> word;

    map <string, string> ::iterator it;
    it= sinonimsDict.find(word);
    cout << it->second << endl;
}