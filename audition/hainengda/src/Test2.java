public class Test2 {
    public static int a = 4;
        public static void method() {
            System.out.println("测试静态方法");
            a = 5;
        }
    public static void main(String[] args) {
            Test2 tset = null;
            tset.method();

    }
}
