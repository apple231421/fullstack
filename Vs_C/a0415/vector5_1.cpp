#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"vol", "bmw", "ford", "mazda"};

    cars.push_back("렉서스");

    for (string car : cars)
    {
        cout << car << "\n";
    }

    return 0;
}

// 배열w