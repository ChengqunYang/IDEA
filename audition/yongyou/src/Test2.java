import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Test2 {
    public static Character findFirstMethod (String str){
        //定义一个map集合用于存放对该字符串的遍历结果
        Map<Character, Integer> strMap = new LinkedHashMap<>();
        for (Character c : str.toCharArray()) {
            Integer count = strMap.get(c); //定义计数器,用于当当前遍历的字符个数,初始值为null
            if(count == null){ //
                strMap.put(c, 1);
            }else{
                strMap.put(c, ++count);
            }
        }
        for (Map.Entry<Character, Integer> entry : strMap.entrySet()) {
            if(entry.getValue() == 1){ //返回计数map中,计数值为1的那个key
                return entry.getKey();
            }
        }
        throw new RuntimeException("程序计算出错");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();
        System.out.println(findFirstMethod(str));
    }
}
