package net.topikachu.sparrow.wizard;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ServiceIncidentWizard implements Serializable {
	@Inject Conversation conversation;
	public void start(){
		if (conversation.isTransient()){
		conversation.begin();
		}
	}
	
	public String next(){
		return "Detail.xhmtl?faces-redirect=true";
	}
	
	public String finish(){
		conversation.end();
		return "Confirm.xhtml?faces-redirect=true";
	}
}
