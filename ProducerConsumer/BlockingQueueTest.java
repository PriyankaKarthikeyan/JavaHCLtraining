package com.Test.ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	
	private static BlockingQueue<Integer> queue= new ArrayBlockingQueue<>(10);
	public static void main(String[] args) throws InterruptedException {
	//creating Producer thread	
	Thread pThread = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
			producer();
			}catch(InterruptedException e) {
				e.printStackTrace();
		}	
	}});
	//creating Consumer thread	
	Thread cThread=new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			try {
				consumer();
			}catch(InterruptedException e) {
				e.printStackTrace();			
			}
		}
		
	});
	
	cThread.start();
	pThread.start();
	

}
	protected static void consumer() throws InterruptedException {
		// TODO Auto-generated method stub
		while(true) {
			Thread.sleep(1000);
			//consuming data from queue
			int consumed=queue.take();
			System.out.println("Consumed: "+consumed);
		}
	}
	protected static void producer() throws InterruptedException {
		// TODO Auto-generated method stub
		Random random= new Random();
		while(true) {
			Thread.sleep(1000);
			int produced=random.nextInt(10);
			//Producing data to the queue
			queue.put(produced);
			System.out.println("Produced: "+produced);
		}
	}
}
