# Finding Longest Common Subsequence (LCS)

## Test Cases
- Simple Case:
    - String 1: "ABC"
    - String 2: "AC"
    - Expected LCS: "AC"

- Empty String:
    - String 1: 0
    - String 2: "XYZ"
    - Expected LCS: ""

- Single Character:
    - String 1: "X"
    - String 2: "Y"
    - Expected LCS: ""

- Repeated Characters:
    - String 1: "AAABBB"
    - String 2: "BBBCCC"
    - Expected LCS: "BBB"

- Longer Strings:
    - String 1: "AGGTAB"
    - String 2: "GXTXAYB"
    - Expected LCS: "GTAB"

## Approach 1: Naive Approach

The naive approach involves exploring all possible subsequences of both input sequences and comparing them to find the longest one that is common to both sequences. This approach is straightforward but inefficient for large sequences due to its exponential time complexity.

### Steps:
1. **Generate all subsequences**: Generate all possible subsequences of both input sequences.
2. **Compare subsequences**: Compare each subsequence of one sequence with all subsequences of the other sequence to find the longest common subsequence.
3. **Find the longest common subsequence**: Among all the common subsequences found in the previous step, find the one with the maximum length. This will be the longest common subsequence.
4. **Return the result**: Return the longest common subsequence.

### Explaination:
- Generate all subsequnces
    - Base case: If the string s is empty, return a list containing an empty string [''].
    - Recursive case: Otherwise, generate all subsequences of the string obtained by removing the first character of s. Then, for each of these subsequences, prepend the first character of s to generate new subsequences. Finally, combine the subsequences obtained from the recursive call with and without the first character to get all subsequences of s.
    
    - Example:
        - Base case: The input string is "ABC". Since it's not empty, we move to the recursive case.
        - Recursive case:
        We call generate_subsequences with the substring "BC". This step will recursively generate all subsequences of "BC".
        The base case for "BC" returns ['', 'C', 'B', 'BC']. These are all the subsequences of "BC".
        Now, for each of these subsequences, we prepend 'A' to generate new subsequences: ['A', 'AC', 'AB', 'ABC'].
        We combine the subsequences obtained from the recursive call with and without the first character: ['', 'C', 'B', 'BC'] + ['A', 'AC', 'AB', 'ABC'].
        - Result: The result is ['', 'C', 'B', 'BC', 'A', 'AC', 'AB', 'ABC']. These are all the subsequences of the input string "ABC"

## Approach 2: Bottom-Up Dynamic Programming

The idea is to iteratively build up the solution by solving smaller subproblems and then combining them to solve larger ones.

### Steps:
1. **Define the subproblem**: Identify the subproblems involved in finding the LCS of two sequences.
2. **Formulate the recurrence relation**: Express the solution to each subproblem in terms of the solutions to smaller subproblems.
3. **Bottom-up computation**: Build a table (typically a 2D array) to store the solutions to subproblems and fill it up in a bottom-up manner.
4. **Extract the solution**: Once the table is filled, extract the solution from it.

### Explanation:
- Define the subproblem:
    - Let's say you have two sequences, A and B, of lengths n and m, respectively.
    - Define the subproblem as finding the LCS of A[1..i] and B[1..j], where i ranges from 0 to n and j ranges from 0 to m.

- Formulate the recurrence relation:
    - Let's denote the LCS length of A[1..i] and B[1..j] as LCS[i][j].
    - The base cases are when either i or j is 0, in which case LCS[i][j] is 0.
    - If the last elements of A and B are the same (i.e., A[i] == B[j]), then LCS[i][j] = LCS[i-1][j-1] + 1.
    - Otherwise, LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1]).

- Bottom-up computation:
    - Create a 2D array LCS of size (n+1) x (m+1).
    - Initialize the first row and the first column of LCS with 0.
    - Iterate over the rows and columns of LCS, filling them up according to the recurrence relation.
    - The value at LCS[n][m] will be the length of the LCS.

- Extract the solution:
    - Once the LCS matrix is filled, you can backtrack from LCS[n][m] to construct the actual LCS string. Start from LCS[n][m] and move according to the direction determined by the values in the matrix.