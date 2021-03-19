package com.jts.DAO;

class TestCustomException1{

	   static void validate(int age)throws InvalidAgeException{
	     if(age<18)
	      throw new InvalidAgeException("not valid");
	     else
	      System.out.println("welcome to vote");
	   }
	   
	   public static void main(String args[]){
	      try{
	      validate(23);
	      }catch(InvalidAgeException m)
	      {
	    	  System.out.println("Exception occured: "+m.getMessage());
	    	  }

	      System.out.println("rest of the code...");
	  }
	}
