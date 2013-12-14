package edu.carleton.comp4109.blockciphers;

public class DESTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DES des = new DES();
		
		String key = "secretkey";
		String cipher = des.encrypt(key, "This is a secret message being encrypted by DES and isn't it awesome that it finally works?");
		
		
		System.out.println("Encrypting message with key: 'secretkey'\nMessage:\n" + 
				"This is a secret message being encrypted by DES and isn't it awesome that it finally works?\nCiphertext (Hex):");
		System.out.println(cipher);
		System.out.println("Decrypting ciphertext with key: 'secretkey'\nDecrypted Plaintext:");
		String plain = des.decrypt(key, cipher);
		System.out.println(plain);
		
		System.out.println("\nTriple DES: \nplaintext: WHOO TRIPLE DES!!\nkeys:\nchimichanga, raptor, snapdragon\nciphertext:");
		System.out.println(des.encrypt("snapdragon", des.decrypt("raptor", des.encrypt("chimichanga", "WHOO TRIPLE DES!!"))));
		System.out.println("Decryption:");
		System.out.println(des.decrypt("chimichanga", des.encrypt("raptor", des.decrypt("snapdragon", "WHOO TRIPLE DES!!"))));

	}

}
