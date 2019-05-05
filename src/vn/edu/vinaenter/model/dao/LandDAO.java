package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.bean.Category;
import vn.edu.vinaenter.model.bean.Land;

@Repository
public class LandDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// sql
	private static final String FIND_ALL = "SELECT l.lid, l.lname, l.description, l.detail, l.date_create,"
			+ " l.cid, l.picture, l.area, l.address, l.count_views, c.cname"
			+ " FROM lands AS l INNER JOIN categories AS c ON c.cid = l.cid"
			+ " ORDER BY l.lid DESC";
	
	private static final String FIND_ALL_BY_PAGINATION = "SELECT l.lid, l.lname, l.description, l.detail, l.date_create,"
			+ " l.cid, l.picture, l.area, l.address, l.count_views, c.cname"
			+ " FROM lands AS l INNER JOIN categories AS c ON c.cid = l.cid"
			+ " ORDER BY l.lid DESC LIMIT ?, ?";
	
	private static final String INSERT_SQL = "INSERT INTO lands(lname, description, detail, cid, picture, area, address)"
			+ " VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	private static final String TOTAL_LAND = "SELECT COUNT(*) AS totalLand"
			+ " FROM lands AS l INNER JOIN categories AS c"
			+ " ON c.cid = l.cid";
	
	private static final String TOTAL_LAND_OF_CAT = "SELECT COUNT(*) AS totalLand"
			+ " FROM lands AS l INNER JOIN categories AS c"
			+ " ON c.cid = l.cid WHERE c.cid = ?";
	
	private static final String FIND_ONE = "SELECT * FROM lands WHERE lid = ?";
	private static final String FIND_ALL_BY_CAT_ID = "SELECT * FROM lands WHERE cid = ?";
	private static final String FIND_ALL_BY_CAT_ID_PAGINATION = "SELECT * FROM lands WHERE cid = ? ORDER BY cid DESC LIMIT ?, ?";
	private static final String FIND_RELATE_LAND = "SELECT * FROM lands WHERE lid <> ? AND cid = ? LIMIT 3";
	private static final String FIND_HOT_LAND = "SELECT * FROM lands ORDER BY count_views DESC LIMIT ?";
	private static final String UPDATE_SQL = "UPDATE lands SET lname = ?, description = ?, detail = ?,"
			+ " cid = ?, picture = ?, area = ?, address = ? WHERE lid = ?";
	private static final String DELETE_ONE = "DELETE FROM lands WHERE lid = ?";
	private static final String COUNT_ALL_BY_CAT_ID = "SELECT COUNT(*) FROM lands WHERE cid = ?";
	private static final String COUNT = "SELECT COUNT(*) FROM lands";
	private static final String UPDATE_COUNT_VIEWS = "UPDATE lands SET count_views = ? WHERE lid = ?";
	
	public List<Land> getItems() {
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<Land>(Land.class));
	}
	
	public List<Land> getItems(int offset, int row_count) {
		return jdbcTemplate.query(FIND_ALL_BY_PAGINATION, new Object[] {offset, row_count}, new BeanPropertyRowMapper<Land>(Land.class));
	}

	public int addItem(Land objLand) {
		return jdbcTemplate.update(INSERT_SQL, new Object[] {objLand.getLname(), objLand.getDescription(),
				 objLand.getDetail(), objLand.getCid(), objLand.getPicture(), objLand.getArea(), objLand.getAddress()});
	}

	public Land getItem(int lid) {
		return jdbcTemplate.queryForObject(FIND_ONE, new Object[] {lid}, new BeanPropertyRowMapper<Land>(Land.class));
	}

	public int editItem(Land objLand) {
		return jdbcTemplate.update(UPDATE_SQL, new Object[] {objLand.getLname(), objLand.getDescription(), 
				objLand.getDetail(), objLand.getCid(), objLand.getPicture(), objLand.getArea(), objLand.getAddress(), 
				objLand.getLid()});
	}

	public int delItem(int lid) {
		return jdbcTemplate.update(DELETE_ONE, new Object[] {lid});
	}
	
	public int totalLand() {
		return jdbcTemplate.queryForObject(TOTAL_LAND, Integer.class);
	}
	
	public int totalLand(int cid) {
		return jdbcTemplate.queryForObject(TOTAL_LAND_OF_CAT, new Object[] {cid}, Integer.class);
	}
	
	public List<Land> getItemByCatId(int cid) {
		return jdbcTemplate.query(FIND_ALL_BY_CAT_ID, new Object[] {cid}, new BeanPropertyRowMapper<Land>(Land.class));
	}

	public List<Land> getItemByCatId(int cid, int offset, int rowCount) {
		return jdbcTemplate.query(FIND_ALL_BY_CAT_ID_PAGINATION, new Object[] {cid, offset, rowCount}, new BeanPropertyRowMapper<Land>(Land.class));
	}

	public List<Land> getRelateLand(int lid, int cid) {
		return jdbcTemplate.query(FIND_RELATE_LAND, new Object[] {lid, cid}, new BeanPropertyRowMapper<Land>(Land.class));
	}

	public List<Land> getHotLand(int limit) {
		return jdbcTemplate.query(FIND_HOT_LAND, new Object[] {limit}, new BeanPropertyRowMapper<Land>(Land.class));
	}
	
	public int countItemByCatId(int cid) {
		return jdbcTemplate.queryForObject(COUNT_ALL_BY_CAT_ID, new Object[] {cid}, Integer.class);
	}

	public int countNumberLand() {
		return jdbcTemplate.queryForObject(COUNT, Integer.class);
	}

	public void increaseView(Land objLand) {
		jdbcTemplate.update(UPDATE_COUNT_VIEWS, new Object[] {objLand.getCount_views() + 1, objLand.getLid()});
	}
}
