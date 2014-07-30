package com.schaeckel.hystrixtest;

import org.apache.log4j.Logger;

import rx.Observable;
import rx.Observer;

import com.netflix.hystrix.HystrixCommand;

public class HystrixTest {
	
	private static final org.apache.log4j.Logger log = Logger.getLogger(HelloWorldCommand.class);
	
	public static void main(String[] args) {
		
		HystrixCommand<String> cmd = new HelloWorldCommand();
		System.out.println(cmd.execute());
		
		Observable<String> hWorld = new HelloWorldCommand().observe();
		
		hWorld.subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                // nothing needed here
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String v) {
                System.out.println("onNext: " + v);
            }

        });
		
	}

}
