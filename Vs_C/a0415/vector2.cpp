#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"vol", "bmw", "ford", "mazda"};

    cout << cars.front() << "\n"; // 맨앞
    cout << cars.back() << "\n";  // 맨뒤
    // cout << cars.at(6) << "\n";   오류가 있을때 알려줌

    return 0;
}

// 배열w