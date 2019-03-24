package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExampleBean {

	@Autowired
	private AnotherBean beanOne;
	
	@Autowired
	private YetAnotherBean beanTwo;

	public ExampleBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ExampleBean(AnotherBean beanOne, YetAnotherBean beanTwo) {
		super();
		this.beanOne = beanOne;
		this.beanTwo = beanTwo;
	}

	public AnotherBean getBeanOne() {
		return beanOne;
	}

	public void setBeanOne(AnotherBean beanOne) {
		this.beanOne = beanOne;
	}

	public YetAnotherBean getBeanTwo() {
		return beanTwo;
	}

	public void setBeanTwo(YetAnotherBean beanTwo) {
		this.beanTwo = beanTwo;
	}
	
	
}
