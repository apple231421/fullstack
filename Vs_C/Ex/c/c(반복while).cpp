#include <stdio.h>

int main()
{
    int i = 1;      // 초기값 설정
    int n, sum = 0; // n 입력값과 합을 저장할 변수

    // 사용자 입력
    printf("정수를 입력하세요: ");
    scanf("%d", &n);

    // while 반복문에서 짝수 합 계산
    while (i <= n)
    {
        if (i % 2 == 0)
        {             // 짝수인지 확인
            sum += i; // 짝수라면 sum에 추가
        }
        i++; // i 값을 증가
    }

    // 결과 출력
    printf("1부터 %d까지의 짝수의 합: %d\n", n, sum);

    return 0;
}