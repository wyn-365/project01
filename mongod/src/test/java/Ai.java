import java.util.Scanner;

//AI核心代码，估计价值几亿
public class Ai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true){
            str = sc.next();
            str = str.replace("吗","!");
            str = str.replace("？","!");
            str = str.replace("是","不是");
            str = str.replace("你","我");

            System.out.println(str);
        }
    }

}
