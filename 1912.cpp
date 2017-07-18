#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int sum = -1000;
    int sum_tmp = -1000;
    int sum_neg = -1000;
    bool cons = false;
    bool cons_neg = false;
    int x;
    bool all_neg = true;
    int max_tmp = -1000;
    for (int i = 0; i < n; i ++)
    {
        cin >> x;
        if (x > max_tmp)
            max_tmp = x;
        if (i == 0)
        {
            sum = x;
            sum_tmp = x;
        }
        if (x > 0)
        {
            all_neg = false;
            if (cons_neg)
            {
                cons_neg = false;
                if ((sum_neg + sum_tmp) < 0)
                    cons = false;
                else
                    sum_tmp = sum_tmp + sum_neg;
            }
            if (cons)
                sum_tmp = sum_tmp + x;
            else
            {
                cons = true;
                sum_tmp = x;
            }
        }
        else
        {
            if (cons_neg)
                sum_neg = sum_neg + x;
            else
            {
                cons_neg = true;
                sum_neg = x;
            }
        }
        if (sum < sum_tmp)
            sum = sum_tmp;
    }
    if (all_neg)
        printf("%d\n", max_tmp);
    else
        printf("%d\n", sum);
}
