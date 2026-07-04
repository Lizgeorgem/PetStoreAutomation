package api.payload;

public class Store {
	int id;
	int petid;
	int quantity;
	String shipdate;
	String status=new String("placed");
	boolean complete=true;
	
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

	
}
