package offer;

import java.util.concurrent.*;

public class ProducerConsumer3 {
	private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(10);
	
	public void start() {
		new Producer().start();
		new Consumer().start();
	}
	
	private class Producer extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					Object o = new Object();
					queue.put(o);
					 System.out.println("Producer: " + o);
				} catch (InterruptedException e) {
					 System.out.println("producer is interrupted!");
				}
			}
		}
	}
	
	private class Consumer extends Thread {
		@Override 
		public void run() {
			while(true) {
				try {
					Object o = queue.take();
					System.out.println("Croducer: " + o);
				} catch (InterruptedException e) {
					 System.out.println("consumer is interrupted!");
				}
			} 
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer3 pc3 = new ProducerConsumer3();
		pc3.start();
	}
}
