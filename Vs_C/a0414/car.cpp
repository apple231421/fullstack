#include <iostream>
#include <string>
using namespace std;

class Car
{
private:
    string carName;
    int speed;

public:
    Car(string name)
    {
        carName = name;
        speed = 0; 
    }

    void speedUp()
    {
        speed += 10;
        cout << carName << " 속도 ↑: " << speed << "km/h" << "\n";
    }


    void speedDown()
    {
        if (speed >= 10)
            speed -= 10;
        else
            speed = 0;
        cout << carName << " 속도 ↓: " << speed << "km/h" << "\n";
    }

    void printStatus()
    {
        cout << carName << " 현재 속도: " << speed << "km/h" << "\n";
    }
};

int main()
{
    Car myCar("아반때");

    myCar.printStatus();
    myCar.speedUp();
    myCar.speedUp();
    myCar.speedDown();
    myCar.printStatus();

    return 0;
}
