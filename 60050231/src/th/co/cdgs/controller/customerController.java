package th.co.cdgs.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



import th.co.cdgs.bean.*;
@Path("customer")
public class customerController {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getCustomer() throws SQLException {
			ResultSet rs = null;
			PreparedStatement pst = null;
			Connection conn = null;
			List <CustomerDto> list = new ArrayList<>(); 
			
			try {
			 conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/workshop","root","p@ssw0rd");
			 pst = conn.prepareStatement("select customer_Id ,"
						+ "concat(first_name,' ',last_name) as full_name , "
						+ "address,tel,email from customer");
			 rs = pst.executeQuery();
				CustomerDto customerDto = null;
				while (rs.next()) {
					customerDto = new CustomerDto();
					customerDto.setCustomerId(rs.getLong("customer_Id"));
					customerDto.setFullname(rs.getString("full_name"));
					customerDto.setAddress(rs.getString("address"));
					customerDto.setTel(rs.getString("tel"));
					customerDto.setEmail(rs.getString("email"));
					list.add(customerDto);
				}
			}catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				if(rs != null) {
					rs.close();
				}
				if(pst != null) {
					pst.close();
				}
				if(conn != null) {
					conn.close();
				}
		}
			return Response.ok().entity(list).build();
		}

		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response createCustomer(CustomerDto customer)  {
			ResultSet rs = null;
			PreparedStatement pst = null;
			Connection conn = null;
		
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/workshop","root","p@ssw0rd");
				pst = conn.prepareStatement(
						"INSERT INTO customer "
						+ "(first_name ,last_name,address,tel , email)"
						+ " VALUES (? ,? ,? ,? ,?)");
				int index =1 ;
					pst.setString(index++, customer.getFirstname());
					pst.setString(index++, customer.getLastname());
					pst.setString(index++, customer.getAddress());
					pst.setString(index++, customer.getTel());
					pst.setString(index++, customer.getEmail());
					pst.executeUpdate();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				if(rs != null) 
					try {
					rs.close();
					}catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				if(pst != null) try {
					pst.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				if(conn != null) try {
					conn.close();
				}catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			
		}
			return Response.ok().entity(customer).build();
}
		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response updateCustomer(CustomerDto customer)  {
			ResultSet rs = null;
			PreparedStatement pst = null;
			Connection conn = null;
		
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/workshop","root","p@ssw0rd");
				pst = conn.prepareStatement("UPDATE customer  SET\r\n" + 
						"first_name  = ? ,\r\n" + 
						"last_name = ? ,\r\n" + 
						"address = ? ,\r\n" + 
						"tel= ?  ,\r\n" + 
						"email = ?\r\n" + 
						"WHERE customer_Id = ?");
				int index =1 ;
				pst.setString(index++, customer.getFirstname());
				pst.setString(index++, customer.getLastname());
				pst.setString(index++, customer.getAddress());
				pst.setString(index++, customer.getTel());
				pst.setString(index++, customer.getEmail());
				pst.setLong(index++, customer.getCustomerId());
				pst.executeUpdate();
				}catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					if(rs != null) 
						try {
						rs.close();
						}catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					if(pst != null) try {
						pst.close();
					}catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					if(conn != null) try {
						conn.close();
					}catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				
			}
				return Response.ok().entity(customer).build();
	}
		
		@DELETE
		@Path("{id}")
		public Response deleteCustomer(@PathParam("id") Long customerId)  {
			ResultSet rs = null;
			PreparedStatement pst = null;
			Connection conn = null;
		
			try {
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/workshop","root","p@ssw0rd");
				pst = conn.prepareStatement("DELETE FROM customer WHERE customer_Id = ?");
				int index =1 ;
				pst.setLong(index++, customerId);
				pst.executeUpdate();
				}catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					if(rs != null) 
						try {
						rs.close();
						}catch (SQLException e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					if(pst != null) try {
						pst.close();
					}catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					if(conn != null) try {
						conn.close();
					}catch (SQLException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				
			}
				return Response.ok().entity(customerId).build();
	}
}
		
	
		
