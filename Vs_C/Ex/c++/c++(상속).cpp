#include <iostream>
#include <string>
using namespace std;

// 부모 클래스
class Person {
protected:
    string name;
    int age;

public:
    // 생성자
    Person(string n, int a) : name(n), age(a) {}

    // 출력 메서드
    void showInfo() {
        cout << "이름: " << name << ", 나이: " << age << endl;
    }
};

// 자식 클래스
class Student : public Person {
private:
    int studentID;

public:
    // 생성자: 부모 클래스의 생성자를 호출
    Student(string n, int a, int id) : Person(n, a), studentID(id) {}

    // 학생 정보 출력
    void showStudentInfo() {
        showInfo(); // 부모 클래스의 메서드 호출
        cout << "학번: " << studentID << endl;
    }
};

int main() {
    // Student 객체 생성
    Student student("홍길동", 21, 2023001);

    // 정보 출력
    student.showStudentInfo();

    return 0;
}