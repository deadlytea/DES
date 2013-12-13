package edu.carleton.comp4109.blockciphers;

public class DESTest2 {

	public static void main(String[] args) {
		
		String message = "1111111111";
		message = "";
		for (int i = 0; i< 64; i++) {
			message = "1" + message;
		}
		while(message.length() < 64)
			message = "0" + message;
		
		DES des = new DES();
		des.buildKeySchedule(DES.hash("Hello"));
		
		System.out.println(message);
		try {
			String result = des.encryptBlock(message);
			System.out.println(result);
			result = des.encryptBlock(result);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
