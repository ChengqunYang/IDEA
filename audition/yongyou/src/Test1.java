import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        List<Integer> list = new ArrayList<>();
        str.deleteCharAt(0);
        str.deleteCharAt(str.length() - 1);
        String s = str+"";
        String[] strings = s.split("， ");
        for (String ss:strings) {
           list.add(Integer.parseInt(ss));
        }
        for (int i = 0; i < list.size()-1; i++) {
            int count = 1;
            int j = i;
            while (list.get(j)>=list.get(j+1)){
                count++;
                j++;
                if (j>list.size()-2){
                    count = 0;
                    break;
                }
            }
            list.set(i,count);
            list.set(list.size()-1,0);
        }
        System.out.print("[");
        for (int i = 0; i <list.size() ; i++) {
            if (i != list.size()-1){
                System.out.print(list.get(i)+"， ");
            }else {
                System.out.print(list.get(i)+"]");
            }

        }
    }
}
