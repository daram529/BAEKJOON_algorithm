#include <iostream>
#include <algorithm>
using namespace std;

int bongji(int n);

int bongji(int n)
{
    if (n <= 5)
    {
         if (n==5)
         {
             return 1;
         }
         if (n==3)
         {
             return 1;
         }
         if (n%5 != 0 && n%3 !=0)
             return 10000;
    }
    return 1 + min(bongji(n-5), bongji(n-3));
}

int main()
{
    int input;
    scanf("%d", &input);
    int output = bongji(input);
    if (output > 9999)
        output = -1;
    cout << output << endl;
}
