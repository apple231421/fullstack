#include <iostream> // C++ 표준 입출력 헤더
using namespace std;

int main()
{
    int num;
    int sum = 0;

    // 사용자 입력 받기
    cout << "양의 정수를 입력하세요: ";
    cin >> num;

    if (num < 0)
    {
        cout << "양의 정수를 입력하세요" << endl;
        return 1; // 프로그램을 종료
    }

    // 자릿수의 합 계산
    while (num > 0)
    {
        sum = sum + num % 10; // 마지막 자릿수를 sum에 추가
        num = num / 10;       // 마지막 자릿수를 제거
    }

    // 결과 출력
    cout << "각 자릿수의 합은: " << sum << endl;

    return 0;
}