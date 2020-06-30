package itcast.test;

import java.io.*;
import java.util.concurrent.atomic.AtomicReference;


public class UserTest implements Externalizable,Serializable {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public UserTest() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        UserTest zs = new UserTest("zs",22);
        UserTest ls = new UserTest("ls",43);
        //原子引用,会出现ABA问题
        AtomicReference<UserTest> userTest = new AtomicReference<>();
        userTest.set(zs);
        System.out.println(userTest.compareAndSet(zs, ls)+"\t"+userTest.get().toString());
        System.out.println(userTest.compareAndSet(zs, ls)+"\t"+userTest.get().toString());
        /**
         * 解决ABA
         */

    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
