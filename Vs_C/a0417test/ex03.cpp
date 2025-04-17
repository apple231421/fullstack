#include <stdio.h>

int main()
{
    printf("1부터 100까지의 정수중 3의배수는 ");
    for (int i = 1; i < 100; i++)
    {

        if (i % 3 == 0)
        {
            printf("%d ", i);
        }
    }

    return 0;
}
