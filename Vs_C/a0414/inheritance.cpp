#include <iostream>
#include <string>
using namespace std;

class Vehicle
{
public: // public으로 변경
    string brand = "Ford";

    void honk()
    {
        cout << "Tuut, tuut!\n";
    }
};

class Car : public Vehicle
{
public:
    string model = "Mustang";
};

int main()
{
    Car myCar;
    myCar.honk();
    cout << myCar.brand + " " + myCar.model << "\n";
    return 0;
}
