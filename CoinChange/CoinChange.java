import java.util.Scanner;

public class CoinChange {
    int ways = 0;

    public int bottomUpApproach(int[] coins, int amount){
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<= amount; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i=1; i<=amount; i++){
            for (int j : coins) {
                if(i-j >= 0){
                    dp[i] = Math.min(dp[i], dp[i - j] != Integer.MAX_VALUE ? dp[i - j] + 1: Integer.MAX_VALUE);
                }
            }
        }
        
        if(dp[amount] != Integer.MAX_VALUE) 
            return dp[amount]; 
        else 
            return -1;
    }

    public int noWays(int[] coins, int n, int amount){
        if(amount == 0){
            return 1;
        }

        if(amount < 0){
            return 0;
        }

        if(n <= 0){
            return 0;
        }

        return noWays(coins, n, amount-coins[n-1]) + noWays(coins, n-1, amount);
    }

    public int DFS(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0)
            return Integer.MAX_VALUE;

        int count = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++){
            int res = DFS(coins, amount-coins[i]);
            if(res != Integer.MAX_VALUE){
                count = Math.min(count, res+1);
            }
        }

        return count;
    }
    public static void main(String[] args){
        CoinChange cc = new CoinChange();
        System.out.println("Coin Change Problem");
        System.out.println("1. DFS Approach");
        System.out.println("2. Botton-Up DP Approach");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Enter Number of Coins: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter Values: ");
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        System.out.println("Enter the Amount: ");
        int amount = sc.nextInt();
        sc.close();
        int answer = 0;
        switch(x){
            case 1:
                answer = cc.DFS(coins, amount);
                System.out.println("DFS Approach Answer: "+ answer);
                System.out.println("Number of Ways: "+ cc.noWays(coins, n, amount));
                break;
            case 2:
                answer = cc.bottomUpApproach(coins, amount);
                System.out.println("Botton-Up Approach Answer: "+ answer);
                break;
            default:
                System.out.println("Wrong Choice.");
        }

    }
}
