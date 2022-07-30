public class test {
    public static void main (String[] args) {
        first(3,2,1);
    }

    public static void third(int f, int g){
        System.out.println("A");
    
    }

    public static void second(int d, int e, int f){
        System.out.println("C");
        third(d,e);
    }

    public static void first(int a, int b, int c){
        System.out.println("E");
        second(a,b,c);
    }

}
