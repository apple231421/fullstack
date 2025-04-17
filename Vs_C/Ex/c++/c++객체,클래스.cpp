#include <iostream>
#include <string>
using namespace std;

// Member 클래스 선언
class Member {
private:
    string name;
    string gender;
    int age;

public:
    // 생성자
    Member(string n, string g, int a) : name(n), gender(g), age(a) {}

    // 멤버 정보 출력
    void printInfo() {
        cout << name << " " << gender << " " << age << "살" << endl;
    }
};

int main() {
    // 객체 생성
    Member mobj1("홍길동", "남성", 21);
    Member mobj2("아이유", "여성", 18);

    // 출력
    mobj1.printInfo();
    mobj2.printInfo();

    return 0;
}