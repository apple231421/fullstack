#include <iostream>
#include <string>
using namespace std;

class MyClass
{
public: 
    void myFunction()
    {
        cout << "some content in parent class\n";
    }
};

class mychild: public MyClass{

};
class mygrandchild: public mychild{

};

int main()
{
   mygrandchild myobj;
 myobj.myFunction();
    return 0;
}
