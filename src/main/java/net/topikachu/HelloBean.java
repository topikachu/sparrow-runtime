package net.topikachu;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.topikachu.sparrow.datamodel.Asset;
import net.topikachu.sparrow.ejb.JpaManager;

@Named
@RequestScoped
public class HelloBean {
	private String name;
	
	
	@Inject JpaManager jpaManager;
	public String getName() throws NamingException{
		
		String dataSourceJndiName="java:app/jdbc/sparrow";
		Object o=new InitialContext().lookup(dataSourceJndiName);
		Asset asset=new Asset();
		asset.setAssetTag("hello");
		jpaManager.saveEntity(asset);
		
		return asset.getId();
		
		
	}

	public void setName(String name) {
		this.name = name;
	}
}
