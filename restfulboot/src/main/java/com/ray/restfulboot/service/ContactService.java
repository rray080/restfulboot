package com.ray.restfulboot.service;

import org.springframework.stereotype.Service;

import com.ray.restfulboot.been.Contact;
import com.ray.restfulboot.dao.ContactDAO;

@Service
public class ContactService {
	
	
	
	public Contact getContact(int id){
		ContactDAO dao = new ContactDAO();
		Contact contact = dao.getContactById(id);
		return contact;
	}
}
