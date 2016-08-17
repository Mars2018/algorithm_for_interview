/**
 * Created by mars_wang on 2016/8/17.
 */
/*
public class Singleton {
    private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
*/
    /**
     * 方法同步
     *
     * */
/*
public class Singleton{
    private static Singleton singleton = null;

    private Singleton(){}

    public static synchronized Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

}
*/

/**
 * 双重锁检察
 */
/*
public class Singleton{
    private static Singleton singleton = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton == null)
            synchronized(Singleton.class){
                if(singleton == null)
                    singleton = new Singleton();
            }

        return singleton;
    }
}
*/

/**
 * 内部类
 */
/*
public class Singleton{
    private static Singleton singleton = null;

    private Singleton(){}

    public static Singleton getInstance(){
        return Holder.SINGLETON;
    }

    private static class Holder{
        private static final Singleton SINGLETON = new Singleton();
    }
}*/

public class Singleton{
    private static final Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton gewtInstance(){
        return singleton;
    }
}
