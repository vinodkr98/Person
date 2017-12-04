package com.spring.test.person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class PersonDaoImpl implements PersonDao {
	private JdbcTemplate jdbcTemplate;
	 
    public PersonDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public PersonDetail getPer(int id)  {
		// TODO Auto-generated method stub
		String query = "select * from person where id=" + id;      //simple statement
		return jdbcTemplate.query(query, new ResultSetExtractor<PersonDetail>() {

			@Override
			public PersonDetail extractData(ResultSet arg0) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				if (arg0.next()) {
					PersonDetail person = new PersonDetail();
					person.setId(arg0.getInt("id"));
					person.setFname(arg0.getString("fname"));
					person.setLname(arg0.getString("lname"));
					person.setAddressl1(arg0.getString("addressl1"));
					person.setAddressl2(arg0.getString("addressl2"));
					return person;
				}
				return null;
			}

		});
	}

	@Override
	public void updatePer(PersonDetail person) {
		// TODO Auto-generated method stub
		if (person.getId() > 0) {
			String query = "update person set fname=? where id=?";
			jdbcTemplate.update(query, person.getFname(), person.getId());
		}

	}

	@Override
	public void deletePer(int id) {
		// TODO Auto-generated method stub
		String query = "delete from person where id=?";
		jdbcTemplate.update(query, id);

	}

	@Override
	public List<PersonDetail> listPer() {
		// TODO Auto-generated method stub
		String query = "select * from person";
		List<PersonDetail> listPerson = jdbcTemplate.query(query, new RowMapper<PersonDetail>(){

			@Override
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
			
		});
		
		return listPerson;
	}

	@Override
	public String newPer(PersonDetail person) throws DuplicateKeyException {
		// TODO Auto-generated method stub
		try {
			String query = "insert into person (id, fname, lname, addressl1, addressl2) values(?, ?, ?, ?, ?)";
			jdbcTemplate.update(query, person.getId(), person.getFname());
			return "Success";
		} catch (DuplicateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Id already exists";
		}

	}
}
