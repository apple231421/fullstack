#include <stdio.h>

 cal(int x, int y)  // 반환 타입 int 추가
{
    return y + x;
}

int main()
{
    int rusult1 = cal(5,3);
    int rusult2 = cal(5,35);
    int rusult3 = cal(31,3);
    printf("결과값은: %d\n", rusult1);
    printf("결과값은: %d\n", rusult2);
    printf("결과값은: %d\n", rusult3);
    return 0;
}