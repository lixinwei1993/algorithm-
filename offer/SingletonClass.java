package offer;
/**
 * 剑指offer面试题2
 * @author welding
 *
 */
public class SingletonClass {
	/**
	 * 懒汉式单线程模式, 不能在多线程环境下工作是一个较为失败的答案
	 */
	private static class Singleton1{
		private static Singleton1 mInstance;
		
		private Singleton1(){
			
		}
		
		public static Singleton1 getInstance() {
			if(mInstance == null) {
				mInstance = new Singleton1();
			}
			
			return mInstance;
		}
	}
	
	/**
	 * 可再多线程环境下工作但效率不高
	 */
	private static class Singleton2 {
		private static Singleton2 mInstance;
		
		private Singleton2() {
			
		}
		
		public synchronized static Singleton2 getInstance() {
			if(mInstance == null) {
				mInstance = new Singleton2();
			}
			
			return mInstance;
		}
	}
	
	/**
	 * 加同步锁前后两次判断实例是否已经存在
	 * 因为一旦实例存在后，mInstance相当于只读的，可以同时获取不必担心线程安全，提高了效率
	 * @author welding
	 *
	 */
	private static class Singleton3 {
		private static Singleton3 mInstance;
		
		private Singleton3() {
			
		}
		
		private static Singleton3 getInstance() {
			if(mInstance == null) {
				synchronized(Singleton3.class) {
					if(mInstance == null) {
						mInstance = new Singleton3();
					}
				}
			}
			
			return mInstance;
		}
	}
	
	/**
	 * 饿汉式,线程安全, 效率高，但是创建对象的时机较早造成资源浪费？
	 */
	private static class Singleton{
		private static final Singleton mInstance = new Singleton();
		
		private Singleton(){
			
		}
		
		public static Singleton getInstance() {
			return mInstance;
		}
	}
	
	/**
	 * 使用私有静态内部类实现按需生成对象，并省去了加锁的麻烦，是较为推荐的一种方法，不好的一点就是增加了编译后class文件数目
	 * @author welding
	 *
	 */
	private static class Singleton4 {
		private static class InstanceHolder {
			public static final Singleton4 mInstance = new Singleton4();
		}
		
		private Singleton4() {
			
		}
		
		public static Singleton4 getInstance() {
			return InstanceHolder.mInstance;
		}
	}
	
	public static void main(String[] args) {
		Singleton.getInstance();
		Singleton1.getInstance();
		Singleton2.getInstance();
		Singleton3.getInstance();
		Singleton4.getInstance();
		
		System.out.println("Completed");
	}
}









