package Lab4.model;

public class modelCompany {
//	Company(CompanyID, CompanyName) 
	private String companyID, companyName;

	public modelCompany(String companyID) {
		this.companyID = companyID;
	}

	public modelCompany(String companyID, String companyName) {
		this.companyID = companyID;
		this.companyName = companyName;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "companyID=" + companyID + ", companyName=" + companyName;
	}

	
}
