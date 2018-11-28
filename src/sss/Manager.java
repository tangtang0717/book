package sss;

public class Manager {
	private int mid ;
	private String mname;
	private int mnum;
	private String mpassword;
	
	public Manager() {
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public String getMpassword() {
		return mpassword;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", mnum=" + mnum + ", mpassword=" + mpassword + "]";
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	
}
