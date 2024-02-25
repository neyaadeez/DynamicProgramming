import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Scs {
    int iterations = 0;
    public String backTrace(String x, String y, int[][] scs){
        String scsString = "";
        int i = x.length();
        int j = y.length();
        while (i>0 && j>0) {
            if(x.charAt(i-1) == y.charAt(j-1)){
                scsString = x.charAt(i-1) + scsString;
                i--;
                j--;
            }
            else{
                if(scs[i-1][j] < scs[i][j-1]){
                    scsString = x.charAt(i-1) + scsString;
                    i--;
                }
                else{
                    scsString = y.charAt(j-1) + scsString;
                    j--;
                }
            }
        }

        while (i > 0) {
            scsString = x.charAt(i-1) + scsString;
            i--;
        }
        while (j > 0) {
            scsString = y.charAt(j-1) + scsString;
            j--;
        }

        return scsString;
    }

    public String bottomUpApproach(String x, String y){
        iterations = 0;
        int[][] scs = new int[x.length()+1][y.length()+1];
        for(int i=0; i<=x.length(); i++){
            iterations++;
            scs[i][0] = i;
        }
        for(int j=0; j<=y.length(); j++){
            iterations++;
            scs[0][j] = j;
        }
        for(int i=1; i<=x.length(); i++){
            for(int j=1; j<=y.length(); j++){
                iterations++;
                if(x.charAt(i-1) == y.charAt(j-1)){
                    scs[i][j] = scs[i-1][j-1] +1;
                }
                else{
                    scs[i][j] = Math.min(scs[i-1][j], scs[i][j-1]) +1;
                }
            }
        }

                //SCS String TraceBack
        return backTrace(x, y, scs);
    }

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
        iterations++;
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
                answer = scs.bottomUpApproach(str1, str2);
                System.out.println("Botton-Up Approach Answer: "+ answer);
                System.out.println("scs Length: "+ answer.length());
                System.out.println("Iterations: "+ scs.iterations);
                break;
            default:
                System.out.println("Wrong Choice.");
        }

    }
}
