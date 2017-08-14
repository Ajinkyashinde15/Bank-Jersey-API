/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.webservices.bankwebservices.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {
    
    private int tid;
    private int cid;
    private int sortcode;    
    private String type;
    private String date;
    private int balance;
	
    public Transaction(int tid, int cid, int sortcode, String type, String date, int balance) {
		super();
		this.tid = tid;
		this.cid = cid;
		this.sortcode = sortcode;
		this.type = type;
		this.date = date;
		this.balance = balance;
	}
	
    public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSortcode() {
		return sortcode;
	}

	public void setSortcode(int sortcode) {
		this.sortcode = sortcode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

    

}