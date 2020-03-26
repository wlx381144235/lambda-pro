package com.night.lambda.one;

/**
 * @author Night
 * Date:  2020/3/26
 */
public class Test {
	public static void main(String[] args) {
		PrintMachine printMachine = new PrintMachine();
//		printMachine.printSomething("hello", new Printer() {
//			@Override
//			public void print(String str) {
//				System.out.println(str);
//			}
//		});
		printMachine.printSomething("hello",str-> System.out.println(str));
		printMachine.printSomething("hello", System.out::println);
	}
}
