/*
 * Author:Oscar Saravia
 * CMSC 204
 * Password Validity Assignment
 * This classes using methods and exception to check whether
 * or not the entered password is valid
 */


package abc;

import java.util.ArrayList;

public class PasswordCheckerUtility {

	/**
	 * 
	 * @param password-The password to be checked
	 * @param passwordConfirm-The confirmation to be checked against password
	 * @throws UnmatchedException-Thrown in the two strings are not the same
	 */
	public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException {
		
		if(!password.equals(passwordConfirm))
				throw new UnmatchedException("The two passwords are not the same.");
	}
	
	/**
	 * 
	 * @param password-The password to be checked
	 * @param passwordConfirm-The confirmation to be checked against password
	 * @return false if the two passwords are not the same else true
	 */
	public static boolean comparePasswordsWithReturn(String password,String passwordConfirm) {
		if(!password.equals(passwordConfirm))
			return false;
		else return true;
	}
	
	/**
	 * 
	 * @param password-The string to be checked
	 * @return-True if the string has at least 6 characters
	 * @throws LengthException-Thrown if the password is less than 6 characters
	 */
	public static boolean isValidLength(String password)throws LengthException {
		
		if(password.length()<6)
			throw new LengthException("Your password needs to have at least 6 characters to be long enough");
		else return true;
		
	}
	
	/**
	 * 
	 * @param password-The password to be checked
	 * @return-True if there is an uppercase letter, otherwise false
	 * @throws NoUpperAlphaException-Thrown if there are no uppercase alphabetic letters
	 */
		public static boolean hasUpperAlpha(String password)throws NoUpperAlphaException{
			boolean result=false;
			for(int i=0;i<password.length();i++) {
				if(password.codePointAt(i)<=90&&password.codePointAt(i)>=65)
					result=true;
			}
			if(result==false)
				throw new NoUpperAlphaException("Your password requires at least one uppercase alphabetic letter.");
			return result;
		
		}
	
	/**
	 * 
	 * @param password-The password to be checked
	 * @return-True if there is at least one lowercase letter, otherwise false
	 * @throws NoLowerAlphaException-Thrown if there are no lower case letters
	 */
	public static boolean hasLowerAlpha(String password)throws NoLowerAlphaException{
		boolean result=false;
		for(int i=0;i<password.length();i++) {
			if(password.codePointAt(i)<=122&&password.codePointAt(i)>=97)
				result=true;
		}
		if(result==false)
			throw new NoLowerAlphaException("Your password requires at least one lowercase alphabetic letter.");

		return result;
	}
	
	/**
	 * 
	 * @param password-The string to be checked for digits
	 * @return-True if there is at least one digit in the string, else returns false
	 * @throws NoDigitException-Thrown if there are no digits in string
	 */
	public static boolean hasDigit(String password)throws NoDigitException{
		boolean result=false;
		for(int i=0;i<password.length();i++) {
			if(password.codePointAt(i)<=57&&password.codePointAt(i)>=48)
				result=true;
		}
		if(result==false)
			throw new NoDigitException("Your password needs at least one digit");

		return result;
	}
	/**
	 * 
	 * @param password-The string to be checked for special character
	 * @return-True if the string has at least one special character, else returns false
	 * @throws NoSpecialCharException-Thrown if the string does not have a special character
	 */
	public static boolean hasSpecialChar(String password)throws NoSpecialCharacterException {
		boolean result=false;
		for(int i=0;i<password.length();i++) {
			if(password.codePointAt(i)>=32&&password.codePointAt(i)<=47   ||
			   password.codePointAt(i)>=58&&password.codePointAt(i)<=64   ||
			   password.codePointAt(i)>=91&&password.codePointAt(i)<=96   ||
			   password.codePointAt(i)>=123&&password.codePointAt(i)<=126)
				result=true;
			
		}
		if(result==false)
			throw new NoSpecialCharacterException("You need a special character");

		return result;
		

		
	}
	
	/**
	 * 
	 * @param password-The string to be checked for characters in the same sequence
	 * @return-True if there are no same characters sequentially, else false;
	 * @throws InvalidSequenceException-Thrown if the same characters appear in a sequence
	 */
	public static boolean NoSameCharInSequence(String password)throws InvalidSequenceException {
		boolean result=true;
		for(int i=0;i<password.length();i++) {
			if(i<password.length()-2) {
				if(password.codePointAt(i)==password.codePointAt(i+1)&&password.codePointAt(i)==password.codePointAt(i+2))
					result=false;
			}
		}
		if(result==false)
			 throw new InvalidSequenceException("Your password cannot have the same character in a sequence");
		
		return result;
	}
	
	
	
	/**
	 * 
	 * @param password-The password to be checked compared to conditions
	 * @return-True if password passed according to conditions set
	 * @throws LengthException-Thrown if password is less than 6 characters
	 * @throws NoUpperAlphaException-Thrown if no uppercase letters are used
	 * @throws NoLowerAlphaException-Thrown if no lowercase letters are used
	 * @throws NoDigitException-Thrown if no digits are used
	 * @throws NoSpecialCharacterException-Thrown if no special characters are used
	 * @throws InvalidSequenceException-Thrown if same character sequences are found
	 */
	public static boolean isValidPassword(String password)throws LengthException,
    NoUpperAlphaException,
    NoLowerAlphaException,
    NoDigitException,
    NoSpecialCharacterException,
    InvalidSequenceException {
		boolean result=true;
		
		if(isValidLength(password)==false) {
			result=false;
			//throw new LengthException("Your password needs at least 6 characters");	
			}
		
		else if(hasUpperAlpha(password)==false) {
			result=false;
			//throw new NoUpperAlphaException("Your password needs uppercase letter");
		}
		
		else if(hasLowerAlpha(password)==false) {
			result=false;
			//throw new NoLowerAlphaException("Your password needs lowercase letter");
		}
		
		else if(hasDigit(password)==false) {
			result=false;
			//throw new NoDigitException("Your password needs a digit");
		}
		
		else if(hasSpecialChar(password)==false) {
			result=false;
			//throw new NoSpecialCharacterException("Your password needs a special character");
		}
				
		else if(NoSameCharInSequence(password)==false) {
			result=false;
			//throw new InvalidSequenceException("Your password cannot have the same characters in a sequence");
		}
		
		
		
		return result;
	}
	
	/**
	 * 
	 * @param password-String to be checked for length between 6 and 9 characters
	 * @return-True if the string is between 6 and 9 characters, else false
	 */
	public static boolean hasBetween6And9Chars(String password) {
		boolean result=false;
		if(password.length()<=9&&password.length()>=6)
			result=true;
		
		return result;
		
	}
	
	/**
	 * 
	 * @param password-The string to be checked for password security
	 * @return-Returns true if between 
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword(String password)throws WeakPasswordException {
		boolean result=false;
		
			try {
				if(isValidPassword(password)&&hasBetween6And9Chars(password)==false)
					result=true;
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result==false)
				throw new WeakPasswordException("Your password's security is weak");
		
		
		
		
		return result;
	}
	
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> list=new ArrayList<String>();
		String error="";
		for(int i=0;i<passwords.size();i++) {
				try {
					if(isValidPassword(passwords.get(i))==false)
						list.add(passwords.get(i));
					
				} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
						| NoSpecialCharacterException | InvalidSequenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					error=e.getLocalizedMessage();
				}finally {
					list.add(passwords.get(i)+" "+error);
				}
		}
		
				
		
		
		
		return list;
	
	}
}
