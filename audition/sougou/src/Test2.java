import javax.sound.midi.SysexMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sc1 = sc.nextLine();
        String sc2 = sc.nextLine();
        String[] nAndK = sc1.split(" ");
        ArrayList<Integer> list1 = new ArrayList<>();
        for (String s:nAndK) {
            list1.add(Integer.parseInt(s));
        }
        String[] ns = sc2.split(" ");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (String s:ns) {
            list2.add(Integer.parseInt(s));
        }
        //System.out.println(list2);
        for (int k = list1.get(1); k > 0; k--) {
            int min = Integer.MAX_VALUE; // 用于记录列表中的最小值
            for (Integer ai : list2) {
                if (ai> 0 && ai < min) {
                    min = ai; // 遍历找出最小值
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println(0);
                break;
            } else {
                System.out.println(min);
                for (int i = 0; i <list2.size() ; i++) {
                    if (list2.get(i) != 0){
                        list2.set(i, (list2.get(i) - min));
                    }
                }
            }
        }
    }
}
