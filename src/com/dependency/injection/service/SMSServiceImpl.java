package com.dependency.injection.service;

public class SMSServiceImpl implements MessageService {

	@Override
	public void sendMessage(String msg, String recv) {
		// TODO Auto-generated method stub
		System.out.println("SMS sent to "+recv+" with message "+msg);
	}

}
