package com.spring.test.person;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class PersonMapper implements RowMapper<PersonDetail>{
	
	public PersonDetail mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		PersonDetail person = new PersonDetail();
		person.setId(arg0.getInt("id"));
		person.setFname(arg0.getString("fname"));
		person.setLname(arg0.getString("lname"));
		person.setAddressl1(arg0.getString("addressl1"));
		person.setAddressl2(arg0.getString("addressl2"));
		return person;
}
}