#include <stdio.h>

int main()
{
    int myNum;
    char mychar;
    char txt[] = "we are the so-called \"vikings\" from the north";
    
    scanf("%d %c", myNum, mychar);  // & 연산자 추가
    
    printf("your number: %d\n", myNum);
    printf("your char: %c\n", mychar); // %d를 %c로 수정
    
    return 0;
}