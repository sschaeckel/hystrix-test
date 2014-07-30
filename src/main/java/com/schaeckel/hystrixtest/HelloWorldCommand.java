package com.schaeckel.hystrixtest;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class HelloWorldCommand extends HystrixCommand<String>{

	protected HelloWorldCommand() {
		super(HystrixCommandGroupKey.Factory.asKey(HelloWorldCommand.class.getSimpleName()));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String run() {
		return "Hello World!";
	}

}
