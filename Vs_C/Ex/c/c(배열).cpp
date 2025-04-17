#include <stdio.h>

int main() {
    int numbers[5] = {10, 20, 30, 40, 50}; // 정수형 배열 선언 및 초기화

    // 배열 요소 출력
    printf("배열 출력:\n");
    for (int i = 0; i < 5; i++) {
        printf("numbers[%d] = %d\n", i, numbers[i]);
    }

    return 0;
}