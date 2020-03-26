package com.night.lambda.stream.filter;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Night
 * Date:  2020/3/26
 */
public class StudentRepo {
	public static Student xiaohong = new Student("xiaohong",20,"w");
	public static Student xiaoming = new Student("xiaoming",18,"m");
	public static Student xiaoliang = new Student("xiaoliang",24,"m");
	public static Student xiaojun = new Student("xiaojun",42,"m");
	public static Student xiaofen = new Student("xiaofen",28,"w");
	
	public static List<Student> getAll(){
		List<Student> list = new ArrayList<>();
		list.add(xiaohong);
		list.add(xiaoming);
		list.add(xiaoliang);
		list.add(xiaojun);
		list.add(xiaofen);
		return list;
	}
}
