/**
 * 
 */
package com.ray.restfulboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ray.restfulboot.been.Contact;
import com.ray.restfulboot.service.ContactService;


/**
 * @author $ Rakesh K Ray
 * @Created May 10, 2017 12:01:34 PM
 */

@RestController
@RequestMapping(ContactController.BASE_URI)
public class ContactController {

	@Autowired
	ContactService service;

	public static final String BASE_URI = "restfulboot/v1/contacts";

	/** This method is returning list of contact by GET method **/
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public List<Contact> getContact() {
		List<Contact> contactList = new ArrayList<Contact>();
		Contact contact = new Contact();
		contact.setId(1);
		contact.setName("Rakesh K Ray");
		contactList.add(contact);
		contact = new Contact();
		contact.setId(2);
		contact.setName("Maren Somers");
		contactList.add(contact);
		return contactList;
	}

	/**
	 * This method is going a accept value as path variable and search and
	 * return contact @RequestMapping(value="/contact/{contactNo}": this is used
	 * to set the uri pattern. and value with {} represent the PathVariable
	 * produces=MediaType.APPLICATION_JSON_VALUE is used to set which type of
	 * response is going to generate. method=RequestMethod.GET : is used to set
	 * which method the service is going to accept. it can be
	 * GET,PUT,POST,DELETE, etc
	 **/
	@RequestMapping(value = "/contact/{contactNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Contact getContactByNo(@PathVariable final int contactNo) {
		Contact contact = service.getContact(contactNo);
		return contact;
	}

	/**
	 * Using PUt method this method accept data using requestbody and
	 * pathvariable and insert data
	 * 
	 * @RequestBody Contact contact is going to accept the value from client and
	 *              bind the data in the corresponding object. for testing the
	 *              Application I am using postman. there I have added
	 *              content-type= Application/JSON or XML depending on that I
	 *              have to add value either in JSOn format or XML format at
	 *              postmaster body part.
	 **/
	@RequestMapping(value = "/contactInsert/{contactNo}", method = RequestMethod.PUT)
	public boolean insertContact(@PathVariable final int contactNo, @RequestBody Contact contact) {
		System.out.println("id   " + contact.getId() + " Name " + contact.getName() + " Contact No " + contactNo);
		// check the data present
		// add the data
		return true;
	}

	/**
	 * This method only accept data in form of JSON if match found delete data.
	 * consumes=MediaType.APPLICATION_JSON_VALUE : is to restrict the data to a
	 * specific format so client has to pass data in that format only
	 **/
	@RequestMapping(value = "/contactDelete/{contactNo}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteContact(@PathVariable final int contactNo, @RequestBody Contact contact) {
		System.out.println("id   " + contact.getId() + " Name " + contact.getName() + " Contact No " + contactNo);
		// here logic for check data present
		// delete if it found
		return true;
	}

	/**
	 * This method used to update contact. it return status code depending upon
	 * action. ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND); by using
	 * this i can return status code as well as message.
	 **/
	@RequestMapping(value = "/contactUpdate/{name}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> updateContact(@PathVariable final String name, @RequestBody Contact contact) {
		System.out.println("id   " + contact.getId() + " Name " + contact.getName() + " Contact No " + name);
		// here logic for check data present
		List<String> names = new ArrayList<String>();
		names.add("maren");
		names.add("rakesh");
		if (names.contains(name))
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		// delete if it found
		return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);

	}

	/**
	 * This method is demo on response header.
	 */
	@RequestMapping(value = "/serchContact/{name}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> searchContact(@PathVariable final String name) {
		HttpHeaders header = new HttpHeaders();
		if(name.equals("Gelhi")){
			Contact contact = new Contact();
			contact.setId(1);
			contact.setName("Shivangee Ray");
			header.add("Found", "Found Record");
			return new ResponseEntity<Contact>(contact, header, HttpStatus.OK);
		}
		header.add("Found", "Not Found Record");
		return new ResponseEntity<Contact>(header, HttpStatus.NOT_FOUND);
	}
}
