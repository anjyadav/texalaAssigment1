package com.texalaassigment.Junit;
import java.io.IOException;

import org.junit.Test;

import com.texalaassigment.main.TexalaAssig1;

import junit.framework.*;

public class UnitTesting extends TestCase {
	TexalaAssig1 texalassg = new TexalaAssig1();
	
	@Test
	void contextLoad()
	{
		System.out.println("In contextLoad Unit Test");
		
	}
	
	@Test
	void testTexalaAssig1() throws IOException
	{

		texalassg.startTask();
	}
	
	

}
