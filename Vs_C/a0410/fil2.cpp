#include <stdio.h>


int main()
{
    FILE * fptr; // 기본적인 데이터 유혀으 사용하려면 포인트 변수 fptr
    fptr = fopen("d:\\student\\filename.txt","w");
    char myString[100];
    fgets(myString,100,fptr);
    // myString - 방금만들 배열에 저장
    // 100 - ㅡString(100)과 일치
    // fptr 파일을 읽는데 사용데는 파일 포인터
    printf("%s",myString);

    fclose(fptr);
    return 0;
}