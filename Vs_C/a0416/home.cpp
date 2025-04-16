#include <iostream>
#include <vector>
#include <string> // string 타입 사용
using namespace std;

// book 구조체 정의
struct book
{
    string title;       // 책 제목
    bool isBorrowed;    // 대출 여부

    // 생성자: 객체 초기화
    book(string t) : title(t), isBorrowed(false) {}
};

// 도서 상태를 출력하는 함수
void disbook(bool isBorrowed)
{
    if (isBorrowed)
    {
        cout << "대출 중" << endl;
    }
    else
    {
        cout << "대출 가능" << endl;
    }
}

int main()
{
    vector<book> library; // book 객체를 저장하는 벡터
    int ch;               // 사용자 입력 번호

    // 도서 추가
    library.push_back(book("C++ 입문서"));
    library.push_back(book("자료구조론"));
    library.push_back(book("알고리즘 기초"));

    // 메뉴 반복
    while (true)
    {
        // 메뉴 출력
        cout << "\n=== 도서 대출 프로그램 ===\n";
        cout << "1. 도서 목록 확인\n";
        cout << "2. 도서 대출\n";
        cout << "3. 도서 반납\n";
        cout << "4. 프로그램 종료\n";
        cout << "선택: ";
        cin >> ch;

        if (ch == 1) // 도서 목록 확인
        {
            cout << "\n--- 도서 목록 ---" << endl;
            for (int i = 0; i < library.size(); ++i)
            {
                cout << i + 1 << ". 책 제목: " << library[i].title
                     << ", 상태: ";
                disbook(library[i].isBorrowed); // 대출 상태 출력
            }
        }
        else if (ch == 2) // 도서 대출
        {
            int bookNum;
            cout << "\n대출할 도서 번호 (1~" << library.size() << "): ";
            cin >> bookNum;

            if (bookNum < 1 || bookNum > library.size())
            {
                cout << "잘못된 번호입니다. 다시 확인하세요.\n";
            }
            else if (library[bookNum - 1].isBorrowed)
            {
                cout << library[bookNum - 1].title << " 도서는 이미 대출 중입니다.\n";
            }
            else
            {
                library[bookNum - 1].isBorrowed = true;
                cout << library[bookNum - 1].title << " 도서를 대출하였습니다.\n";
            }
        }
        else if (ch == 3) // 도서 반납
        {
            int bookNum;
            cout << "\n반납할 도서 번호 (1~" << library.size() << "): ";
            cin >> bookNum;

            if (bookNum < 1 || bookNum > library.size())
            {
                cout << "잘못된 번호입니다. 다시 확인하세요.\n";
            }
            else if (!library[bookNum - 1].isBorrowed)
            {
                cout << library[bookNum - 1].title << " 도서는 이미 반납된 상태입니다.\n";
            }
            else
            {
                library[bookNum - 1].isBorrowed = false;
                cout << library[bookNum - 1].title << " 도서를 반납하였습니다.\n";
            }
        }
        else if (ch == 4) // 프로그램 종료
        {
            cout << "프로그램을 종료합니다.\n";
            break;
        }
        else
        {
            cout << "잘못된 입력입니다. 다시 선택해주세요.\n";
        }
    }

    return 0;
}