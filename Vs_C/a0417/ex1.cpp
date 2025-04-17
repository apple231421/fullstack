#include <stdio.h>

int main()
{
    int num;
    int sum = 0;

    // 사용자 입력 받기
    printf("양의 정수를 입력하세요 : \n");
    scanf("%d", &num);

    if (num < 0)
    {
        printf("양의 정수를 입력하세요");
    }

    // 자릿수의 합 계산
    while (num > 0)
    {
        sum = sum + num % 10; // EX) 12345 ->5  1234 -> 4  123->3  12 ->2   1->1
        // sum = sum + ...: 마지막 자릿수를 sum에 더하여 누적합니다
        num = num / 10;                    // EX) 12345 / 10 = 1234
        // num = num / 10: 숫자 num을 10으로 나눠서 마지막 자릿수를 제거합니다

    }

    // 결과 출력
    printf("각 자릿수의 합은: %d\n", sum);

    return 0;
}