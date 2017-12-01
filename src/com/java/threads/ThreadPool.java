package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *Demonstration of working of Thread Pool

1. Create a task(Runnable Object) to execute
2. Create Executor Pool using Executors
3. Pass tasks to Executor Pool
4. Shutdown the Executor Pool

 * */
class Threadtask implements Runnable{
	private String name;
	public Threadtask(String name){
		this.name=name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
public class ThreadPool{

	static final int MAX_T = 3; // Maximum number of threads in a ThreadPool
	public static void main(String[] args) {
		
// Creating 5 Tasks		
		Runnable r1= new Threadtask("Task-1");
		Runnable r2= new Threadtask("Task-2");
		Runnable r3= new Threadtask("Task-3");
		Runnable r4= new Threadtask("Task-4");
		Runnable r5= new Threadtask("Task-5");
		
//  Creating a ThreadPool of size 3(MAX_T)		
		 ExecutorService pool = Executors.newFixedThreadPool(MAX_T); 
		 
// Passing the Task object to the pool
		 pool.execute(r1);
	     pool.execute(r2);
	     pool.execute(r3);
	     pool.execute(r4);
	     pool.execute(r5); 

// Shutting down the pool
	     pool.shutdown();
	     	
	}

	

}

