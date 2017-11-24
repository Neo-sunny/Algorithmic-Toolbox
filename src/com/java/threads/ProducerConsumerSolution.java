package com.java.threads;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerSolution {

	public static void main(String[] args) throws InterruptedException {
		final ProducerConsumer pc = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}

	 static class ProducerConsumer {

		// A list shared by both producer and consumer
		List<Integer> sharedData = new LinkedList<>();
		int capacity = 3;

		public void produce() throws InterruptedException {
			int value = 0;
			
			while (true) { // This loop is to fill the data in the list
				
				synchronized (this) {  // Synchronized block To ensure only Producer or consumer Thread Runs 
					while (sharedData.size() == capacity)
						wait();

					System.out.println("Producer produced: " + ++value);
					sharedData.add(value);

					notify();
					Thread.sleep(1000);
				}
			}
		}

		public void consume() throws InterruptedException {
			while (true) {

				synchronized (this) {
					while (sharedData.size() == 0)
						wait();
					
						int value = sharedData.remove(0);
						System.out.println("Consumer consumed " + value);
						
						notify();
						Thread.sleep(1000);
					
				}
			}
		}
	}
}
