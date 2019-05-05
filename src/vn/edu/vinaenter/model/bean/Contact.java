package vn.edu.vinaenter.model.bean;

public class Contact {
	private int cid;
	private String fullname;
	private String email;
	private String subject;
	private String content;

	public Contact() {
		super();
	}

	public Contact(int cid, String fullname, String email, String subject, String content) {
		super();
		this.cid = cid;
		this.fullname = fullname;
		this.email = email;
		this.subject = subject;
		this.content = content;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
