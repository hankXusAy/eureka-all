package itcast.test;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author 许绍帅
 * @description ABA问题以及解决方案
 * @date 2020-05-11
 */
public class ABADemo {
    static AtomicReference<Integer> reference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);
    public static void main(String[] args) {
        System.out.println("===========ABA问题====================");
        new Thread(()->{
            //多次修改
            reference.compareAndSet(100,101);
            reference.compareAndSet(101,100);
        },"t1").start();

        new Thread(()->{
            try {
                //确保预期的值是被改过,先让线程睡眠1s,模拟场景的代码
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //只能解决: 只要期望值和所期望的一样,即使中间做过多次修改,也不关心,所有的信息都只保存于对象的数值本身。
            System.out.println(reference.compareAndSet(100, 2019)+"\t"+reference.get());
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===============ABA问题解决================");
        //我们是否能修改对象的值，不仅取决于当前值，还和对象的过程变化有关
        new Thread(()->{
            int stamp = stampedReference.getStamp();
            try {
                //睡一秒,保证t4线程拿到和t3相同的版本号
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //多次修改,每次修改,改动一次版本号
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号"+stamp);
            stampedReference.compareAndSet(100,101,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t第二次版本号"+stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第三次版本号"+stampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = stampedReference.getStamp();
            //不但预期值要一样,版本号还需要一致,否则就阻止操作
            System.out.println(Thread.currentThread().getName()+"\t第一个版本号"+stamp);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result = stampedReference.compareAndSet(100, 2020, stamp, stamp + 1);
            System.out.println(result + "\t当前最新版本号"+stampedReference.getStamp());
            System.out.println(result + "\t当前实际最新值"+stampedReference.getReference());
        },"t4").start();
    }
}
