package com.night.lambda.Optional;

import java.util.Optional;

/**
 * @author Night
 * Date:  2020/4/1
 */
public class OptionalTest {
	public static void main(String[] args) {
		Optional<Integer> optional = Optional.of(1);
		//ofNullable可以设置null和其他值
		Optional<Integer> optional1 = Optional.ofNullable(null);
		
		//生成直接包含mull的Optional
		Optional<Integer> optional2 = Optional.empty();
		System.out.println(optional2.isPresent());
		
		//获取Optional中的值使用get方法
		System.out.println(optional.get());
		//判断值是否存在使用isPresent函数
		System.out.println(optional1.isPresent());
		
		//orElse方法 如果保存的对象不是null，则返回原来的值，否则返回现在的参数
		System.out.println(optional.orElse(1000) == 1);
		System.out.println(optional1.orElse(1000) == 1000);
		
		//当值不存在抛出异常使用orElseThrow方法
		System.out.println(optional1.orElseThrow(RuntimeException::new));
	}
}
