package com.night.lambda.stream.map;

import com.night.lambda.stream.filter.Student;
import com.night.lambda.stream.filter.StudentRepo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Night
 * Date:  2020/3/26
 */
public class MapTest {
	public static void main(String[] args) {
		List<Student> list = StudentRepo.getAll();
//		我们将学生的年龄进行加1的处理，使用map函数，当传入和返回一样时，我们可以用peek代替map
		List<Student> students = list.stream().map(e -> {
			e.setAge(e.getAge() + 1);
			return e;
		}).collect(Collectors.toList());
//		List<Student> students = list.stream().peek(e -> e.setAge(e.getAge() + 1)).collect(Collectors.toList());
		System.out.println(students);
	}
}
