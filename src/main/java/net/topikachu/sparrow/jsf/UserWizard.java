package net.topikachu.sparrow.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import net.topikachu.sparrow.datamodel.User;

import org.primefaces.component.wizard.Wizard;
import org.primefaces.event.FlowEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ViewScoped
@ManagedBean
public class UserWizard {
	private List<String> steps = new ArrayList<String>();

	private User user = new User();

	private boolean skip;

	private static Logger logger = LoggerFactory.getLogger(UserWizard.class
			.getName());

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void save(ActionEvent actionEvent) {
		// Persist user

		FacesMessage msg = new FacesMessage("Successful", "Welcome :"
				+ user.getFirstname());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		Wizard wizard = (Wizard) event.getComponent();
		boolean isBackRequest = wizard.isBackRequest(FacesContext
				.getCurrentInstance());
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		logger.info("Next step:" + event.getNewStep());

		String step;
		if (isBackRequest) {

			int last = steps.size() - 1;
			if (last >= 0) {
				step = steps.get(last);
				steps.remove(last);
			} else {
				step = event.getNewStep();
			}
		} else {
			if (skip) {
				skip = false; // reset in case user goes back
				step = "confirm";
			} else {
				step = event.getNewStep();
			}
			steps.add(event.getOldStep());
		}

		return step;

	}
}