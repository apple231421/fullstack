#include <iostream>
#include <stack>
using namespace std;

int main()
{
    stack<int> s;
    // 스택에 값을 넣기
    s.push(10);
    s.push(20);
    s.push(30);
    cout << "현재 스택의 맨 위 값 : " << s.top() << endl; // 30

    s.pop();                                              // 스택에서 값 꺼내기
    cout << "현재 스택의 맨 위 값 : " << s.top() << endl; // 20

    if (!s.empty())
    {
        cout << "스택은 비어있지 않습니다 " << endl; // 20
    }
    cout << "현재 스택의 크기 : " << s.size() << endl; // 30을 꺼내서 2임

    while (!s.empty())
    {
        cout << "스택에서 꺼낸 값 : " << s.top() << endl; // 20
        s.pop();
    }

    return 0;

    // push() -> 값넣기
    // pop -> 값 꺼내기
    // top() -> 맨위 값 확인
    // empty() -> 스택이 비었는지 확인
    // size -> 현재 스택 크기 확인
}
