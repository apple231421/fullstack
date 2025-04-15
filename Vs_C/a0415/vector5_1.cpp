#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<string> cars = {"vol", "bmw", "ford", "mazda"};

    cars.push_back("렉서스");
    cars.push_back("vw");
    cars.push_back("miasdf");
    cars.push_back("asdvsad");
    for (string car : cars)
    {
        cout << car << "\n";
    }

    return 0;
}

// 배열w