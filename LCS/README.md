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
