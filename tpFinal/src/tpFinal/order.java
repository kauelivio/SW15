//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tpFinal;

public class order {

	private int ordNo, customerId, salesmanId;
	private String ordDate;
	private float purchAmt;
	
	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}
	
	public String getOrdDate() {
		return ordDate;
	}
	
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	
	public float getPurchAmt() {
		return purchAmt;
	}
	
	public void setPurchAmt(float purchAmt) {
		this.purchAmt = purchAmt;
	}
}
