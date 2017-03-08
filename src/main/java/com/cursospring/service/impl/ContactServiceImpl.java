package com.cursospring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cursospring.component.ContactConverter;
import com.cursospring.entity.Contact;
import com.cursospring.model.ContactModel;
import com.cursospring.respository.ContactRepository;
import com.cursospring.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact>contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<>();
		
		for(Contact contact : contacts){
			contactsModel.add(contactConverter.convertContact2ContactModel(contact));
		}
		
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		
		if(null != contact){
			contactRepository.delete(contact);
		}
	}

	@Override
	public ContactModel findContactModelById(int id) {
		Contact contact = findContactById(id);
		return contactConverter.convertContact2ContactModel(contact);
	}

}
