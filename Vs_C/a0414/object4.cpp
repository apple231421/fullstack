#include <iostream>
#include <string>
using namespace std;

class MyClass
{
public:
    void myMethod();
};


void MyClass::myMethod(){
    cout << "Hello World";
}
// 클래스 정의 외부에서 함수를 정의 하려면 클래스 내부에서 함수를 선언한 후
//클래스 외부에서 정의해야 합니다.
//클래스 이름,범위 결정 :: 연산자, 함수 이름을 차례로 지정하면 됩니다.




int main()
{
    MyClass myObj;
    myObj.myMethod();
    return 0;
}
