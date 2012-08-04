package net.topikachu;

import javax.inject.Named;

@Named
public class HelloBean {
	public String getName(){
		return "World";
	}
}
