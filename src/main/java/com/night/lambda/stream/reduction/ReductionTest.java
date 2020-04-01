package com.night.lambda.stream.reduction;

import com.night.lambda.stream.filter.Student;
import com.night.lambda.stream.filter.StudentRepo;

import java.util.List;
import java.util.stream.Collectors;

/** 计算所有学生的年龄和
 * @author Night
 * Date:  2020/4/1
 */
public class ReductionTest {
	public static void main(String[] args) {
		
		List<Student> list = StudentRepo.getAll();
		
		System.out.println(list.stream().map(Student::getAge).reduce(0, Integer::sum));
		
		//注意一点 当流是数值流的时候可以使用sum max等方法，而转化成数值流的方法是mapToInt mapToDouble等
		System.out.println(list.stream().mapToInt(Student::getAge).sum());
		
		System.out.println(list.stream().mapToInt(Student::getAge).max());
		
	}
}
