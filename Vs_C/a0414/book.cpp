#include <iostream>
#include <string>
using namespace std;

class Book {
private:
    string title;
    string author;
    int price;

public:
    // 생성자
    Book(string t, string a, int p) {
        title = t;
        author = a;
        price = p;
    }

    // 책 정보 출력 함수
    void printInfo() {
        cout << "제목: " << title << "\n";
        cout << "저자: " << author << "\n";
        cout << "가격: " << price << "원" << "\n";
    }
};

int main() {
    Book book1("아아아ㅏ", "나마나ㅏㄴ", 12000);
    book1.printInfo();

    return 0;
}
