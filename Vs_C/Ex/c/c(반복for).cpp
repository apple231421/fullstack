#include <stdio.h>

int main() {
    int n, sum;

    printf("정수를 입력하세요: ");
    scanf("%d", &n);

    for (int i = 1; i <= n; i++) {
        sum = sum + i; // i 값을 sum에 더함
    }

    printf("1부터 %d까지의 합: %d\n", n, sum);

    return 0;
}