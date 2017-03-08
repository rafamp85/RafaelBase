package com.cursospring.service;

import java.util.List;

import com.cursospring.entity.Contact;
import com.cursospring.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract ContactModel findContactModelById(int id);
	
	public abstract void removeContact(int id);
}
