package net.topikachu;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class HelloBean {
	private String name;
	
	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
