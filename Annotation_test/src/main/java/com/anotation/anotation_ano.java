package com.anotation;

import java.lang.reflect.Method;

public class anotation_ano {
	
	@Myannotition(count = 5)
	public static void print() {
		System.out.println("프린트입니다");
	}

	public static void main(String[] args) throws Exception {
		
//		anotation_ano ano = new anotation_ano();
//		ano.getClass();
		
		Method m =anotation_ano.class.getMethod("print");
		
		if(m.isAnnotationPresent(Myannotition.class)){
			Myannotition myannotition = m.getAnnotation(Myannotition.class);
			for (int i = 0; i < myannotition.count(); i++) {
				print();				
			}
			
		}else {
			print();
		}		
		print();
	}

}
