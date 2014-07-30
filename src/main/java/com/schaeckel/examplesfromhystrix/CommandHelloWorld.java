package com.schaeckel.examplesfromhystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class CommandHelloWorld extends HystrixCommand<String>{

	private String name;

	protected CommandHelloWorld(String name) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
				.andCommandKey(HystrixCommandKey.Factory.asKey("HelloWorld"))
				.andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("HelloWorldPool"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withCircuitBreakerEnabled(false)
						.withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)));
		this.name = name;
	}

	@Override
	protected String run() throws Exception {
		return "Hello " + name + "!";
	}

// wird diese Methode implementiert, wird das Request Caching aktiviert
//	@Override
//	protected String getCacheKey() {
//		// TODO Auto-generated method stub
//		return super.getCacheKey();
//	}

}
