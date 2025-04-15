#include <stdio.h>
void myFuntion(char name[],int age){
    printf(" i love you %s, oyou old %d\n",name,age);
}
int main()
{
    myFuntion("Liam",30);
    myFuntion("Jenny",20);
    myFuntion("Anja",18);
    return 0;
}