package com.example;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

public class BootApplicationTests {
	
	@Rule
	public OutputCapture outputCapture=new OutputCapture();
	
	private String profiles;
	
	@Before
	public void before() {
		this.profiles=System.getProperty("spring.profiles.active");
	}
	
	@After
	public void after() {
		if(this.profiles !=null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}
	
	@Test
	public void testDefaultProfile() {
		Boot003Application.main(new String[0]);
		String output=this.outputCapture.toString();
		assertThat(output).contains("Hello Phil");
	}
	
	@Test
	public void testGoodbyeProfile() {
		System.setProperty("spring.profiles.active", "goodbye");
		Boot003Application.main(new String[0]);
		String output=this.outputCapture.toString();
		assertThat(output).contains("Goodbye Everyone");
	}
	
	@Test
	public void testGenericProfile() {
		System.setProperty("spring.profiles.active", "generic");
		Boot003Application.main(new String[0]);
		String output=this.outputCapture.toString();
		assertThat(output).contains("Bonjour Phil");
	}
	
	@Test
	public void testGoodbyeProfileFromCommandline() {
		Boot003Application.main(new String[] {"--spring.profiles.active=goodbye"});
		String output=this.outputCapture.toString();
		assertThat(output).contains("Goodbye Everyone");
	}
	
}













