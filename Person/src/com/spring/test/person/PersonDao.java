package com.spring.test.person;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

public interface PersonDao {
	public PersonDetail getPer(int id);
	public String newPer(PersonDetail person)throws DuplicateKeyException;
	public void updatePer(PersonDetail person);
	public void deletePer(int id);
	public List<PersonDetail> listPer();
}
