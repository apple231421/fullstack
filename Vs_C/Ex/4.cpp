// 객체 지정후 member 클래스 만들고  c언어로

#include <stdio.h>
#include <string.h>


struct Member
{
    char name[20];
    char gender[10];
    int age;
};

int main()
{
    // 객체 생성
    struct Member mobj1;
    struct Member mobj2;

    // 값 설정
    strcpy(mobj1.name, "홍길동");
    strcpy(mobj1.gender, "남성");
    mobj1.age = 21;

    strcpy(mobj2.name, "아이유");
    strcpy(mobj2.gender, "여성");
    mobj2.age = 18;

    // 출력
    printf("%s %s %d살\n", mobj1.name, mobj1.gender, mobj1.age);
    printf("%s %s %d살\n", mobj2.name, mobj2.gender, mobj2.age);

    return 0;
}
