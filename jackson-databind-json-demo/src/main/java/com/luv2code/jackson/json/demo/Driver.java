package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to Java POJO: data/sample-lite.json
			// data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name  and other fields
			System.out.println("The name of student is " + theStudent.getFirstName() + " " + theStudent.getLastName());
			System.out.println("The address is " + theStudent.getAddress().toString());
			
			for (String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
