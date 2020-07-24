import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n > 0) {
            n--;
            System.out.println(fixStr(sc.nextLine()));
        }
        sc.close();
    }

    public static String fixStr(String str)
    {
        int len = str.length();
        StringBuilder res = new StringBuilder(str);
        for (int i = 2; i < len; i++) {
            if (res[i] == res[i-1] && res[i-1] == res[i-2]) {
                res.deleteCharAt(i);
                i--;
            }
            if (isAABB(res, i-3, i)){
                res.deleteCharAt(i);
                i--;
            }
        }
        return res.toString;
    }

    public  static boolean isAABB(StringBuilder res, int start, int end) {
        if (start < 0) return false;
        return (res[start] == res[start+1] && res[end-1] == res[end]);
    }
}