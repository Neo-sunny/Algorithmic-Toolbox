package com.dependency.injection.service;

public class EmailServiceImpl implements MessageService {

	@Override
	public void sendMessage(String msg, String recv) {
		// TODO Auto-generated method stub
		System.out.println("Email sent to "+recv+" with message "+msg);
	}

}
