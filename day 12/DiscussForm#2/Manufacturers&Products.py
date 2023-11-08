def count_manufacturers(products, queries):
    count = 0
    left, right = 0, len(products) - 1
    
    while left <= right:
        mid = left + (right - left) // 2
        if products[mid][0] <= queries <= products[mid][1]:
            count += 1
        if queries < products[mid][0]:
            right = mid - 1
        else:
            left = mid + 1
    
    return count

def main():
    T = int(input())
    for _ in range(T):
        M = int(input())
        products = []
        for _ in range(M):
            S, E = map(int, input().split())
            products.append((S, E))
        Q = int(input())
        for _ in range(Q):
            ID = int(input())
            merchants = count_manufacturers(sorted(products), ID)
            print(merchants)

if __name__ == "__main__":
    main()
