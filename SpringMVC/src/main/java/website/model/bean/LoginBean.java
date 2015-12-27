package website.model.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private String account;
	private String password;

	public LoginBean() {
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Login ");
		sb.append("[");
		sb.append("account=");
		sb.append(account);
		sb.append(", ");
		sb.append("password=");
		sb.append(password);
		sb.append("]");

		return sb.toString();
	}
}
