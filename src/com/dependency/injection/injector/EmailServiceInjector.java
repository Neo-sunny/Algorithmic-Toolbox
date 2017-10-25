package com.dependency.injection.injector;

import com.dependency.injection.consumer.Consumer;
import com.dependency.injection.consumer.MyDIApplication;
import com.dependency.injection.service.EmailServiceImpl;

public class EmailServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		// TODO Auto-generated method stub
		return new MyDIApplication(new EmailServiceImpl());
	}

}
