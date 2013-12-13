package edu.carleton.comp4109.blockciphers;

public class DESTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DES des = new DES();
		
		System.out.println(DES.hash("Hey Broski What's goin on?"));
		System.out.println(Long.toBinaryString(DES.hash("Hey Broski What's goin on?")));
		System.out.println(DES.hash("snapdragon"));
		System.out.println(Long.toBinaryString(DES.hash("snapdragon")));
		
		des.buildKeySchedule(DES.hash("snapdragon"));
		
		des.encrypt("Jimmy", "abcdefghijklmnopqrstuvwxyzABCDEFG1234567890,./;");

	}

}
