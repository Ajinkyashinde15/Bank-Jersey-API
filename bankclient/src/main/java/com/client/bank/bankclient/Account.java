package com.client.bank.bankclient;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//Account model class
@XmlRootElement
public class Account {
    
	//Declare variables
    private int sortcode;
    private String accno;
    private int cbal;
    private List<Transaction> ltrans;
	
    //Constructor account
    public Account(int sortcode, String accno, int cbal, List<Transaction> ltrans) {
		super();
		this.sortcode = sortcode;
		this.accno = accno;
		this.cbal = cbal;
		this.ltrans = ltrans;
	}

    //Default Constructor account
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	//Getter and setter methods 
	public int getSortcode() {
		return sortcode;
	}
	public void setSortcode(int sortcode) {
		this.sortcode = sortcode;
	}
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public int getCbal() {
		return cbal;
	}
	public void setCbal(int cbal) {
		this.cbal = cbal;
	}
	public List<Transaction> getLtrans() {
		return ltrans;
	}
	public void setLtrans(List<Transaction> ltrans) {
		this.ltrans = ltrans;
	}
       
}