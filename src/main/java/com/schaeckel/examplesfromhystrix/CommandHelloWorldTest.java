package com.schaeckel.examplesfromhystrix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class CommandHelloWorldTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
			String cmd = new CommandHelloWorld("Steffen").execute();
			System.out.println(cmd);
			
			Future<String> cmdFut = new CommandHelloWorld("Moritz").queue();
			System.out.println(cmdFut.get());
			
			String fail = new CommandHelloFailure("Silke").execute();
			System.out.println(fail);
	}
}
