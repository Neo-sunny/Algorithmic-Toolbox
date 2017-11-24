package com.java.threads;

// Prints Even Odd alternately Using Thread
public class EvenOddThreads {

	public static void main(String[] args) throws InterruptedException {
		final printEvenOdd peo = new printEvenOdd();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					peo.printOdd();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					peo.printEven();
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

	public static class printEvenOdd {

		int shared = 1;

		public void printEven() throws InterruptedException {
			while (true) {

				synchronized (this) {
					if (shared % 2 != 0)
						wait();
					System.out.println(shared++);
					notify();
					Thread.sleep(1000);
				}
			}
		}

		public void printOdd() throws InterruptedException {
			while (true) {

				synchronized (this) {
					if (shared % 2 == 0)
						wait();
					System.out.println(shared++);
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}
