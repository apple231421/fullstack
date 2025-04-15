#include <stdio.h>

int main()
{
    float mynum = 19.99;
    printf("%.2f\n", mynum); // 1f는 소용없음
    printf("%.1f\n", mynum); 
    printf("%10.f", mynum); 
}
