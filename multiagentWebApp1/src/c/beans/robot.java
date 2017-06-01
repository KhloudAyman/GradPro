package c.beans;

public class robot {
	
	private int R_ID;
	private String R_IP;
	private int AVAILITY;
	private float MAXLOAD;
	private int status;
	private int parkingX;
	private int parkingY;
	
	public int getR_ID() {
		return R_ID;
	}
	public void setR_ID(int R_ID) {
		this.R_ID = R_ID;
	}
	
	public String getR_IP() {
	       return R_IP;
	}
	public void setR_IP(String R_IP) {
	       this.R_IP = R_IP;
	}
	
	public int getAVAILITY() {
		return AVAILITY;
	}
	public void setAVAILITY(int AVAILITY) {
		this.AVAILITY = AVAILITY;
	}
	
	public float getMAXLOAD(){
		return MAXLOAD;
	}
	public void setMAXLOAD(float maxLoad2){
		this.MAXLOAD = maxLoad2;
	}
	
	public int getstatus(){
		return status;
	}
	public void setstatus(int status){
		this.status = status;
	}
	
	public int getparkingX(){
		return parkingX;
	}
	public void setparkingX(int parkingX){
		this.parkingX = parkingX;
	}
	
	public int getparkingY(){
		return parkingY;
	}
	public void setparkingY(int parkingY){
		this.parkingY = parkingY;
	}
	
}