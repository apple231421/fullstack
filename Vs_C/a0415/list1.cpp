#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"vol", "bmw", "ford", "mazda"};

    cars.pop_back();
    for (string car : cars)
    {
        cout << car << "\n";
    }
    cout << cars.size()<<"\n";
    cout << cars.empty(); //비어있으면 1 데이터가 있으면 0
    return 0;
}

// 배열w