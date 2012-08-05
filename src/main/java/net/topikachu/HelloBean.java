package net.topikachu;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.activiti.cdi.BusinessProcess;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.topikachu.sparrow.datamodel.Asset;
import net.topikachu.sparrow.ejb.JpaManager;
import net.topikachu.sparrow.jsf.UserWizard;

@Named
@RequestScoped
public class HelloBean {
	private String name;
	private static Logger logger = LoggerFactory.getLogger(HelloBean.class
			.getName());

	@Inject BusinessProcess businessProcess;
	@Inject JpaManager jpaManager;
	 @Inject
	  private RepositoryService repositoryService;
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
	
	
	public void startProcess(){
		List<ProcessDefinition> defins=repositoryService.createProcessDefinitionQuery().list();
		logger.info(defins.size()+"");

		businessProcess.startProcessByKey("process2");
	}
		
}
