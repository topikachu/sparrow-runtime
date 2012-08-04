package net.topikachu;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.topikachu.sparrow.datamodel.Asset;

@Named
@RequestScoped
public class HelloBean {
	private String name;
	
	
	@Inject 
	public String getName(){
		Asset asset=new Asset();
		asset.setAssetTag("hello");
		
		
		return asset.getId();
		
		
	}

	public void setName(String name) {
		this.name = name;
	}
}
