package com.night.lambda.stream.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

/**
 * @author Night
 * Date:  2020/3/26
 */
@Data
@AllArgsConstructor
public class Student {
	private String name;
	
	private Integer age;
	
	private String sex;
	
	public static Predicate<Student> isman = e -> e.getSex().equals("m");
	
	public static Predicate<Student> agethen30 = e -> e.getAge() > 30;
}
