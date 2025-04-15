#include <stdio.h>

 myFunction(int x, int y)  // 반환 타입 int 추가
{
    return y + x;
}

int main()
{
    printf("결과값은: %d", myFunction(5,3));
    return 0;
}