package itcast.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;

public class TestFs {
    public int add (int a,int b){
        return a + b ;
    }
    public String echo(String message){
        return "hello"+message;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        /**
         * 通过反射创建对象
         */
        Class<TestFs> testFsClass = TestFs.class;
        TestFs testFs2 = testFsClass.newInstance();
        System.out.println(testFs2 instanceof TestFs);

        /**
         * 通过反射调用方法
         * 首先获取与该方法对应的method对象
         */
        Method method = testFsClass.getMethod("add", new Class[]{int.class, int.class});
        /**
         * 第一个参数是方法名，第二个参数是这个方法所需要的参数的Class对象的数组
         */
        Object invoke = method.invoke(testFs2, new Object[]{1, 2});
        System.out.println(invoke);
        Hashtable hashtable = new Hashtable();
        HashMap hashMap = new HashMap();
    }
}
