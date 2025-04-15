#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"vol", "bmw", "ford", "mazda"};

    cars.push_back("렉서스");
    cars[0] ="테슬라";
    cars.at(1) ="hyundia";

    cout << cars[0] << "\n";
    cout << cars.at(1) << "\n";
    return 0;
}

// 배열w