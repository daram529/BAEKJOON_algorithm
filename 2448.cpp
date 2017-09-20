#include <iostream>
using namespace std;

void star(int n)
{
    printf("  *\n * * \n*****\n");

}

int main()
{
    int n;
    cin >> n;
    int loop = 0;
    for (int i=0; i < n; i++)
    {
        for (int j=0; j<n--i; j++)
            printf(" ");

    }
}
