package com.wordpress.mkscodingblog.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wordpress.mkscodingblog.func.Func;
import com.wordpress.mkscodingblog.impl.ListWrapperImpl;

public class ListWrapperTest<T> {
	@Test
	public void MainTest() {		
		List<Integer> lints = new ArrayList<Integer>();
		
		for ( int i = 0; i <= 100; i++ )
			lints.add(i);

		ListWrapperImpl<Integer> l = new ListWrapperImpl<Integer>(lints);
		
		lints = new ArrayList<Integer>();
		for ( int i = 50; i <= 150; i++ )
			lints.add(i);
		ListWrapperImpl<Integer> l2 = new ListWrapperImpl<Integer>(lints);
		// old way of doing things
		l.select(new Func<Integer, Boolean>() {
			public Boolean func(Integer t) {				
				return t % 2 == 0;
			}			
		});
		
		// new way of doing things
		// this use generic type inference
		// also using lambdas to simplify code
		l.select((x) -> { return !(x <= 100 && x >= 50); }).forEach((Integer x) -> {System.out.println(x);});
		//l.forEach((x) -> System.out.println(x));		
		System.out.println(l.first((x) -> x == 50));
		System.out.println(l.last((x) -> x == 100));
		l.join(l2);		
		
		l.intersection(l2).replace(l);
		
	}

}
