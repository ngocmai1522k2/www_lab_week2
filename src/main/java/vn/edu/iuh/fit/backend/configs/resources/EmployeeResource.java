package vn.edu.iuh.fit.backend.configs.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.configs.models.Customer;
import vn.edu.iuh.fit.backend.configs.models.Employee;
import vn.edu.iuh.fit.backend.configs.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResource {
    public final EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public EmployeeResource(){
        employeeService = new EmployeeService();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        List<Employee> lst = employeeService.getAll();
        return Response.ok(lst).build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee){
        employeeService.insert(employee);
        return Response.ok(employee).build();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response findByID(@PathParam("id") long id) {
        Optional<Employee> employeeOptional = employeeService.findByID(id);
        if (employeeOptional.isPresent()) {
            return Response.ok(employeeOptional.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (employeeService.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
