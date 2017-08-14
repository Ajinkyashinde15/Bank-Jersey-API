package com.client.bank.bankclient;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Customer {
    
    private int cid;
    private String name;
    private String address;
    private String email;
    private String securitycred;
    private List<Account> laccounts;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSecuritycred() {
		return securitycred;
	}
	public void setSecuritycred(String securitycred) {
		this.securitycred = securitycred;
	}
	public List<Account> getLaccounts() {
		return laccounts;
	}
	public void setLaccounts(List<Account> laccounts) {
		this.laccounts = laccounts;
	}
	public Customer(int cid, String name, String address, String email, String securitycred, List<Account> laccounts) {
		super();
		this.cid = cid;
		this.name = name;
		this.address = address;
		this.email = email;
		this.securitycred = securitycred;
		this.laccounts = laccounts;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

    

}