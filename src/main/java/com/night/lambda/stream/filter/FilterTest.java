package com.night.lambda.stream.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Night
 * Date:  2020/3/26
 */
public class FilterTest {
	public static void main(String[] args) {
		List<Student> list = StudentRepo.getAll();
		List<Student> manList = list.stream().filter(Student.isman).collect(Collectors.toList());
		List<Student> ageList = list.stream().filter(Student.agethen30).collect(Collectors.toList());
		
		List<Student> manandxiaohongList = list.stream().filter(Student.isman.or(e -> e.getName().equals("xiaohong"))).collect(Collectors.toList());
		List<Student> manandageList = list.stream().filter(Student.isman.and(e -> e.getAge() > 20)).collect(Collectors.toList());
		System.out.println(manandageList);
	}
}
