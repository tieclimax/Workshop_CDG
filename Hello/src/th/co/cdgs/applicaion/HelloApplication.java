package th.co.cdgs.applicaion;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
	public class HelloApplication extends Application {
			private int custNo;
		    private String custName;
		    private String custCountry;
			
		    public int getCustNo() {
				return custNo;
			}
			public void setCustNo(int custNo) {
				this.custNo = custNo;
			}
			public String getCustName() {
				return custName;
			}
			public void setCustName(String custName) {
				this.custName = custName;
			}
			public String getCustCountry() {
				return custCountry;
			}
			public void setCustCountry(String custCountry) {
				this.custCountry = custCountry;
			}
}

		
	
