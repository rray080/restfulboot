/**
 * 
 */
package com.ray.restfulboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ray.restfulboot.been.Contact;

/**
 * @author $ Rakesh K Ray
 * @Created May 10, 2017 12:01:34 PM
 */

@RestController
@RequestMapping(ContactController.BASE_URI)
public class ContactController {
	
	public static final String BASE_URI = "restfulboot/v1/contacts";
	
	@RequestMapping(value="{contactNo}")
	public Contact getContact(@PathVariable final int contactNo){
		Contact contact = new Contact();
		contact.setId(contactNo);
		contact.setName("Maren");
		return contact;
	}
}
