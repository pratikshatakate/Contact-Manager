package com.jspiders.springmvc.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.ContactDao;
import com.jspiders.springmvc.dto.ContactDto;

@Component
public class ContactService {

	@Autowired
	private ContactDao contactDAO;

	public boolean addContact(String firstName, String lastName, String email, long mobile) {
		ContactDto contactDTO = new ContactDto();
		contactDTO.setFirstName(firstName);
		contactDTO.setLastName(lastName);
		contactDTO.setEmail(email);
		contactDTO.setMobile(mobile);
		try {
			contactDAO.addContact(contactDTO);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<ContactDto> findAllContacts() {
		return contactDAO.findAllContacts();
	}

	public ContactDto deleteContact(int id) {
		return contactDAO.deleteContact(id);
	}

	public ContactDto findContactById(int id) {
		return contactDAO.findContactById(id);
	}

	public boolean updateContact(int id, String firstName, String lastName, String email, long mobile) {
		try {
			contactDAO.updateContact(id, firstName, lastName, email, mobile);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
