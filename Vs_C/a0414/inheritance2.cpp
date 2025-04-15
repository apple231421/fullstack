#include <iostream>
#include <string>
using namespace std;

class Animal
{
public:
    void animalsound()
    {
        cout << "the animal makes a sound";
    }
};

class pig : public Animal
{
    public:
    void animalsound(){
        cout << "the pig says:wee SS\n";
    }
};
class dog : public Animal
{
    public:
    void animalsound(){
        cout << "the dog says:wee SS\n";
    }
};

int main()
{
    Animal myAnimal;
    pig mypig;
    dog mydog;

    myAnimal.animalsound();
    mypig.animalsound();
    mydog.animalsound();
    return 0;
}
