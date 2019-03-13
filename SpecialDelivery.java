package com.abdumuhaimin.testbench;

public class SpecialDelivery extends Delivery {

	boolean weekendDelivery;
	boolean nightDelivery;
	
	SpecialDelivery(String sender, String recipient, double weight, boolean weekendDelivery, boolean nightDelivery) {
		super(sender, recipient, weight);
		this.weekendDelivery = weekendDelivery;
		this.nightDelivery = nightDelivery;
	}
	
	
	public static double totalCost(double w, boolean weekend, boolean night) {		
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
        
        if(weekend) {
			shippingCost += 50;
		}
        if(night) {
        	double nightCost = shippingCost * 20 / 100;
			shippingCost += nightCost;
		}
		
		double roundedCost = Math.round(shippingCost * 100d) / 100d;
		return roundedCost;
	}
	
	public double getTotalCost() {
		double totalCost = totalCost(wPackage, weekendDelivery, nightDelivery);
		if(totalCost > 0)
			return totalCost;
		else
			return 0;
	}
	
	public static String verifyTime(boolean weekend, boolean night) {
		String status = "";
		
		if(weekend) {
			status += "Weekend Delivery\n";
		}
		if(night) {
			status += "Night Time Delivery\n";
		}
		
		return status;
	}
	
	@Override
	public String toString() {
		double totalCharge = totalCost(wPackage,weekendDelivery,nightDelivery);
		
		String deliveryStatus = verifyTime(weekendDelivery, nightDelivery);
		
		if(verifyw(wPackage).equals("Invalid w")) {
			return "From: " + sender + " To: " + recipient + "\n" + "Weight of package: " + wPackage + "kg"
					+ "\n" + "Invalid weight of package\n";
		}
		else {
			return "From: "+ sender + " To: "+ recipient + "\n" + "Weight of package: " + wPackage + "kg"
					+ "\n" + "Total shipping cost: " + "RM" + totalCharge + "\n" + deliveryStatus;
		}
	}
	
}
