#include <stdio.h>

int main()
{
    int arr[10] = {5, 12, 8, 3, 15, 7, 9, 20, 1, 18};
    int max = arr[0];
    int min = arr[0];
    double avg;
    double sum;

    int size = sizeof(arr) / sizeof(arr[0]); // lenght 대신

    for (int i = 0; i < size; i++)
    {
        sum = sum + arr[i];
        
        if (max < arr[i])
        {
            max = arr[i];
        }
        if (min > arr[i])
        {
            min = arr[i];
        }
    }

    avg = sum / 10;
    printf("평균은 %.2f\n", avg);
    printf("최대값은 %d\n", max);
    printf("최소값은 %d\n", min);

    return 0;
}
