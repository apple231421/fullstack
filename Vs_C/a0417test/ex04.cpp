#include <stdio.h>

int main()
{
    int numbers[5];
    int max;

    printf("5개의 정수를 입력하세오 : ");
    for (int i = 0; i < 5; i++)
    {
        scanf("%d", &numbers[i]);
    }
    max = numbers[0];
    for (int i = 0; i < 5; i++)
    {
        if (numbers[i] > max)
        {
            max = numbers[i];
        }
    }

    printf("가장 큰 값은 %d 입니다\n", max);

    return 0;
}