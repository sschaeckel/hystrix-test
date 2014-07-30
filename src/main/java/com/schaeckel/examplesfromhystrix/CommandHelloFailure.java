package com.schaeckel.examplesfromhystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class CommandHelloFailure extends HystrixCommand<String>{

	private String name;

	protected CommandHelloFailure(String name) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorldFailure"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HelloWorldPool"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)));
		this.name = name;
	}

	@Override
	protected String run() throws Exception {
		throw new RuntimeException("das geht immer schief!");
	}

	@Override
	protected String getFallback() {
		return "Hello Failure " + name + "!";
	}
}
