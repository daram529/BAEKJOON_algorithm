#include <iostream>
#include <algorithm>
using namespace std;

int sugar(int input)
{
    if (input % 5 == 0)
        return input/5;
    else
    {
        int maxFive = input/5;
        int remain;
        for (int i = maxFive; i >= 0; i--)
        {
            remain = input - i * 5;
            if (remain % 3 == 0)
                return (remain/3) + i;
        }
        return -1;
    }
}

int main()
{
    int input;
    scanf("%d", &input);
    int output = sugar(input);
    printf("%d", output);
    return 0;
}

