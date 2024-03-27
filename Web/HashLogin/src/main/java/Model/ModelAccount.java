package Model;

public class ModelAccount {
	private String idAccount, passAccount;

	public ModelAccount() {
	}

	public ModelAccount(String idAccount, String passAccount) {
		this.idAccount = idAccount;
		this.passAccount = passAccount;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public String getPassAccount() {
		return passAccount;
	}

	public void setPassAccount(String passAccount) {
		this.passAccount = passAccount;
	}

}
