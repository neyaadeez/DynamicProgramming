import java.util.Scanner;
public class Lcs {
    public void func(String x, String y){
        x = "hey";
        y = "bye";
    }
    public static void main(String[] args){
        Lcs lcs = new Lcs();
        Scanner sc = new Scanner(System.in);
        String x = new String();
        String y = new String();
        x = sc.nextLine();
        y = sc.nextLine();
        System.out.println(x);
        System.out.println(y);
        System.out.println("After--");
        lcs.func(x, y);
        System.out.println(x);
        System.out.println(y);
    }
}