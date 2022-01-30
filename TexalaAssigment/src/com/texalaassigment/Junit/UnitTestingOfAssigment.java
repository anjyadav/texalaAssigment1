package com.texalaassigment.Junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.texalaassigment.main.TexalaAssig1;

public class UnitTestingOfAssigment {

	@Test
	public void test()  {
		TexalaAssig1 assig1 = new TexalaAssig1();
		try {
			assertTrue(assig1.startTask("https://gist.github.com/alexpchin/102854243cd066f8b88e"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
