//почему-то в java так не работает. с обычным set
//в java объекты жрут много памяти. Стандартные классы из java.util работают не с примитивами, а только с объектами обертками.
//на java программа не проходила по памяти, а на питоне и с++ прошла!
#include <fstream>
#include <set>
#include <iostream>
using namespace std;
int main()
{
    //std::cout << "Hello World!\n";

    set <int> st;

    ifstream input("input.txt");
    int ch;

    while (input >> ch) {

        st.insert(ch);
    }

    cout << st.size() << endl;
}