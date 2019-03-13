package com.abdumuhaimin.testbench;

public class Delivery {
	String sender, recipient;
	double wPackage;
	
	Delivery(String sender, String recipient, double w){
		this.sender = sender;
		this.recipient = recipient;
		this.wPackage = w;
		
		
	}
	
	public static String verifyw(double w) {
		if(w <= 0)
			return "Invalid w";
		else
			return "Valid w";
	}
	
	public static double totalCost(double w) {
		double shippingCost;
        if(w <=5){
            shippingCost=w*2.8;
        }
        else if(w>5 && w<=20){
            shippingCost= (5*2.8) + (w-5)*5.2;
        }
        else if(w>20 && w <=50){
            shippingCost= (5*2.8) + (15*5.2) + (w-20)*7;
        }
        else{
            shippingCost= (5*2.8) + (15*5.2) + (30*7) + (w-50)*8.6;
        }
		double roundedCost = Math.round(shippingCost * 100d) / 100d;
		return roundedCost;
	}
	
	@Override
	public String toString() {
		double totalCharge = totalCost(wPackage);
		
		return "From: "+ sender + " To: "+ recipient + "\n" + "w of package: " + wPackage + "kg"
	+ "\n" + "Total shipping cost: " + "RM" + totalCharge + "\n";
	}
	
	public static void main(String args[]) {
		Delivery d1 = new Delivery("Abdu", "Muhaimin", 3);
		Delivery d2 = new Delivery("Raihan", "Rehe", 8.90);
		System.out.println(d1);
		System.out.println(d2);
	}
}