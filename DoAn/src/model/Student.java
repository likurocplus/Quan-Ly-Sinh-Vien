package model;

public class Student {
	 private int Stt;
	 private String maSV;
	 private String hoSV;
	 private String tenSV;
	 private String lop;
	 private int diemGPA;
	 //Contructor
	 public Student(int Stt,String maSV, String hoSV, String tenSV, String lop, int diemGPA) {
		this.Stt = Stt;
		this.maSV = maSV;
		this.hoSV = hoSV;
		this.tenSV = tenSV;
		this.lop = lop;
		this.diemGPA = diemGPA;
	 }
	 //Setter Getter
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getHoSV() {
		return hoSV;
	}
	public void setHoSV(String hoSV) {
		this.hoSV = hoSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public int getDiemGPA() {
		return diemGPA;
	}
	public void setDiemGPA(int diemGPA) {
		this.diemGPA = diemGPA;
	}
	public int getStt() {
		return Stt;
	}
	//Method
	public int get3SoCuoiMSV() {
		String tmp = maSV.substring(7);
		return Integer.parseInt(tmp);
	}
	public String toString() {
		return Stt + "\t" + maSV + "\t" + hoSV + " " + tenSV + "\t" + lop + "\t" + "\t" +diemGPA;
	}
	
}
