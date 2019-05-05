package vn.edu.vinaenter.model.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.bean.Contact;
import vn.edu.vinaenter.model.bean.User;

@Repository
public class ContactDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// sql
	private static final String FIND_ALL = "SELECT * FROM vnecontact";
	private static final String DELETE_ONE = "DELETE FROM vnecontact WHERE cid = ?";
	private static final String INSERT_SQL = "INSERT INTO vnecontact(fullname, email, subject, content) VALUES(?, ?, ?, ?)";
	
	public List<Contact> getItems() {
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<Contact>(Contact.class));
	}

	public int delItem(int cid) {
		return jdbcTemplate.update(DELETE_ONE, new Object[] {cid});
	}

	public int addItem(Contact objContact) {
		return jdbcTemplate.update(INSERT_SQL, new Object[] {objContact.getFullname(), objContact.getEmail(),
				 objContact.getSubject(), objContact.getContent()});
	}
}
