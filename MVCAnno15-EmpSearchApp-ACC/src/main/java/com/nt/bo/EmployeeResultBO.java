package com.nt.bo;

public class EmployeeResultBO extends EmployeeBO {
	private int deptno;
	private int mgr;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getMgr() {
		return mgr;
	}
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

}
