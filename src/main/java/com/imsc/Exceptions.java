package com.imsc;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Exceptions
{
	public String handler()
	{
		System.out.println("Exception Handled....!!!!");
		return "exception";
	}

}
