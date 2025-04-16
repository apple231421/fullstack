#include <iostream>
#include <queue>
using namespace std;

int main()
{
    queue<int> q;

    // q에 데이터 추가(push)
    // FIFO(First In First Out)
    q.push(10);
    q.push(20);
    q.push(30);

    // front()는 큐의 맨 앞의 값을 반환
    cout << "현재 큐의 맨 앞 값: " << q.front() << endl; // 10

    // back()은 큐의 맨 뒤의 값을 반환
    cout << "현재 큐의 맨 뒤 값: " << q.back() << endl; // 30

    // 데이터 제거 (pop)
    q.pop();                                              // 10 제거
    cout << "pop 이후의 맨 앞 값: " << q.front() << endl; // 20

    // 큐의 크기
    cout << "현재 큐 크기: " << q.size() << endl; // 2

    // 큐가 비어 있을 때까지 값을 출력하며 제거
    while (!q.empty())
    {
        cout << "큐에서 꺼낸 값: " << q.front() << endl; // 20, 30 (순서대로 출력)
        q.pop();                                         // 큐에서 값을 제거
    }

    return 0;
    // push(x): 데이터를 큐의 뒤쪽에 삽입합니다.
    // pop(): 큐의 앞쪽 데이터를 제거합니다. (값을 반환하지는 않음)
    // front(): 큐의 가장 앞쪽 값을 반환합니다.
    // back(): 큐의 가장 뒤쪽 값을 반환합니다.
    // empty(): 큐가 비어 있는지 확인합니다. (true or false 반환)
    // size(): 현재 큐에 들어 있는 데이터의 개수를 반환합니다.
}