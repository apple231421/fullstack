#include <stdio.h>

int main()
{
    char carName[] = "Volvo";
    int length = sizeof(carName) / sizeof(carName[0]);
    // 문자 하나당 4byte 전체 바이트ㅡ수는 20바이트 20/4 = 5
    int i;
    for (i = 0; i < length; ++i){
        printf("%c", carName[i]);
    }
    return 0;
}