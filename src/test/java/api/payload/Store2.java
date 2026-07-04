package api.payload;

public class Store2 {
	int id;
	int petid;
	int quantity;
	String shipdate;
	String status;
	boolean complete;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetid() {
		return petid;
	}
	public void setPetid(int petid) {
		this.petid = petid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShipdate() {
		return shipdate;
	}
	public void setShipdate(String shipdate) {
		this.shipdate = shipdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	
}
