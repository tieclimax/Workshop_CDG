package th.co.cdgs.applicaion;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("/api")
	 public class Employee extends Application{
			private int employeeId;
			private String firstName;
			private String lastName;
			private String age;
			
			public int getEmployee() {
				return employeeId;
			}
			public void setEmployee(int employeeId) {
				this.employeeId = employeeId;
			}
			public String getfirstName() {
				return firstName;
			}
			public void setfirstName(String firstName) {
				this.firstName = firstName;
			}
			public String getlastName() {
				return lastName;
			}
			public void setlastName(String lastName) {
				this.lastName = lastName;
			}
			public String getAge() {
				return age;
			}
			public void setAge(String age) {
				this.age = age;
			}
		}
	
