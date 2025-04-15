#include <stdio.h>

void myFunction()
{
    int x = 5;
    printf("%d\n", x);
}

int main()
{
    myFunction();
    printf("%d\n", x);
    return 0;
}