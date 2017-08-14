package com.api.webservices.bankwebservices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.api.webservices.bankwebservices.model.Account;
import com.api.webservices.bankwebservices.model.Customer;
import com.api.webservices.bankwebservices.model.Transaction;

public class CustomerService {
    public static List<Customer> clist = new ArrayList<Customer>();
    public static boolean init = true;
    
    public CustomerService () {
        if (init) {

        	List<Transaction> tlist1 = new ArrayList<Transaction>();
            Transaction t1 = new Transaction(1,1,1,"debit","12/3/2017",90);
            tlist1.add(t1);

        	List<Transaction> tlist2 = new ArrayList<Transaction>();
            Transaction t2 = new Transaction(2,2,2,"credit","12/4/2017",170);
            tlist2.add(t2);

        	List<Account> alist1 = new ArrayList<Account>();        	
            Account a1 = new Account(1,"1",100,tlist1);
            alist1.add(a1);

            List<Account> alist2 = new ArrayList<Account>();
            Account a2 = new Account(2,"2",100,tlist2);
            alist2.add(a2);
            
            Customer c1 = new Customer(1,"Noel", "Dublin 4", "noel@gmail.com","12345",alist1);
            Customer c2 = new Customer(2,"Jose", "Dublin 5", "jose@gmail.com","32434",alist2);
       
            clist.add(c1);
            clist.add(c2);
            init = false;
        }
    }
        
    public List<Customer> getAllCustomers() {
        return clist;
    }

	public Account addAccount(int cid, Account ac) {
		// TODO Auto-generated method stub
		Random rn = new Random();
    	int n = 100 - 10 + 1;
    	int i = rn.nextInt() % n;
    	int randomNum =  10 + i;
    	    	
		if(cid==1)
		{
			Customer c1=clist.get(0);
			c1.getLaccounts().add(ac);			
		}else
		{
			Customer c1=clist.get(1);
			c1.getLaccounts().add(ac);
		}
		
		return ac;
	}

	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return clist.get(id-1);
	}

	public int lodgment(int id,int amount) {

		String aid=String.valueOf(id);
		for(int i=0;i<clist.size();i++)
		{
			Account accont=clist.get(i).getLaccounts().get(2);
			
			if(accont.getAccno().equals(aid))
			{
				accont.setCbal(accont.getCbal()+amount);
			}
			else
			{
				//return -1;
			}
		}
		return 1;
	}

	public int withdraw(int id,int amount) {

		String aid=String.valueOf(id);
		for(int i=0;i<clist.size();i++)
		{
			Account accont=clist.get(i).getLaccounts().get(2);
			
			if(accont.getAccno().equals(aid))
			{
				accont.setCbal(accont.getCbal()-amount);
			}
		}
		return 1;
	}

	public int transfer(int source, int destination, int amount) {
		String sid=String.valueOf(source);
		String did=String.valueOf(destination);
		
		for(int i=0;i<clist.size();i++)
		{
			Account accont=clist.get(i).getLaccounts().get(2);
			
			if(accont.getAccno().equals(sid))
			{
				accont.setCbal(accont.getCbal()-amount);
			}
		}
		
		for(int i=0;i<clist.size();i++)
		{
			Account accont=clist.get(i).getLaccounts().get(2);
			
			if(accont.getAccno().equals(destination))
			{
				accont.setCbal(accont.getCbal()+amount);
			}
		}
				
		return 1;
	}

	public int getcstbal(int id) {
		// TODO Auto-generated method stub
		int bal = -1;
		for(int i=0;i<clist.size();i++)
		{
			List<Account> accont=clist.get(i).getLaccounts();
			
			if(accont.get(1).equals(id))
			{
				 bal=(int)accont.get(2).getCbal();
				break;
			}
		}
		return bal;
	}
        
}