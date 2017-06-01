package c.beans;

public class task {
	private int T_ID;
	private int Load;
	private int START_X;
	private int START_Y;
	private int END_X;
	private int END_Y;
	private int user;
	
	public int getT_ID() {
		return T_ID;
	}
	public void setT_ID(int T_ID) {
		this.T_ID = T_ID;
	}
	
	public int getLoad() {
		return Load;
	}
	public void setLoad(int Load) {
		this.Load = Load;
	}
	
	public int getSTART_X(){
		return START_X;
	}
	public void setSTART_X(int START_X){
		this.START_X = START_X;
	}
	
	public int getSTART_Y(){
		return START_Y;
	}
	public void setSTART_Y(int START_Y){
		this.START_Y = START_Y;
	}
	
	public int getEND_X(){
		return END_X;
	}
	public void setEND_X(int END_X){
		this.END_X = END_X;
	}
	
	public int getEND_Y(){
		return END_Y;
	}
	public void setEND_Y(int END_Y){
		this.END_Y = END_Y;
	}

	public int getuser(){
		return user;
	}
	public void setuser(int user){
		this.user = user;
	}
}
