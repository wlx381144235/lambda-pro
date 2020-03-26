package com.night.lambda.stream.map;

import java.util.Arrays;
import java.util.List;

/**
 * @author Night
 * Date:  2020/3/26
 */
public class FlatmapTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello","world");
		list.stream().map(e -> e.split("")).forEach(System.out::println);
		
		list.stream().flatMap(e -> Arrays.stream(e.split(""))).forEach(System.out::println);
	}
}
