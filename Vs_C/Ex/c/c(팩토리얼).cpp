// 정수 n을 구하여 n!(팩토리얼)을 구하시오 함수로 만들기 c언어로

#include <stdio.h>

// 팩토리얼 함수 정의
int factorial(int n)
{
    int result = 1;
    for (int i = 1; i <= n; i++)
    {
        result *= i;
    }
    return result;
}

int main()
{
    int n =5;

    printf("정수를 입력하세요: ");
    scanf("%d", &n);

    if (n < 0)
    {
        printf("음수는 팩토리얼을 계산할 수 없습니다.\n");
    }
    else
    {
        int result = factorial(n);
        printf("%d 팩토리얼은 %d 입니다.\n", n, result);
    }

    return 0;
}
