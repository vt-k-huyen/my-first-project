package bean;

public class Khoabean {
	protected String makhoa;
	protected String tenkhoa;
	public String getMakhoa() {
		return makhoa;
	}
	public void setMakhoa(String makhoa) {
		this.makhoa = makhoa;
	}
	public String getTenkhoa() {
		return tenkhoa;
	}
	public void setTenkhoa(String tenkhoa) {
		this.tenkhoa = tenkhoa;
	}
	public Khoabean(String makhoa, String tenkhoa) {
		super();
		this.makhoa = makhoa;
		this.tenkhoa = tenkhoa;
	}
	public Khoabean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void hienthi() {
		System.out.println("Ma khoa: " + makhoa + "Ten khoa: " + tenkhoa);
	}
}
