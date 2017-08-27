package offer;

import java.util.LinkedList;

public class ProducerConsumer {
	private LinkedList<Object> storeHouse = new LinkedList<>();
	private int max = 10;
	
	public void start() {
		new Producer().start();
		new Consumer().start();
	}
	
	private class Producer extends Thread {
		public void run() {
			while(true) {
				synchronized(storeHouse) {
					try {
						while(storeHouse.size() == max) {
							System.out.println("storeHouse is full, please wait");
							storeHouse.wait();
						}
						Object newOb = new Object();
						if(storeHouse.add(newOb)) {
							System.out.println("Producer put a Object to a store House");
							Thread.sleep((long) (Math.random() * 3000));
							storeHouse.notify();
						}
					} catch (InterruptedException ie) {
						System.out.println("Producer is interrupted");
					}
					
				}
			}
		}
	}
	
	private class Consumer extends Thread {
		public void run() {
			while(true) {
				synchronized(storeHouse) {
					try {
						while(storeHouse.size() == 0) {
							System.out.println("storeHouse is empty, please wait");
							storeHouse.wait();
						}
						storeHouse.removeLast();
                        System.out.println("Comsumer get  a Object from storeHouse");
                        Thread.sleep((long) (Math.random() * 3000));
                        storeHouse.notify();
					} catch (InterruptedException ie) {
						System.out.println("Consumer is interrupted");
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		pc.start();
	}
}
