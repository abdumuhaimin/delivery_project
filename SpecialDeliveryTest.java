package com.abdumuhaimin.testbench;

class SpecialDeliveryTest {

	public static void main(String args[]) {
		SpecialDelivery s1 = new SpecialDelivery("Ali", "Ahmad", 0.5, false, false);
		SpecialDelivery s2 = new SpecialDelivery("Ah Chong","Fatimah",63.1,false,false);
		SpecialDelivery s3 = new SpecialDelivery("FSKTM, UM", "FK, UM", 32.5, true, false);
		SpecialDelivery s4 = new SpecialDelivery("Ang", "Liew", 19.0, true, true);
		
		double total = s1.getTotalCost() + s2.getTotalCost() + s3.getTotalCost() + s4.getTotalCost();
		double roundedTotal = Math.round(total * 100d) / 100d;
		//Math.round(shippingCost * 100d) / 100d;
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println("The total shipping cost is RM " + roundedTotal);
	}
}
