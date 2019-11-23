package th.co.cdgs.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import th.co.cdgs.applicaion.Employee;
import th.co.cdgs.applicaion.HelloApplication;



@Path("hello")
	public class HelloController {
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		@Consumes(MediaType.TEXT_PLAIN)
	 public Response helloString(String name) {
		return Response.ok().entity("Hello"+ " " +name).build();
		
	}
		/*@GET
		@Path("{name}")
		@Produces(MediaType.TEXT_PLAIN)
	public Response helloPathParam(@PathParam ("name") String name) {
			return Response.ok().entity("Path : Hello"+ " " +name).build();
		}*/
		
		@GET
		
	public Response helloQueryParam(@QueryParam ("firstName") String firstName,
			@QueryParam ("lastName") String lastName,
			@QueryParam ("age") String age) {
			String letter = "";
				if(firstName != null && !"".equals(firstName)) {
					letter += firstName + " ";
					}
				if(lastName != null && !"".equals(lastName)) {
					letter += lastName + " ";
					}
				if(age != null && !"".equals(age)) {
					letter += age + " ";
					}
				return Response.ok().entity("QueryParam : Hello"+ " " +letter).build();
		}
		
		@GET
	    @Path("/{cusNo}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public HelloApplication produceCustomerDetailsinJSON(@PathParam("cusNo") int no) {
	
				HelloApplication cust = new HelloApplication();        
	            cust.setCustNo(no);
	            cust.setCustName("Code CDG");
	            cust.setCustCountry("Thailand");
	            return cust;
	    }
		
		@GET
	    @Path("/{employeeId}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Employee employeeDetailsinJSON(@PathParam("employeeId") int employeeId) {
	
			Employee emp = new Employee();        
			emp.setEmployee(employeeId);
			emp.setfirstName("Panuwat");
			emp.setlastName("Khrai-udom");
			emp.setAge("21");
	            return emp;
	    }
	}

