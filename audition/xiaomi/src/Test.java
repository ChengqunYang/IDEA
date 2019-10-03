import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test {
    /**
     * 1. 给定一个只包含小写字母的字符串，我们通过如下规则分割它：
     * 1.一个片段中包含的字符不允许出现在其他片段内。
     * 2.分割的片段数应尽可能的多。
     * 请实现一个函数，输出分割的片段。
     * 输入aabbbacceddefgkifk 输出为 aabbba cc edde fgkifk
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String str = sc.nextLine();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(str);

        Set<Character> set = new HashSet();
        for (int i = 0; i < chars.length; i++) {
            boolean flag = false;
            set.add(chars[i]);
            A:
            for (char a: set) {
                for (int j = i; j < chars.length; j++) {
                    if (a == chars[j]){
                        flag = true;
                        break A;
                    }
                }
            }
            if (flag == false) {
                sb.insert(i,' ');
                set.clear();
            }
        }
        System.out.println(sb.toString());
    }
}
