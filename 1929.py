prime_list = [2]

def check_prime(n):
    for x in prime_list:
        if n % x == 0:
            return False
    return True

n, m = map(int, input().split())
for i in range(3, m+1):
    if check_prime(i):
        prime_list.append(i)
        if  i > n:
            print(i)
