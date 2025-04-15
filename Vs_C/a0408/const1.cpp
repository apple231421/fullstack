#include <stdio.h>

int main()
{
    const int myNum = 15;
    // myNum = 10; 재할당 불가능

    // const int mintesPerHour;
    // mintesPerHour = 60;
    const int mintesPerHour = 60; // 상수는 선언과 함께 초기화
    printf("%d", myNum);
    return 0;
}
