package itcast.test;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("aaa");
        strings.add("bb");
        strings.add("c");
        for (int i = 0; i < strings.size(); i++) {
            if(strings.get(i).equals("bb")){
                strings.remove(strings.get(i));
                i--;
            }
        }
        for (String string : strings) {
            System.out.println(string);
        }
        List<String> list = new ArrayList<>();

        list.add("e1");
        list.add("e2");

//        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
//            String str = iterator.next();
//            if ("e1".equals(str)) {
//                iterator.remove();
//            }
//
//            if ("e2".equals(str)) {
//                System.out.println("element 2 fetched");
//            }
//        }
        System.out.println("=================================");
        list.forEach(s -> {
            if(s.equals("e1")){
                System.out.println(s);
            }
        });


    }
}
