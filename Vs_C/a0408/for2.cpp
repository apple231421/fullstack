#include <stdio.h>

int main()
{
    for (int i = 1; i <= 2; i++){
    printf("outer :%d\nd",i);
    for (int j = 0; j <=3; j++){
        printf("Inner : %d\n",j);
    }
    
    return 0;
}
}