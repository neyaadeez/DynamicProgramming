import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Lcs {
    int iterations = 0;
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

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println("Enter String 1: ");
        String str1 = sc.next();
        System.out.println("Enter String 2: ");
        String str2 = sc.next();
        sc.close();
        switch(x){
            case 1:
                System.out.println("Naive Approach Answer: "+lcs.naiveApproach(str1, str2));
                System.out.println("Iterations: "+ lcs.iterations);
                break;
            default:
                System.out.println("Wrong Choice.");
        }

    }
}