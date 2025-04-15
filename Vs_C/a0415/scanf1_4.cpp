#include <stdio.h>
// 실수
int main(){
    float n;
    scanf("%f", &n);
    printf("%.2f",n); // 소수 2째자리까지 나옴 3번쨰 자리에서 반올림함 
    return 0;
}