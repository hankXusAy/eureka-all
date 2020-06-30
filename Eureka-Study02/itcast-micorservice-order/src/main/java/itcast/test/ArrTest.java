package itcast.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 许绍帅
 * @description 如何解决并发情况下集合不安全的问题
 * @date 2020-05-11
 */
public class ArrTest {
    public static void main(String[] args) {
        /**
         * 1.集合安全引起的报错 ConcurrentModificationException
         */
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        /**
         * 2.导致原因
         *   由于ArrayList没有加锁,当并发修改的时候,会导致多个线程争抢写的操作,出现数据不一致异常,并发修改异常
         */

        /**
         * 3.解决方案
         */
        //1.使用Vector,底层加锁
        List<String> strings = new Vector<>();
        //2.使用工具类构建一个线程安全的集合
        Collections.synchronizedList(new ArrayList<>());
        //3.写时复制
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        /**
         * 4. 优化建议
         */
        /*
        写时复制,读写分离
        CopyOnWrite容器即写时复制的容器.往一个元素添加元素时,不会直接往Object[]中添加,而是先将Object[]进行copy,
        复制出一个新的Object[] newElements,然后向新的容器Object[] newElements中添加元素,添加元素之后,再将原容器
        的引用指向新容器setArray(newElements);
        这样做的好处是可以对CopyOnWrite容器进行并发的读,而不需要加锁,因为当前容器不会添加任何元素.
        所以CopyOnWrite容器也是一种读写分离的思想,读和写不同的容器.

        public boolean add(E e) {
        final ReentrantLock lock = this.lock;
            lock.lock();
            try {
                Object[] elements = getArray();
                int len = elements.length;
                Object[] newElements = Arrays.copyOf(elements, len + 1);
                newElements[len] = e;
                setArray(newElements);
                return true;
            } finally {
                lock.unlock();
            }
        }
         */
    }
}
