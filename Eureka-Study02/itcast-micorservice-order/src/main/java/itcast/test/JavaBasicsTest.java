package itcast.test;

public class JavaBasicsTest {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;
        if((j>++i)&&(i++==j)){
            j+=i;
        }
        System.out.println(j);
    }
}
