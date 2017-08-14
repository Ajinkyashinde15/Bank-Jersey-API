
package com.api.webservices.bankwebservices.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.api.webservices.bankwebservices.model.Account;
import com.api.webservices.bankwebservices.model.Customer;
import com.api.webservices.bankwebservices.service.CustomerService;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

//Define head url path
@Path("/customers")
public class CustomerResources {
    
    CustomerService customerService = new CustomerService();
    
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)

    //Method to get all customers
    @GET
    @Path("/customersall")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }    

    //Get Method to get customer balance
    @GET
    @Path("/balance/{id}")
    public int getCustomersbal(@PathParam("id") int id) {
        return customerService.getcstbal(id);
    }    
    
    //Get Method to get customer details
    @GET
    @Path("/{cId}")
    public Customer getTaxpayer(@PathParam("cId") int id) {
        return customerService.getCustomer(id);
    }
    
    //Add account Method   
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{cid}")
    public Account putAccount(@PathParam("cid") int cid, Account ac) { 
        return customerService.addAccount(cid,ac);
    }

    //Get Method to get lodge money 
    @GET
    @Path("lodgment/{id}/amount/{amount}")
    public int lodgment(@PathParam("id") int id,@PathParam("amount") int amount) {
        return customerService.lodgment(id,amount);
    }
    
    //Get Method to get transfer money 
    @GET
    @Path("transfer/{source}/destination/{destination}/amount/{amount}")
    public int transfer(@PathParam("source") int source,@PathParam("destination") int destination,@PathParam("amount") int amount) {
        return customerService.transfer(source,destination,amount);
    }
    
    //Get Method to get withdraw money 
    @GET
    @Path("withdraw/{id}/amount/{amount}")
    public int withdraw(@PathParam("id") int id,@PathParam("amount") int amount) {
        return customerService.withdraw(id,amount);
    }

    /*  @GET
    @Path("/taxcredits")
    public void getTaxCredits(@QueryParam("credit1") String cr1,@QueryParam("credit2") String cr2 ) {
        taxpayerService.getTaxCredits(cr1, cr2);
    }
        
    @POST
    public Taxpayer postTaxpayer(Taxpayer m) {       
        return taxpayerService.createTaxpayer(m);
    }
    
    @PUT
    @Path("/{taxpayerId}")
    public Taxpayer putTaxpayer(@PathParam("taxpayerId") int id, Taxpayer t) { 
        t.setId(id);
        return taxpayerService.updateTaxpayer(t);
    }
            
    @DELETE
    @Path("/{taxpayerId}")
    public void deleteTaxpayer(@PathParam("taxpayerId") int id) { 
        taxpayerService.deleteTaxpayer(id);
    }
    */
      
}
