#include <iostream>
#include <string>
using namespace std;

// Student 구조체 정의
struct Student
{
    string name;   // 이름
    int studentid; // 학번
    char grade;    // 학점

    // 생성자 정의
    Student(string nm, int id, char ig)
    {
        name = nm;
        studentid = id;
        grade = ig;
    }

    // 학생 정보 출력 함수
    void displayInfo()
    {
        cout << "\n------ 학생 정보 -------\n";
        cout << "이름  : " << name << endl;
        cout << "학번  : " << studentid << endl;
        cout << "학점  : " << grade << endl;
    }
};

int main()
{
    string name;
    int studentid;
    char grade;

    // 사용자 입력 받기
    cout << "이름을 입력해주세요: ";
    getline(cin, name);

    cout << "학번을 입력해주세요: ";
    cin >> studentid;

    cout << "학점을 입력해주세요: ";
    cin >> grade;

    // 생성자를 통해 학생 객체 생성
    Student s(name, studentid, grade);

    // 학생 정보 출력
    s.displayInfo();

    return 0;
}