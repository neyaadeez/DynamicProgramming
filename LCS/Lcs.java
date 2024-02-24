import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Lcs {
    int iterations = 0;
    public String lcsTraceBack(String x, String y, int[][] lcs){
        String lcsString = "";
        int i = x.length();
        int j = y.length();
        while(i>0 && j>0){
            if(x.charAt(i-1) == y.charAt(j-1)){
                lcsString = x.charAt(i-1) + lcsString;
                i--;
                j--;
            }
            else if(lcs[i][j-1] > lcs[i-1][j]){
                j--;
            }else
                i--;
        }
        return lcsString;
    }
    public String bottomUpApproach(String x, String y){
        iterations = 0;
        int[][] lcs = new int[x.length()+1][y.length()+1];
        for(int i=0; i<=x.length(); i++){
            lcs[i][0] = 0;
            iterations++;
        }
        for(int j=0; j<=y.length(); j++){
            lcs[0][j] = 0;
            iterations++;
        }
        for(int i=1; i<=x.length(); i++){
            for(int j=1; j<=y.length(); j++){
                iterations++;
                if(x.charAt(i-1) == (y.charAt(j-1))){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
                //LCS String TrackBack
        return lcsTraceBack(x, y, lcs);
    }

    public List<String> generateSubsequence(String s){
        iterations++;
        List<String> subSequence = new ArrayList<>();

        if(s.length() == 0){
            subSequence.add("");
        }else{
            List<String> subSeqWithoutFirst = generateSubsequence(s.substring(1));
            subSequence.addAll(subSeqWithoutFirst);
            char firstChar = s.charAt(0);
            for(String subs: subSeqWithoutFirst){
                iterations++;
                subSequence.add(firstChar + subs);
            }
        }
        return subSequence;
    }

    public String naiveApproach(String x, String y){
        iterations = 0;
        List<String> subSeqofx = new ArrayList<>();
        List<String> subSeqofy = new ArrayList<>();
        String lcs = "";
        subSeqofx = generateSubsequence(x);
        subSeqofy = generateSubsequence(y);
        for(String s1: subSeqofx){
            for(String s2: subSeqofy){
                iterations++;
                if(s1.equals(s2) && lcs.length() < s1.length()){
                    lcs = s1;
                }
            }
        }
        return lcs;
    }
    public static void main(String[] args){
        Lcs lcs = new Lcs();
        System.out.println("Longest Common Subsequence");
        System.out.println("1. Naive Approach");
        System.out.println("2. Botton-Up DP Approach");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Enter String 1: ");
        String str1 = sc.next();
        System.out.println("Enter String 2: ");
        String str2 = sc.next();
        sc.close();
        String answer = "";
        switch(x){
            case 1:
                answer = lcs.naiveApproach(str1, str2);
                System.out.println("Naive Approach Answer: "+ answer);
                System.out.println("LCS Length: "+ answer.length());
                System.out.println("Iterations: "+ lcs.iterations);
                break;
            case 2:
                answer = lcs.bottomUpApproach(str1, str2);
                System.out.println("Botton-Up Approach Answer: "+ answer);
                System.out.println("LCS Length: "+ answer.length());
                System.out.println("Iterations: "+ lcs.iterations);
                break;
            default:
                System.out.println("Wrong Choice.");
        }

    }
}