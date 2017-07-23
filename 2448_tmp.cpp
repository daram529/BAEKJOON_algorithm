#include <iostream>
#include <math.h>
#include <algorithm>
#include <cstring>

void star(char **output, int r, int c, int n, int k)
{
    if (n > 3)
    {
        star(output, r, c, n / 2, k - 1);
        star(output, r + n / 2, c - n / 2, n / 2, k - 1);
        star(output, r + n / 2, c + n / 2, n / 2, k - 1);
    }
    else
    {
        output[r][c] = '*';
        output[r + 1][c - 1] = output[r + 1][c + 1] = '*';
        for (int i = 0; i < 5; i++)
        output[r + 2][c - 2 + i] = '*';
    }
}

int main()
{
    int n;
    double k;
    char **output;
    scanf("%d", &n);
    k = log2(n / 3);

    output = (char **)calloc(n, sizeof(char*));
    for (int i = 0; i < n; i++)
    {
        output[i] = (char *)calloc(2 * n, sizeof(char));
        memset(output[i], ' ', sizeof(char) * 2 * n - 1);
    }

    star(output, 0, n - 1, n, (int)k);
    for (int i = 0; i < n; i++)
        puts(output[i]);
}
