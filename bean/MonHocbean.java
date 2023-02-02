package bean;

public class MonHocbean {
	private String mamh;
	private String tenmh;
	private int sotc;
	public String getMamh() {
		return mamh;
	}
	public void setMamh(String mamh) {
		this.mamh = mamh;
	}
	public String getTenmh() {
		return tenmh;
	}
	public void setTenmh(String tenmh) {
		this.tenmh = tenmh;
	}
	public int getSotc() {
		return sotc;
	}
	public void setSotc(int sotc) {
		this.sotc = sotc;
	}
	public MonHocbean(String mamh, String tenmh, int sotc) {
		super();
		this.mamh = mamh;
		this.tenmh = tenmh;
		this.sotc = sotc;
	}
	public MonHocbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void hienthi() {
		System.out.println("MH :" + mamh +"   "+ tenmh + "   " + sotc);
	}
	}
