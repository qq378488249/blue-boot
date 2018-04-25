package com.blue.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsApplicationTests {

	@Test
	public void contextLoads() {
	}
	public static void main(String[] args) {
		int number = 7;
		//原始数二进制
//		printInfo(number);
		number = number << 1;
		System.out.println(number);
		//左移一位
//		printInfo(number);
		number = -5;
		number = number >> 1;
		System.out.println(number);
		//右移一位
//		printInfo(number);
	}

	/**
	 * 输出一个int的二进制数
	 * @param num
	 */
	private static void printInfo(int num){
		System.out.println(Integer.toBinaryString(num));
	}
}
