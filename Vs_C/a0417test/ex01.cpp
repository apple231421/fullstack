#include <stdio.h>

int main()
{
    int a;
    int b;

    printf("1번째 정수를 입력해주세요: ");
    scanf("%d", &a);

    printf("2번째 정수를 입력해주세요: ");
    scanf("%d", &b);

    // 계산 변수
    int sum = a + b; // 더하기
    int dif = a - b; // 빼기
    int sub = a * b; // 곱
    int asd = a / b; // 몫
    int abc = a % b; // 나머지

    // 결과 출력
    printf("합: %d\n", sum);
    printf("빼기: %d\n", dif);
    printf("곱: %d\n", sub);
    printf("몫: %d\n", asd);
    printf("나머지: %d\n", abc);

    return 0;
}