import java.net.BindException;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str =new StringBuilder(sc.nextLine());
        while (str.indexOf(" ") != -1) {
            int index = str.indexOf(" ");
            str.deleteCharAt(index);
            str.insert(index, "2020");
        }
        System.out.println(str);

    }
}
