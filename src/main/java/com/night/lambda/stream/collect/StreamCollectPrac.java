package com.night.lambda.stream.collect;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Night
 * Date:  2020/3/26
 */
public class StreamCollectPrac {
	/**
	 * @return 返回一个剔除了元音字母的新流
	 * @throws IOException
	 */
	public static Stream<String> noVowels() throws IOException {
		// 读取文件中的字符串。
		String contents = new String(Files.readAllBytes(Paths.get("D:\\alice.txt")),
				StandardCharsets.UTF_8);
		// contents.split("\\PL+")这个方法会将读取的内容按照分隔符转成非字母，看过源码，无误
		List<String> wordList = Arrays.asList(contents.split("\\PL+"));
		Stream<String> words = wordList.stream();
		// 调用replaceall方法来消除这些内容，用空字符串替代
		return words.map(e -> e.replaceAll("[aeiouAEIOU]", ""));
	}
	
	/**
	 * 这个方法用来展示流里面的元素
	 *
	 * @param title
	 * @param set
	 * @param <T>
	 */
	public static <T> void show(String title, Set<T> set) {
		System.out.println(title + ":" + set.getClass().getName());
		System.out.println("{" + set.stream().limit(10).map(Objects::toString)
				.collect(Collectors.joining(", ")) + "}");
	}
	
	public static void main(String[] args) throws IOException {
		// 调用的是iterator方法 这个函数可以生成无限流
		Iterator<Integer> iterator = Stream.iterate(0, n -> n + 1).limit(10).iterator();
		
		// 调用toArray方法（无参）来返回一个Object数组
		Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
		
		// Object虽然是Integer的父类，但是Object[]并不是Integer[]的父类
		try {
			Integer number = (Integer) numbers[0];
			System.out.println("number:" + number);
			System.out.println("exception:");
			Integer[] numbers2 = (Integer[]) numbers;
		} catch (ClassCastException e) {
			System.out.println(e);
		}
		// // 调用toArray方法（参数是构造器）来返回一个指定类型的数组
		Integer[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
		
		// // 下面是两种方法来返回HashSet，下面还简单点，上面的那种方法感觉像是为每个元素创建一个HashSet，然后放进去，再讲所有的HashSet加起来
		HashSet<String> noVowelHashSet = noVowels().collect(HashSet::new, HashSet::add, HashSet::addAll);
		//与上面一样 HashSet<String> noVowelHashSet = noVowels().collect(Collectors.toCollection(HashSet::new));
		
		Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
		
		// 这种方法就是比较好的方法了
		TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
		
		//制造分隔符
		String result = noVowels().limit(10).collect(Collectors.joining());
		

		result = noVowels().limit(10).collect(Collectors.joining(","));
		
		//统计相关
		IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
		double averageWordLength = summary.getAverage();
		double maxWordLength = summary.getMax();
		
	}
}