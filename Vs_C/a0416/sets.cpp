#include <iostream>
#include <deque>
#include <algorithm> // std::find 사용을 위해 포함

using namespace std;

int main()
{
    deque<int> myset = {10, 20, 30, 40, 50}; // deque 초기화

    // 현재 데큐 요소 출력
    cout << "현재 데큐 요소들: ";
    for (int num : myset) // myset 사용 (dq -> myset으로 변경)
    {
        cout << num << " ";
    }
    cout << endl;

    // 찾고자 하는 값
    int valueToFind = 30;

    // std::find를 사용하여 값 찾기
    auto it = find(myset.begin(), myset.end(), valueToFind);

    // std::find의 결과 확인
    if (it != myset.end())
    {
        // 값이 존재하는 경우
        cout << valueToFind << "을(를) 찾았습니다." << endl;
    }
    else
    {
        // 값이 존재하지 않는 경우
        cout << "값 " << valueToFind << "를 찾을 수 없습니다." << endl;
    }

    return 0;
}
// insert():값을 셋에 삽입합니다. 중복 값은 삽입되지 않습니다.

// find(): 특정 값을 탐색합니다.
// 반환값: 찾은 값의 반복자를 반환하거나, 값이 없으면 end()를 반환합니다.
// erase(): 특정 값을 삭제하거나, 반복자를 통해 값을 삭제할 수 있습니다.
// size(): 현재 셋의 원소 개수를 반환합니다.
// empty(): 셋이 비어 있는지 여부를 반환합니다 (값이 없으면 true).
// clear(): 모든 요소를 삭제하여 셋을 비웁니다.