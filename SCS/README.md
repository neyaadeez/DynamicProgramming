# Finding Shortest Common Supersequence (SCS)

## Test Cases
- Simple Case:
    - String 1: "ABC"
    - String 2: "AC"
    - Expected SCS: "ABC"

- Empty String:
    - String 1: ""
    - String 2: "XYZ"
    - Expected SCS: "XYZ"

- Single Character:
    - String 1: "X"
    - String 2: "Y"
    - Expected SCS: "XY"

- Repeated Characters:
    - String 1: "AAABBB"
    - String 2: "BBBCCC"
    - Expected SCS: "AAABBBCCC"

- Longer Strings:
    - String 1: "AGGTAB"
    - String 2: "GXTXAYB"
    - Expected SCS: "AGGXTXAYB"

## Approach 1: Naive Approach

The shortest common supersequence (SCS) of two sequences is the shortest sequence that contains both sequences as subsequences. 

### Steps:
1. **Generate all possible supersequences**: Generate all possible supersequences by concatenating elements from both sequences in all possible orders.
2. **Check if it contains both sequences**: For each combination generated, check if it contains both input sequences as subsequences.
3. **Find the shortest supersequence**: Among all the combinations that contain both sequences, find the one with the minimum length. This will be the shortest common supersequence.
4. **Return the result**: Return the shortest common supersequence.

### Explaination:
1. **Generate all possible supersequences**:
   To generate all possible supersequences, we need to consider all possible ways of concatenating elements from both sequences. We can achieve this using recursion. At each step of the recursion, we have two choices: we can either take an element from the first sequence or from the second sequence. By exhaustively exploring all possible combinations of these choices, we can generate all supersequences.

   For example, let's say we have two sequences `seq1 = "ABC"` and `seq2 = "XY"`. The possible supersequences can be generated as follows:
   - Start with an empty supersequence.
   - At each step, we can either take an element from `seq1` or from `seq2`.
   - The recursive process will generate supersequences like `"AXYBC"`, `"ABXYC"`, `"ABCXY"`, etc.

2. **Check if it contains both sequences**:
   For each generated supersequence, we need to check whether it contains both input sequences as subsequences. We can do this by iterating through each character of the input sequences and checking if they appear in the supersequence in the same order. If both sequences are found as subsequences within the supersequence, then it satisfies this condition.

3. **Find the shortest supersequence**:
   Among all the supersequences that contain both sequences, we need to find the one with the minimum length. We initialize a variable to keep track of the minimum length found so far and another variable to store the corresponding shortest supersequence. As we generate and check each supersequence, if it meets the condition of containing both input sequences and its length is less than the current minimum length, we update the minimum length and the shortest supersequence accordingly.

## Approach 2: Bottom-Up Dynamic Programming

The problem is to find the shortest common supersequence (SCS) of two given sequences. A supersequence of two sequences is a sequence that contains both sequences as subsequences and is as short as possible.

### Steps:
1. **Define the subproblem**: 
   - Let's define dp[i][j] as the length of the shortest common supersequence of the prefixes seq1[0:i] and seq2[0:j].

2. **Formulate the recurrence relation**: 
   - If seq1[i] == seq2[j], then dp[i][j] = 1 + dp[i-1][j-1] because we can include the matching character once and continue to find the shortest supersequence for the remaining prefixes.
   - If seq1[i] != seq2[j], then dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1]) because we have two options: either include seq1[i] or seq2[j] in the supersequence, and we choose the one which results in the shorter supersequence.

3. **Bottom-up computation**: 
   - We fill in the dp table iteratively, starting from smaller subproblems and building up to larger ones.
   - We initialize the base cases where one of the sequences is empty: dp[i][0] = i and dp[0][j] = j for all i and j.
   - Then, we iterate over the lengths of prefixes of both sequences and compute the values of dp[i][j] according to the recurrence relation.

4. **Extract the solution**: 
   - Once the table is filled, we backtrack through it to construct the shortest common supersequence.
   - Starting from dp[m][n], where m and n are the lengths of the input sequences, we traverse the table backwards, choosing the direction based on whether the characters match or not.
   - We add the characters to the supersequence until we reach dp[0][0], which represents the length of the SCS of the entire sequences.

### BackTrack Supersequence
To backtrack in the dynamic programming table and extract the shortest common supersequence (SCS), you need to start from the bottom-right corner of the table (i.e., dp[m][n], where m and n are the lengths of the input sequences) and move towards the top-left corner (i.e., dp[0][0]). Here's how you can do it:

1. Initialize two pointers, `i` and `j`, to `m` and `n` respectively, where `m` and `n` are the lengths of the input sequences.
2. While `i` is greater than 0 and `j` is greater than 0, do the following:
   - If `seq1[i-1] == seq2[j-1]`, it means the character at index `i-1` in `seq1` is part of the shortest common supersequence. Add this character to the supersequence.
   - Move diagonally up and to the left by decrementing both `i` and `j`.
   - If `seq1[i-1] != seq2[j-1]`, compare `dp[i-1][j]` and `dp[i][j-1]`.
     - If `dp[i-1][j] < dp[i][j-1]`, it means the character at index `i-1` in `seq1` is part of the shortest common supersequence. Move up by decrementing `i`.
     - If `dp[i-1][j] >= dp[i][j-1]`, it means the character at index `j-1` in `seq2` is part of the shortest common supersequence. Move left by decrementing `j`.
3. If `i` is greater than 0, add the remaining characters of `seq1` to the supersequence.
4. If `j` is greater than 0, add the remaining characters of `seq2` to the supersequence.
5. Reverse the supersequence obtained to get the correct order of characters.