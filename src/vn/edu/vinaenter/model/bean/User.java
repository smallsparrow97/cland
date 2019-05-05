package vn.edu.vinaenter.model.bean;

public class User {
	private int id;
	private int enable;
	private int role_id;
	private String username;
	private String fullname;
	private String password;

	public User() {
		super();
	}

	public User(int id, int enable, int role_id, String username, String fullname, String password) {
		super();
		this.id = id;
		this.enable = enable;
		this.role_id = role_id;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
