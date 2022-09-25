package oop;

import java.io.IOException;
import java.math.BigInteger;

public class Test {
	public static final int END = Integer.MAX_VALUE;
	public static final int START = END - 100;
	public static void main(String []args) {
//		int count = 0;
//		for(int i=START;i<=END;i++){
//			count++;
//		}
		//System.out.println(count);
		System.out.println(t());

	}
	public static boolean t(){
		try {
			//risky code
			return true;
		}catch (Exception e){
			return false;
		}finally {
			return false;
			//System.out.println("Test");
		}
	}
}
