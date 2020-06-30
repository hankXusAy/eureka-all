package itcast.test;

import org.openjdk.jol.info.ClassLayout;

/**
 * java内存布局工具
 */
public class LockTest {
    public static void main(String[] args) {
        Object o = new Object();
        UserTest userTest = new UserTest();
//        userTest.setAge(1);
//        userTest.setName("xss");
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(ClassLayout.parseInstance(userTest).toPrintable());
//        synchronized (userTest){
//            System.out.println(ClassLayout.parseInstance(userTest).toPrintable());
//        }
    }
}
