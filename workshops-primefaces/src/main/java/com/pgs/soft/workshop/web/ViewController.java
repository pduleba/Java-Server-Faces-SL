package com.pgs.soft.workshop.web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DualListModel;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pgs.soft.workshop.backend.model.User;
import com.pgs.soft.workshop.backend.service.Service;
import com.pgs.soft.workshop.backend.service.ServiceImpl;

@ManagedBean(name = "viewController", eager = true)
@SessionScoped
public class ViewController implements Serializable {

	public static final String DATE_FORMAT = "MM-dd-yyyy";

	private static final long serialVersionUID = 1549481937223946546L;

	private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

	private User user;

	private Service service;

	private DualListModel<String> hobbies;

	@PostConstruct
	public void init() {
		this.user = new User();
		this.service = new ServiceImpl();
		List<String> available = service.getHobbies();
		List<String> selected = user.getAboutMe().getHobbies();
		this.hobbies = new DualListModel<>(available, selected);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getDateFormat() {
		return DATE_FORMAT;
	}
	
	public void handleMasterDegreeChange() {
		String msg;
		if (user.getSkills().getMasterDegree()) {
			msg = "Yes, You are Master!";
		} else {
			msg = "No, You aren't Master!";
		}
		FacesMessage fm = new FacesMessage("Successful", msg);
		FacesContext.getCurrentInstance().addMessage(null, fm);
		LOG.info("Master degree flag changed");
	}

	public DualListModel<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(DualListModel<String> hobbies) {
		this.hobbies = hobbies;
	}
	
	public void upload(FileUploadEvent event) throws IOException {
		UploadedFile uploadedFile = event.getFile();
		String fileName = uploadedFile.getFileName();
		byte[] contents = uploadedFile.getContents();

		user.setAvatar(new DefaultStreamedContent(new ByteArrayInputStream(contents), uploadedFile.getContentType(),
				fileName));

		FacesMessage msg = new FacesMessage("Successful", fileName + " uploaded successfully.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		LOG.info("File {} uploaded", fileName);
	}

	public void send() {
		FacesMessage fm = new FacesMessage("Successful",
				MessageFormat.format("Details of user {0} has been send", user.getFirstName()));
		FacesContext.getCurrentInstance().addMessage(null, fm);
		LOG.info("Data send successfully");
	}
}
