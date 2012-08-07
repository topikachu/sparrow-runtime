package net.topikachu.sparrow.wizard;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ocpsoft.pretty.faces.annotation.URLMapping;

@Named
@ConversationScoped
@URLMapping(id = "ServiceIncidentWizard", pattern = "/ServiceIncident/", viewId = "#{serviceIncidentWizard.start}")
public class ServiceIncidentWizard implements Serializable {
	@Inject Conversation conversation;
	public String start(){
		if (conversation.isTransient()){
		conversation.begin();
		}
		return "Requester.xhtml?faces-redirect=true";
	}
	
	public String next(){
		return "Detail.xhmtl?faces-redirect=true";
	}
	
	public String finish(){
		conversation.end();
		return "Confirm.xhtml?faces-redirect=true";
	}
}
