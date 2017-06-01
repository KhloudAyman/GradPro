package com.hash;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

public class HashFunctions {
	public static String getHash(byte[] inputBytes, String algorithm){
		String hashValue="";
		try{
			MessageDigest messageDigest=MessageDigest.getInstance(algorithm);
			messageDigest.update(inputBytes);
			byte[] digestdBytes=messageDigest.digest();
			hashValue=DatatypeConverter.printHexBinary(digestdBytes).toLowerCase();	
			
		}
		catch(Exception e){
			
		}
		return hashValue;
	}

}
