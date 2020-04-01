package com.night.lambda.stream.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/** 我们来一步步演变
 * @author Night
 * Date:  2020/4/1
 */
public class MergeTest {
	public static void main(String[] args) {
		//准备要用到的list
		List<String> list = new ArrayList<>();
		list.add("I am a boy");
		list.add("I love a girl");
		list.add("But the girl loves another girl");
		//首先转换成流
		list.stream();
		//按照空格分词 这时流里面的每个元素是String数组
		list.stream().map(e -> e.split(" "));
		//将每个String数组变成流
		list.stream().map(e -> e.split(" ")).map(Arrays::stream);
		//将这些小流合并成大流 用flatmap来处理
		list.stream().map(e -> e.split(" ")).flatMap(Arrays::stream);
		//然后去重并收集成list。
		list.stream().map(e -> e.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		
	}
}
