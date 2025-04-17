#include <iostream>
#include <string>
using namespace std;

int main()
{
    string name;
    int age;
    cout << "사용자의 이름을 입력하세요" << endl;
    cin >> name;
    cout << "사용자의 나이을 입력하세요" << endl;
    cin >> age;

    cout << name << "님은 " << age << "세입니다.";
    return 0;
}
