package RMI.QLKH;

import java.io.Serializable;

class ModelCustomer implements Serializable {
	private String id, name, address, type;

	public ModelCustomer() {
	}

	public ModelCustomer(String id) {
		this.id = id;
	}

	public ModelCustomer(String id, String name, String address, String type) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
