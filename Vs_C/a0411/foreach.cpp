#include <iostream>
#include <string>

using namespace std;

int main()
{
    int mynumbers[5] = {10, 20, 30, 40, 50};
    for (int i : mynumbers)
    {
        cout << i << "\n";
    }
    return 0;
}