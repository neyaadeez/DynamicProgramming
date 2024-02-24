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
