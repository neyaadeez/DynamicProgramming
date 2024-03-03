# Coin Change Problem

## Test Cases
Test Case 1:
```
Coins: [1, 2, 5]
Amount: 5
Expected Output - Least Number of Coins: 1
Expected Output - Number of Ways: 4
```

Test Case 2:
```
Coins: [1, 2, 5]
Amount: 11
Expected Output - Least Number of Coins: 3
Expected Output - Number of Ways: 11
```

Test Case 3:
```
Coins: [2]
Amount: 3
Expected Output - Least Number of Coins: answer should be considered as 0 (returned value is Infinity() or 2147483647)
Expected Output - Number of Ways: 0
```

Test Case 4:
```
Coins: [1, 3, 4]
Amount: 7
Expected Output - Least Number of Coins: 2
Expected Output - Number of Ways: 5
```

Test Case 5:
```
Coins: [2, 3, 4, 5]
Amount: 10
Expected Output - Least Number of Coins: 2
Expected Output - Number of Ways: 7
```

## Approach 1: DFS Approach

The coin change problem is a classic algorithmic problem often solved using dynamic programming. However, it can also be solved using depth-first search (DFS) with backtracking. Here's how you can approach solving the coin change problem using DFS with backtracking:
1. **Formulate the problem**: Given a target amount and a set of coin denominations, find the total number of ways to make up that amount using any combination of coins.
2. **Define the DFS function**: Create a recursive function that explores all possible combinations of coins to reach the target amount.
3. **Base case**: Define the base case for the recursion. This is when the target amount becomes 0, meaning we have found a valid combination of coins.
4. **Recursive step**: In each recursive call, try using each coin denomination available. Recur with the updated target amount and keep track of the number of ways found.

## Approach 2: Bottom-Up Dynamic Programming

### Steps:
1. **Define the subproblem**:
    - In this approach, we define the subproblem as finding the minimum number of coins needed to make each amount from 0 to the target amount.

2. **Formulate the recurrence relation**:
    - We initialize an array `dp` of size `amount + 1` to store the minimum number of coins needed for each amount.
    - The base case is `dp[0] = 0`, as zero coins are needed to make zero amount.
    - For each amount `i` from 1 to the target amount, we iterate through each coin denomination `j` and update `dp[i]` to the minimum of its current value and `dp[i - j] + 1`, where `dp[i - j]` represents the minimum number of coins needed for the remaining amount after using coin `j`.

3. **Bottom-up computation**:
    - We compute the minimum number of coins needed for each amount from 1 to the target amount, iteratively building up the solution until we reach the target amount.

