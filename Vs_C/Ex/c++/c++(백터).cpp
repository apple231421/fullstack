#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"Volvo", "BMW", "Ford"};

    // 요소 추가 맨뒤에 추가
    cars.push_back("Mazda"); // { "Volvo", "BMW", "Ford", "Mazda" }

    // 요소 삭제 마지막요소 삭제
    cars.pop_back(); // { "Volvo", "BMW", "Ford" }

    // 특정 위치에 요소 삽입
    cars.insert(cars.begin() + 1, "Hyundai"); // { "Volvo", "Hyundai", "BMW", "Ford" }

    // 특정 위치의 요소 제거
    cars.erase(cars.begin()); // { "Hyundai", "BMW", "Ford" }

    // 출력
    for (const auto &car : cars)
    {
        cout << car << " ";
    }
    return 0;
}