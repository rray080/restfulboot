package com.ray.restfulboot.dao;

import com.ray.restfulboot.been.Contact;

public class ContactDAO {

	public Contact getContactById(int id) {
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName("Maren");
		return contact;
	}

}
