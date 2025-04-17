#include <stdio.h>

int fact(int a)
{
    int result = 1;
    for (int i = 1; i <= a; i++)
    {
        result *= i;
    }
    return result;
}

int main()
{
    int a;

    printf("정수를 입력하세요: ");
    scanf("%d", &a);

    int result = fact(a);
    printf("%d!은 %d 입니다.\n", a, result);

    return 0;
}
