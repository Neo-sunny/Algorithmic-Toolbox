package com.dependency.injection.consumer;

import com.dependency.injection.service.MessageService;

public class MyDIApplication implements Consumer {
	
	private MessageService service;
	public MyDIApplication(MessageService svc){
		this.service=svc;
	}
	@Override
	public void processMessage(String message, String rec) {
		// TODO Auto-generated method stub
		this.service.sendMessage(message, rec);
	}

}
