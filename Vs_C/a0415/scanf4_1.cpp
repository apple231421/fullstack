#include <iostream>
using namespace std;

int main()
{
    int a, b, c;
    cout << "세 수를 입력하세요: \n";
    cin >> a >> b >> c;

    int max = (a > b) ? a : b;
    max = (max > c) ? max : c;

    cout << "가장 큰 수는: " << max << endl;

    return 0;
}

// 배열