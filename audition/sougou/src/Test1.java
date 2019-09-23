import java.util.*;

public class Test1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> old = new HashMap<>();
        int N = sc.nextInt();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();

        while(sc.next()!=null){
            String key = sc.next();
            int value = sc.nextInt();
            insert(key, value, keys, values, N, old);
        }
        Iterator iter = old.keySet().iterator();
        while (iter.hasNext()) {
            String oldKey = (String) iter.next();
            int oldValue = old.get(oldKey);
            System.out.println(oldKey + " " + oldValue);
        }

    }

    public static void insert(String key, int value, ArrayList<String> keys, ArrayList<Integer> values,int N,HashMap old) {
        if (!keys.contains(key)){
            if ( keys.size() <= N) {

                keys.add(key);
                values.add(value);
            }
            else{
                for (int i = keys.size(); i>=0;i--){
                    old.put(key,value);
                    keys.set(i + 1, keys.get(i));
                    values.set(i + 1, values.get(i));
                    keys.set(i, key);
                    values.set(i, value);
                }
            }
        }else{
            for (int j = 0; j < values.size(); j++) {
                if (keys.get(j) == key) {
                    if (values.get(j)<value) {
                        values.set(j, value);
                    }
                }
            }
        }
    }
}
