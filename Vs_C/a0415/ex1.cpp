#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main()
{
    vector<string> cars(5); 

    for (int i = 0; i < 5; i++)
    {
        cin >> cars[i]; 
    }

    for (int i = 0; i < 5; i++)
    {
        cout << cars[i] << " "; 
    }
    cout << endl;

    return 0;
}
