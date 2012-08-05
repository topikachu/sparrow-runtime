package net.topikachu.sparrow.wizard;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import net.topikachu.sparrow.wizard.datamodel.AssetPurchase;

import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
public class AssetPurchaseWizard {
	private AssetPurchase data =new AssetPurchase();
	
	public AssetPurchase getData(){
		return data;
	}
	public String onFlowProcess(FlowEvent event){
		if( data.getPurchaser().equals("")){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Empyt purchaser",null);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return event.getOldStep();
		}
		return event.getNewStep();
	}
	
	public void finish(){
		
	}
}
