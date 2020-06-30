package itcast.test;

/**
 * DCL与volatile问题
 */
public class DCL {
    private static  DCL dcl ;
    private int s ;
    public void setS(int s) {
        this.s = s;
    }
    public static DCL getDcl(){
        if(dcl == null){
            synchronized (DCL.class){
                if(dcl == null){
                    dcl = new DCL();
                }
            }
        }
        return dcl;
    }
    public int getS() {
        return s;
    }

    public DCL() {
        this .s = 1;
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                DCL dcl = getDcl();
                System.out.println(dcl.hashCode());
                System.out.println("输出-------------------"+dcl.getS());
            });
            thread.start();
        }
    }
}
