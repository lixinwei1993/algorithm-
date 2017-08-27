package offer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {
	private LinkedList<Object> myList = new LinkedList<Object>();
	private int max = 10;
	private final Lock lock = new ReentrantLock();
	private final Condition full = lock.newCondition();
	private final Condition empty = lock.newCondition();
	
	public void start() {
		new Consumer().start();
		new Producer().start();
	}
	
	private class Producer extends Thread {
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					while(myList.size() == max) {
						System.out.println("list is full");
						full.await();
					}
					myList.add(new Object());
					System.out.println("Produce an object");
					Thread.sleep(1000);
					empty.signal();
				} catch (InterruptedException ie) {
					System.out.println("Producer is interrupted");
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	private class Consumer extends Thread {
		@Override
		public void run() {
			while(true) {
				lock.lock();
				try {
					while(myList.isEmpty()) {
						System.out.println("list is empty");
						empty.await();
					}
					myList.removeLast();
					System.out.println("consume an object");
					Thread.sleep(1000);
					full.signal();
				} catch (InterruptedException ie) {
					System.out.println("Consumer is interrupted");
				} finally {
					lock.unlock();
				}
			}
		}
	}
	
	public static void main(String[] atgs) {
		ProducerConsumer2 pc2 = new ProducerConsumer2();
		pc2.start();
	}
	
}















