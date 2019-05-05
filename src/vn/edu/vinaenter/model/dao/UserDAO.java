package vn.edu.vinaenter.model.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.bean.User;

@Repository
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// sql
	private static final String FIND_ALL = "SELECT * FROM users";
	private static final String INSERT_SQL = "INSERT INTO users(username, fullname, password, role_id) VALUES(?, ?, ?, ?)";
	private static final String FIND_ONE = "SELECT * FROM users WHERE id = ?";
	private static final String FIND_ONE_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
	private static final String UPDATE_SQL = "UPDATE users SET fullname = ?, password = ?, role_id = ? WHERE id = ?";
	private static final String UPDATE_SQL_2 = "UPDATE users SET fullname = ?, role_id = ? WHERE id = ?";
	private static final String DELETE_ONE = "DELETE FROM users WHERE id = ?";
	private static final String COUNT = "SELECT COUNT(*) FROM users";
	
	public List<User> getItems() {
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<User>(User.class));
	}

	public int addItem(User objUser) {
		return jdbcTemplate.update(INSERT_SQL, new Object[] {objUser.getUsername(), objUser.getFullname(), 
				objUser.getPassword(), objUser.getRole_id()});
	}

	public User getItem(int id) {
		return jdbcTemplate.queryForObject(FIND_ONE, new Object[] {id}, new BeanPropertyRowMapper<User>(User.class));
	}
	
	public User getItem(String username) {
		return jdbcTemplate.queryForObject(FIND_ONE_BY_USERNAME, new Object[] {username}, new BeanPropertyRowMapper<User>(User.class));
	}
	

	public int editItem(User objUser) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] {objUser.getFullname(), objUser.getPassword(), objUser.getRole_id(), objUser.getId()});
	}
	
	public int editItem2(User objUser) {
		return jdbcTemplate.update(UPDATE_SQL_2, new Object[] {objUser.getFullname(), objUser.getRole_id(), objUser.getId()});
	}

	public int delItem(int id) {
		return jdbcTemplate.update(DELETE_ONE, new Object[] {id});
	}

	public int countNumberUser() {
		return jdbcTemplate.queryForObject(COUNT, Integer.class);
	}
}
