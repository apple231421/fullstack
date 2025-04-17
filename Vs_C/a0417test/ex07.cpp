#include <iostream>
#include <string>
using namespace std;

class Car
{
private:
    string speed;
    string color;

public:
    Car(string s, string c) : speed(s), color(c) {}

    void info()
    {
        cout << "스피드 : " << speed << endl
             << "차량색 : " << color << endl;
    }
};

int main()
{
    Car car("10", "빨간색");

    car.info();

    return 0;
}
