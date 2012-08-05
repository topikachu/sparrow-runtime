package net.topikachu.sparrow.wizard;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class ServiceIncidentWizard implements Serializable {
	public String next(){
		return "Detail.xhmtl";
	}
}
