public class CreditCard
{
  public String verify(String cardNumber)
  { 
    int evenArraySize = 0;
    int oddArraySize = 0;
    if(cardNumber.length()%2 == 0)
    {
      evenArraySize = cardNumber.length()/2;
      oddArraySize = cardNumber.length()/2;
    }
    else if(cardNumber.length()%2 == 1)
    {
      evenArraySize = cardNumber.length()/2;
      oddArraySize = (cardNumber.length()/2) + 1;
    }
    int[] evenArray = new int[evenArraySize];
    int[] oddArray = new int[oddArraySize];
    int[] bothArray = new int[cardNumber.length()];
    
    int x = 0; // Value to use for the odd number array input
    int y = 0; // Value to use for the even number array input

    for(int i = cardNumber.length(); i > 0; i-=2)
    {
      boolean runFirst = true;
      if(runFirst)
      {
        oddArray[x] = Integer.parseInt(cardNumber.substring(i));
        x++;
        evenArray[x] = Integer.parseInt(cardNumber.substring(i-1,i));
        runFirst = false;
      }
      if(oddArraySize > evenArraySize)
      {
        if(i != 1)
        {
          oddArray[x] = Integer.parseInt(cardNumber.substring(i,i+1));
          x++;
          evenArray[x] = Integer.parseInt(cardNumber.substring(i-1,i));
          y++;
        }
        else
        {
          oddArray[x] = Integer.parseInt(cardNumber.substring(0,i));
        }
      }
      else if(oddArraySize == evenArraySize)
      {
        if(i != 2)
        {
          oddArray[x] = Integer.parseInt(cardNumber.substring(i,i+1));
          x++;
          evenArray[x] = Integer.parseInt(cardNumber.substring(i-1,i));
          y++;
        }
        else
        {
          oddArray[x] = Integer.parseInt(cardNumber.substring(i,i+1));
          evenArray[x] = Integer.parseInt(cardNumber.substring(i-1,i));
        }
      } 
    }
          
          
          
    //Take every even number from the back, convert it back to an int, multiply it by 2, and put it into a new int array
    //Go through the array and if the int is greater than 10, subtract the number by 10 and add 1.
    //Add all the values in the array together into a value set at the beginning
    //Take every odd number from the back, convert it back to an int, and put it into a new int array.
    //Add all values in the array together into another value set at the beginning
    //Add the values set at the beginning together, and check if modulus 10 = 0. If modulus = 0, return "It is a valid credit card number"
    //      Else return "It is not a valid credit card number"
  }
  public int findType(String cardNumber)
  {
    //create an int array of each int value
    //if first value of the array is 4, return 2;
    //if first value is 3, and second number is 4 or 7, return 4
    //if first value is 3, and second number is 6 8, return 5
    //    if first value is 3, second number is 0, and third number is greater than or equal to 0 or less than 6, then return 5
    //if first value 5, check if the second value is greater than 0 and less than 6, if it is, return 1.
    //if the number is 6011, then return 3
    // else return 0
  }
}