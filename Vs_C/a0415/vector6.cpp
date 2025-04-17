#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"vol", "bmw", "ford", "mazda"};
    // auto it = cars.begin();       // 첫번쨰 vol를 뜻함
    auto it = cars.begin() + 2; // 인덱스 2번위치(3번째자리)
    cars.insert(it, "Hyundai"); // bmw 뒤에 삽입
    for (string car : cars)
    {
        cout << car << "\n";
    }

    return 0;
}
