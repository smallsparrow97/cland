package vn.edu.vinaenter.model.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Category {
	private int cid;
	@NotEmpty(message="Tên danh mục không được rỗng")
	@Size(min=1, max=50, message="Nhập ít nhất 1 ký tự và nhiều nhất 50 ký tự")
	private String cname;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Category() {
		super();
	}

	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
}
