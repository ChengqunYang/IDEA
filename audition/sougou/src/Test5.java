import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test5  {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();
            /*使用toUpperCase()方法实现大写转换*/
            String newA = str.toUpperCase();
            System.out.println("大写转换：" + newA);
    }
}
