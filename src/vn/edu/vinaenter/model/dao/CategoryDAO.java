package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.bean.Category;

@Repository
public class CategoryDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// sql
	private static final String FIND_ALL = "SELECT * FROM categories ORDER BY cid DESC";
	private static final String INSERT_SQL = "INSERT INTO categories(cname) VALUES(?)";
	private static final String FIND_ONE = "SELECT * FROM categories WHERE cid = ?";
	private static final String UPDATE_SQL = "UPDATE categories SET cname = ? WHERE cid = ?";
	private static final String DELETE_ONE = "DELETE FROM categories WHERE cid = ?";
	private static final String COUNT = "SELECT COUNT(*) FROM categories";
	
	public List<Category> getItems() {
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public int addItem(Category objCat) {
		return jdbcTemplate.update(INSERT_SQL, new Object[] {objCat.getCname()});
	}

	public Category getItem(int cid) {
		return jdbcTemplate.queryForObject(FIND_ONE, new Object[] {cid}, new BeanPropertyRowMapper<Category>(Category.class));
	}

	public int editItem(Category objCat) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] {objCat.getCname(), objCat.getCid()});
	}

	public int delItem(int cid) {
		return jdbcTemplate.update(DELETE_ONE, new Object[] {cid});
	}

	public int countNumberCat() {
		return jdbcTemplate.queryForObject(COUNT, Integer.class);
	}
}
