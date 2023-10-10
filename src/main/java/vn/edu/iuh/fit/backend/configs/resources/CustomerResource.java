package vn.edu.iuh.fit.backend.configs.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.services.CustomerServices;

import java.util.List;

@Path("/customers")
public class CustomerResource {
    public final CustomerServices customerServices;


    public CustomerResource() {
        customerServices = new CustomerServices();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> list = customerServices.getAll();
        return Response.ok(list).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer){
        boolean rs = customerServices.insert(customer);
        if(rs){
            return Response.ok(customer).build();
        }
        else{
            return  Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
