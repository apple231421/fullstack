#include <stdio.h>

int main()
{
    int a;
    printf("정수를 입력해주세요 : ");
    scanf("%d", &a);

    if (a%2==0)
    {
        printf("%d는 짝수입니다",a);
    }else{
        printf("%d는 홀수입니다",a);
    }
    

    return 0;
}
