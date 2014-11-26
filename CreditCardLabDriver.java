// Credit Card verification driver

import java.util.Scanner;

public class CreditCardLabDriver
{

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    boolean done = false;

    CreditCard test = new CreditCard();

    while(!done){
      System.out.println("Enter a number to be tested");
      String num = in.next();

      System.out.println("is "+num+" a valid credit card number? "+ test.verify(num));
      int typeInt = test.findType(num);
      System.out.println(typeInt);
      String[] types = {"none", "Master Card", "Visa", "American Express", "Discover", "Diners Club/ Carte Blanche"};

      System.out.println("Credit card type is: "+ types[typeInt]);
      System.out.println();
    }
  }
}