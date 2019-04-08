package com.xiaofu.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="user")
@NamedQuery(name="User.findAll",query="select u from User u")
@Entity
public class User {

	@Id
	@GeneratedValue
	private String Uid;
	@Column(name="Uname")
	private String Uname;
	
	@ManyToMany
	@JoinTable(joinColumns=@JoinColumn,inverseJoinColumns=@JoinColumn)
	private List<Address> addresslist;
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public List<Address> getAddresslist() {
		return addresslist;
	}
	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}
	
}
