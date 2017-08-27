package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentExecutor {
	public static void main(String[] args) {
		//listOff();
		daemon2();
	}
	
	public static void listOff() {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			exec.execute(new ListOff());
		}
		exec.shutdown();
	}
	
	public static void taskWithResult() {
		ExecutorService exec = Executors.newCachedThreadPool();
		//ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<String>> results = new ArrayList<>();
		
		for(int i = 0; i < 100; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		
		for(Future<String> fs : results) {
			try{
				//get() blocks until completion
				System.out.println(fs.get());
			} catch(InterruptedException e) {
				System.out.println(e);
				return;
			} catch(ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
		}
	}
	
	public static void daemon2() {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i = 0; i < 5; i++) {
			exec.execute(new SimpleDaemons());
		}
		exec.shutdown();
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void daemon() {
		for(int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true); //Must Call before start()
			daemon.start();
		}
		System.out.print("All daemons started");
		try {
			TimeUnit.MILLISECONDS.sleep(175);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class DaemonThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}	
}

class SimpleDaemons implements Runnable {
	@Override
	public void run() {
		try {
			while(true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.print(Thread.currentThread() + " " + this);
			}
		} catch(InterruptedException e) {
			System.out.print("sleep() interrupted");
		}
	}
}

class TaskWithResult implements Callable<String> {
	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of TaskWithResult " + id;
	}
	
}

class ListOff implements Runnable {
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++; //使用规定初始化，不需要在构造器中再次声明
	public ListOff() {}
	public ListOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Listpff!") + ").";
	}

	@Override
	public void run() {
		try {
			while(countDown-- > 0)	{
				System.out.println(status());
				//Thread.yield();
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch(InterruptedException e) {
			System.err.println("Interrupted");
		}
	}
	
}
