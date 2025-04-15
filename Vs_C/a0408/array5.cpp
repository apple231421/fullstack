#include <stdio.h>

int main()
{

    int mynumbers[] = {10, 25, 50, 75,100};
    int length = sizeof(mynumbers) /sizeof(mynumbers[0]);
    printf("%d",length);
    return 0;
}