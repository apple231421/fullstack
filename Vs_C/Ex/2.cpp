#include <iostream>
using namespace std;

int main()
{
    int numbers[5];
    int max;

    cout << "5개의 정수를 입력하세요: ";
    for (int i = 0; i < 5; i++)
    {
        cin >> numbers[i];
    }

    max = numbers[0];
    for (int i = 1; i < 5; i++)
    {
        if (numbers[i] > max)
        {
            max = numbers[i];
        }
    }

    cout << "가장 큰 값은 " << max << " 입니다." << endl;

    return 0;
}
