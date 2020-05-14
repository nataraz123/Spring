package com.nt.beans;

public  class BankService {
	
	public BankService() {
		System.out.println("BankService:: 0-param constructor");
	}
	
	public static   float calcIntrestAmount(float pAmt,float time) {
		System.out.println("BankService.calcIntrestAmount() ---->Orginal");
		return (pAmt*time*1.0f)/100.0f;
	}

}
