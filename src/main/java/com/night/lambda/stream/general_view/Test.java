package com.night.lambda.stream.general_view;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Night
 * Date:  2020/3/26
 * 这个只是个例子 展示stream中比较常用的几个函数 map filter sorted collect等等。
 */
public class Test {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("aiby","lion","lunchy","zara","lily","laby");
		Predicate<String> startWithL = e -> e.startsWith("l");
		List<String> stringList = list.stream().filter(startWithL).map(String::toUpperCase).sorted().collect(Collectors.toList());
		System.out.println(stringList);
	}
}
