#include <stdio.h>

int main()
{
    char greetings[] = "hello world";
    greetings[0] = 'J';
    printf("%s", greetings);

    return 0;
}