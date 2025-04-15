#include <iostream>
#include <string>
using namespace std;

class MyClass
{
public:
    int myNum;
    string myString;
};

int main()
{
    MyClass myobj;

    myobj.myNum = 15;
    myobj.myString = "sum text";

    cout << myobj.myNum << "\n";
    cout << myobj.myString;
    return 0;
}
