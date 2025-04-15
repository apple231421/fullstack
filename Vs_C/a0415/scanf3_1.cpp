#include <stdio.h>

int main()
{
    int a, b,c;
    printf("세 수를 입력하세요:");
    scanf("%d%d%d", &a, &b,&c); 
   
    int max = (a>b) ? a:b;
    max= (max>c) ? max : c;
    
    printf("가장 큰 수는 %d 입니다.\n",max);


    return 0;
}