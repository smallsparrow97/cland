package vn.edu.vinaenter.model.bean;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Land {
	private int lid;
	private int cid;
	private int count_views;
	
	@NumberFormat(style = Style.CURRENCY)
	private double area;
	
	@NotEmpty(message="Tên tin tức không được rỗng")
	private String lname;
	
	@NotEmpty(message="Mô tả không được rỗng")
	private String description;
	
	private String picture;
	
	@NotEmpty(message="Địa chỉ không được rỗng")
	private String address;
	
	private String cname;
	
	@NotEmpty(message="Chi tiết không được rỗng")
	@Size(min=20, message="Nhập ít nhất 20 ký tự")
	private String detail;

	private Timestamp date_create;

	public Land() {
		super();
	}

	public Land(int lid, int cid, int count_views, double area, String lname, String description, String picture,
			String address, String cname, String detail, Timestamp date_create) {
		super();
		this.lid = lid;
		this.cid = cid;
		this.count_views = count_views;
		this.area = area;
		this.lname = lname;
		this.description = description;
		this.picture = picture;
		this.address = address;
		this.cname = cname;
		this.detail = detail;
		this.date_create = date_create;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCount_views() {
		return count_views;
	}

	public void setCount_views(int count_views) {
		this.count_views = count_views;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getDate_create() {
		return date_create;
	}

	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

}
