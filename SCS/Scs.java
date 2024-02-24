import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Scs {
    int iterations = 0;
    public boolean checkSeq(String x, String superSeq){
        int index = 0;
        for(int i = 0; i<superSeq.length(); i++){
            iterations++;
            if(index < x.length() && x.charAt(index) == superSeq.charAt(i)){
                index++;
            }
        }
        return index == x.length();
    }

    public void generateSuperSeq(String x, String y, String superSeq, List<String> tempSuper) {
        if (x.length() == 0) {
            tempSuper.add(superSeq + y);
            return;
        }
        if (y.length() == 0) {
            tempSuper.add(superSeq + x);
            return;
        }

        if (x.charAt(0) == y.charAt(0)) {
            generateSuperSeq(x.substring(1), y.substring(1), superSeq + x.charAt(0), tempSuper);
        } else {
            generateSuperSeq(x.substring(1), y, superSeq + x.charAt(0), tempSuper);
            generateSuperSeq(x, y.substring(1), superSeq + y.charAt(0), tempSuper);
        }
    }

    public String naiveApproach(String x, String y){
        iterations = 0;
        List<String> superSeq = new ArrayList<>();
        generateSuperSeq(x, y, "", superSeq);
        int scsMinLen = Integer.MAX_VALUE;
        String shortSCS = "";
        for(int i=0; i<superSeq.size(); i++){
            iterations++;
            if(checkSeq(x, superSeq.get(i)) && checkSeq(y, superSeq.get(i))){
                if(scsMinLen > superSeq.get(i).length()){
                    scsMinLen = superSeq.get(i).length();
                    shortSCS = superSeq.get(i);
                }
            }
        }
        return shortSCS;
    }
    public static void main(String[] args){
        Scs scs = new Scs();
        System.out.println("Shortest Common Supersequence (SCS)");
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
                answer = scs.naiveApproach(str1, str2);
                System.out.println("Naive Approach Answer: "+ answer);
                System.out.println("scs Length: "+ answer.length());
                System.out.println("Iterations: "+ scs.iterations);
                break;
            case 2:
                // answer = scs.bottomUpApproach(str1, str2);
                // System.out.println("Botton-Up Approach Answer: "+ answer);
                // System.out.println("scs Length: "+ answer.length());
                // System.out.println("Iterations: "+ scs.iterations);
                // break;
            default:
                System.out.println("Wrong Choice.");
        }

    }
}
