package edu.carleton.comp4109.blockciphers;

public class DESTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DES des = new DES();
		
		des.buildKeySchedule(DES.hash("snapdragon"));
		try {
			System.out.println(des.encryptBlock("0000000000000000000000000000000000000000000000000000000000000000"));
			System.out.println(des.encryptBlock("0100001011110110110010100100100101110001111111011101101000001100"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		des.testKeySchedule("1001100110100010101110111100110011011101111001101111111110001");
		
		String cipher = des.encrypt("Jimmy", "abcdefghijklmnopqrstuvwxyzABCDEFG1234567890,./;");
		String plain = des.encrypt("Jimmy", cipher);
		
		System.out.println(cipher);
		System.out.println(plain);

	}

}
