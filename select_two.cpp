#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int max_first = -1000;
    int max_second = -1000;
    int x;
    if (n==1)
    {
        cin >> x;
        printf("%d\n", x);
    }
    else
    {    
        for (int i=0; i < n; i++)
        {
            cin >> x;
            if (i < 2)
            {
                if (i==0)
                    max_first = x;
                if (i==1)
                    max_second = x;
            }
            else
            {

                if (max_first > max_second)
                {
                    if (x > max_second)
                        max_second = x;
                }
                else
                {
                    if (x > max_first)
                        max_first = x;
                }
            }
        }
        printf("%d\n", max_first + max_second);
    }

    return 0;
}
