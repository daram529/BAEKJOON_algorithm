#include <iostream>
using namespace std;

void Eratos(int m, int n)
{
    bool* PrimeArray;

    if (n<=1) return;
    
    PrimeArray = new bool[n+1];

    for (int i=2; i<=n; i++) PrimeArray[i] = true;

    for (int i=2; (i*i)<=n; i++)
    {
        if (PrimeArray[i])
        {
            for (int j=i*i; j<=n; j+=i) PrimeArray[j]=false;
        }
    }

    for (int i = 2; i<=n; i++)
    {
        if (i >= m && PrimeArray[i])
            printf("%d\n", i);
    }
}

int main()
{
    int m,n;
    cin >> m >> n;
    Eratos(m,n);
    return 0;
}
