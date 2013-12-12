package edu.carleton.comp4109.blockciphers;

import java.math.BigInteger;

public class DES {
	
	public static int KEY_LENGTH = 64; 
	
	private static int[] PC1 = 
	{  
		57, 49, 41, 33, 25, 17,  9,
         1, 58, 50, 42, 34, 26, 18,
        10,  2, 59, 51, 43, 35, 27,
        19, 11,  3, 60, 52, 44, 36,
        63, 55, 47, 39, 31, 23, 15,
         7, 62, 54, 46, 38, 30, 22,
        14,  6, 61, 53, 45, 37, 29,
        21, 13,  5, 28, 20, 12,  4
	};
	
	// First index is garbage value, loops operating on this should start with index = 1
	private static int[] KEY_SHIFTS = 
	{
		0,  1,  1,  2,  2,  2,  2,  2,  2,  1,  2,  2,  2,  2,  2,  2,  1
	};
	
	private static int[] PC2 = 
	{
		14, 17, 11, 24,  1,  5,
         3, 28, 15,  6, 21, 10,
        23, 19, 12,  4, 26,  8,
        16,  7, 27, 20, 13,  2,
        41, 52, 31, 37, 47, 55,
        30, 40, 51, 45, 33, 48,
        44, 49, 39, 56, 34, 53,
        46, 42, 50, 36, 29, 32
	};
	
	private long[] K;
	
	public DES() {
		
		// First index is garbage value, loops operating on this should start with index = 1
		K = new long[17];
		
	}
	
	public String encrypt(String key, String plaintext) {
		
		// Build the key schedule
		buildKeySchedule(hash(key));
		
		
		
		return "";
	}
	
	public BigInteger encrypt(String key, BigInteger plaintext) {
		
		// Build the key schedule
		buildKeySchedule(hash(key));
		
		
		
		return null;
	}
	
	private long encryptBlock(long plaintextBlock) {
		
		
		return 0;
	}
	
	/**
	 * Hash Function from user <b>sfussenegger</b> on stackoverflow 
	 * 
	 * @param string : String to hash
	 * @return 64-bit long hash value
	 * @source http://stackoverflow.com/questions/1660501/what-is-a-good-64bit-hash-function-in-java-for-textual-strings 
	 */
	
	// adapted from String.hashCode()
	public static long hash(String string) {
		long h = 1125899906842597L; // prime
		int len = string.length(); 

		for (int i = 0; i < len; i++) {
			h = 31*h + string.charAt(i);
		}
		return h;
	}
	
	private void buildKeySchedule(long key) {
		
		// Convert long value to 64bit binary string
		String binKey = Long.toBinaryString(key);
		
		// Add leading zeros if not at key length for ease of computations
		while (binKey.length() < 64) 
			binKey = "0" + binKey;
		
		// For the 56-bit permuted key 
		String binKey_PC1 = "";
		
		// Apply Permuted Choice 1 (64 -> 56 bit)
		for (int i = 0; i < PC1.length; i++)
			binKey_PC1 = binKey_PC1 + binKey.charAt(PC1[i]);
		
		String sL, sR;
		int iL, iR;
		
		// Split permuted string in half | 56/2 = 28
		sL = binKey_PC1.substring(0, 28);
		sR = binKey_PC1.substring(28);
		
		// Parse binary strings into integers for shifting
		iL = Integer.parseInt(sL, 2);
		iR = Integer.parseInt(sR, 2);
		
		// Build the keys
		for (int i = 1; i < K.length; i++) {
			
			// Perform left shifts according to key shift array
			iL = Integer.rotateLeft(iL, KEY_SHIFTS[i]);
			iR = Integer.rotateLeft(iR, KEY_SHIFTS[i]);
			
			// Merge the two halves
			long merged = ((long)iL << 28) + iR;
			
			// 56-bit merged
			String sMerged = Long.toBinaryString(merged);
			
			// Fix length if leading zeros absent
			while (sMerged.length() < 56)
				sMerged = "0" + sMerged;
			
			// For the 56-bit permuted key 
			String binKey_PC2 = "";
			
			// Apply Permuted Choice 2 (56 -> 48 bit)
			for (int j = 0; j < PC2.length; j++)
				binKey_PC2 = binKey_PC2 + sMerged.charAt(PC2[j]);
			
			// Set the 48-bit key
			K[i] = Long.parseLong(binKey_PC2, 2);
		}
	}

}
