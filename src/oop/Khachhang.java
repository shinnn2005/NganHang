package oop;



public class Khachhang {
	private String hoten; 
	private String sotk ;
	private String taikhoan ;
	private String matkhau ;
	private String quoctich ;
	private String ngaysinh ;
	private String CMND ;
	private String sotien ;
	private String quequan;
	private String gioitinh;
	
	
	public String getQuequan() {
		return quequan;
	}
	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSotk() {
		return sotk;
	}
	public void setSotk(String sotk) {
		this.sotk = sotk;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public String getQuoctich() {
		return quoctich;
	}
	public void setQuoctich(String quoctich) {
		this.quoctich = quoctich;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getSotien() {
		return sotien;
	}
	public void setSotien(String sotien) {
		this.sotien = sotien;
	}
	
	@Override
	public String toString() {
		return "Khachhang [hoten=" + hoten + ", sotk=" + sotk + ", taikhoan=" + taikhoan + ", matkhau=" + matkhau
				+ ", quoctich=" + quoctich + ", ngaysinh=" + ngaysinh + ", CMND=" + CMND + ", sotien=" + sotien
				+ ", quequan=" + quequan + ", gioitinh=" + gioitinh + "]";
	}
    
}
