#include <stdio.h>
void calculatesum(int x, int y)
{
    int sum = x + y;
    printf("x is %d, y is %d\nsum is %d\n", x, y, sum);
}
int main()
{
    calculatesum(5, 3);
    calculatesum(8, 2);
    calculatesum(15, 15);
    return 0;
}