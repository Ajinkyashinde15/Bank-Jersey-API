package com.client.bank.bankclient;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;
import org.w3c.dom.NodeList;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import com.sun.xml.internal.txw2.Document;

import jdk.internal.org.xml.sax.InputSource;

public class BankClient
{
	
	// Get  all customer details
	void getAPI()
	{
	    String allcustomer = "http://localhost:8080/bankwebservicesapi/rest/customers/customersall";	       
	    com.sun.jersey.api.client.Client client1 = com.sun.jersey.api.client.Client.create();
        WebResource target = client1.resource(allcustomer);
        ClientResponse response = target.accept("application/xml")
                    .get(ClientResponse.class);

        String output = response.getEntity(String.class);
        //System.out.println("Hello" +output);	
        
        try
        {
        	//Parse xml and extract elements
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = new    ByteArrayInputStream(output.getBytes());
            org.w3c.dom.Document doc = builder.parse(inputStream);
            
            NodeList nList = doc.getElementsByTagName("customer");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {

        		Node nNode = nList.item(temp);

        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElement = (Element) nNode;

        			System.out.println("\naddress : " + eElement.getElementsByTagName("address").item(0).getTextContent());
        			System.out.println("cid : " + eElement.getElementsByTagName("cid").item(0).getTextContent());
        			System.out.println("email : " + eElement.getElementsByTagName("email").item(0).getTextContent());
        			System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
        			System.out.println("securitycred : " + eElement.getElementsByTagName("securitycred").item(0).getTextContent());
        			
        		}
        	}
            
            NodeList accountl = doc.getElementsByTagName("laccounts");
            
            for (int i = 0; i < accountl.getLength(); i++) {

        		Node nNodeacc = accountl.item(i);

        		if (nNodeacc.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElementacc = (Element) nNodeacc;
        			
        			System.out.println("\naccno : " + eElementacc.getElementsByTagName("accno").item(0).getTextContent());
        			System.out.println("cbal : " + eElementacc.getElementsByTagName("cbal").item(0).getTextContent());
        			System.out.println("sortcode : " + eElementacc.getElementsByTagName("sortcode").item(0).getTextContent());

        		}
            }
            
            NodeList ltransl = doc.getElementsByTagName("ltrans");
            
            for (int i = 0; i < ltransl.getLength(); i++) {

        		Node nNodeacc = ltransl.item(i);

        		if (nNodeacc.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElementacc = (Element) nNodeacc;
        			
        			System.out.println("\balance : " + eElementacc.getElementsByTagName("balance").item(0).getTextContent());
        			System.out.println("cid : " + eElementacc.getElementsByTagName("cid").item(0).getTextContent());
        			System.out.println("date : " + eElementacc.getElementsByTagName("date").item(0).getTextContent());
        			System.out.println("sortcode : " + eElementacc.getElementsByTagName("sortcode").item(0).getTextContent());
        			System.out.println("tid : " + eElementacc.getElementsByTagName("tid").item(0).getTextContent());
        			System.out.println("type : " + eElementacc.getElementsByTagName("type").item(0).getTextContent());
        		}
            }
        }
        catch(Exception e)
        {
        	
        }

	}
	
    public static void main(String []args){
                
        Scanner s;
        while(true)
        {
        	
        	//Show menu
        	System.out.println("1. Create account");
        	System.out.println("2. Lodgment");
        	System.out.println("3. Transfer");
        	System.out.println("4. Withdraw");
        	System.out.println("5. Balance");
        	
        	System.out.println("Enter your choice");

            s=new Scanner(System.in);
            int ch=s.nextInt();
            
            switch(ch)
        	{
            	//Create account
        		case 1:
        			
                	System.out.println("Enter customer no to add account 1.Noel 2.Jose ");
                    int cid=s.nextInt();
                    
                    System.out.println("Enter sortcode... ");
                    int scode=s.nextInt();
                    System.out.println("Enter your account no ... ");
                    String accno=s.next();
                    System.out.println("Enter your balance ...");
                    int cbal=s.nextInt();
                            	
                    //URL to get customers all 
        		    String addacc = "http://localhost:8080/bankwebservicesapi/rest/customers/'"+cid+"'";	   
        		    
        		    Client client1 = ClientBuilder.newClient();
        		    WebTarget target1 = client1.target(addacc);
                    
        		    Form form = new Form();
        		    form.add("cid", cid);    

        		    form.add("ac", new Account(scode,accno,cbal,null));
        		    ClientResponse response = ((WebResource) target1)
        		      .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
        		      .post(ClientResponse.class, form);        		    
        			System.out.println("Account succefully created ");
        		    
        		break;	   
        		
        		case 2:
        			System.out.println("Enter your account no ... ");
                    String accno1=s.next();
                    System.out.println("Enter your lodgment amount ...");
                    int amount=s.nextInt();
                    String lodg = "http://localhost:8080/bankwebservicesapi/rest/customers/lodgment/'"+accno1+"'/'"+amount+"'";	   
        		    
            	    com.sun.jersey.api.client.Client client12 = com.sun.jersey.api.client.Client.create();
                    WebResource target = client12.resource(lodg);
                    ClientResponse response12 = target.accept("application/xml")
                                .get(ClientResponse.class);
                    String output = response12.getEntity(String.class);                                      
        		break;

        		case 3:
        			System.out.println("Enter your source account no ... ");
                    String source=s.next();
        			System.out.println("Enter your destination account no ... ");
                    String destin=s.next();
                    System.out.println("Enter your transfer amount ...");
                    int tamount=s.nextInt();
                    String transf = "http://localhost:8080/bankwebservicesapi/rest/customers/transfer/'"+source+"'/'"+destin+"'/'"+tamount+"'";	   
        		    
            	    com.sun.jersey.api.client.Client client13 = com.sun.jersey.api.client.Client.create();
                    WebResource target13 = client13.resource(transf);
                    ClientResponse response13 = target13.accept("application/xml")
                                .get(ClientResponse.class);
                    String output13 = response13.getEntity(String.class);                    
                    
        		break;

        		case 4:
        			System.out.println("Enter your account no ... ");
                    String accno12=s.next();
                    System.out.println("Enter your withdraw amount ...");
                    int amount2=s.nextInt();
                    String withd = "http://localhost:8080/bankwebservicesapi/rest/customers/withdraw/'"+accno12+"'/'"+amount2+"'";	   
        		    
            	    com.sun.jersey.api.client.Client client14 = com.sun.jersey.api.client.Client.create();
                    WebResource target4 = client14.resource(withd);
                    ClientResponse response14 = target4.accept("application/xml")
                                .get(ClientResponse.class);
                    String output6 = response14.getEntity(String.class);                    
                    
        		break;
        		
        		case 5:
        			System.out.println("Enter your account no ... ");
                    String accnobal=s.next();
                  
                    String bal = "http://localhost:8080/bankwebservicesapi/rest/customers/balance/'"+accnobal+"'";	           		    
            	    com.sun.jersey.api.client.Client client15 = com.sun.jersey.api.client.Client.create();
                    WebResource target5 = client15.resource(bal);
                    ClientResponse response15 = target5.accept("application/xml")
                                .get(ClientResponse.class);
                    String output7 = response15.getEntity(String.class);                    
                    System.out.println("Your Balance:- "+output7);
        		break;

        	}

            System.out.println("1. Create account");
        	System.out.println("2. Lodgment");
        	System.out.println("3. Transfer");
        	System.out.println("4. Withdraw");
        	System.out.println("5. Balance");
        	
        	System.out.println("Enter your choice");

            ch=s.nextInt();
               
        }
    }       
}