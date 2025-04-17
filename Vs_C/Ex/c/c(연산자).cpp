#include <stdio.h>

int main()
{
    int a, b;                     // 두 정수를 저장할 변수
    int sum, difference, product; // 연산 결과 저장 변수
    double division;              // 나눗셈 결과 저장 변수

    // 사용자 입력 받기
    printf("첫 번째 정수를 입력하세요: ");
    scanf("%d", &a);

    printf("두 번째 정수를 입력하세요: ");
    scanf("%d", &b);

    // 사칙연산 수행
    sum = a + b;        // 덧셈
    difference = a - b; // 뺄셈
    product = a * b;    // 곱셈

    // 0으로 나누기를 방지
    if (b != 0)
    {
        division = (double)a / b; // 나눗셈 (b가 0이 아닐 때만 계산)
        printf("나눗셈 결과: %.2f\n", division);
    }
    else
    {
        printf("나눗셈 결과: 0으로 나눌 수 없습니다.\n");
    }

    // 결과 출력
    printf("합: %d\n", sum);
    printf("차: %d\n", difference);
    printf("곱: %d\n", product);

    return 0;
}