import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String,Long> map = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        String[] strings = str.split(" ");
        for (String s : strings) {
            String[] ss = s.split("-");
            if (!map.containsKey(ss[1])) {
                map.put(ss[1], Long.parseLong(ss[0]));
                map2.put(ss[1], 1);
            }else if (map.containsKey(ss[1])&&map.containsValue(ss[0])){
                map2.put(ss[1],map2.get(ss[1])+1);
            }
        }
        list.addAll(map2.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int i = 0;
        for (Map.Entry<String,Integer> a: list) {
            if (i < 3) {
                System.out.println(a.getKey());
                System.out.println(a.getValue());
                i++;
            }else{
                break;
            }
        }
    }
    
}
