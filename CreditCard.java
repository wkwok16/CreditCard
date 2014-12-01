public class CreditCard
{
  public String verify(String cardNumber)
  { 
    //Create sizes for arrays to become
    int evenArraySize = 0;
    int oddArraySize = 0;
    
    // Create total values for everything added together
    int evenArrayTotal = 0; 
    int oddArrayTotal = 0;
    
    //Finds out if there is an even number of digits or odd, and sets lengths of arrays accordingly
    if(cardNumber.length()%2 == 0) 
    {
      evenArraySize = cardNumber.length()/2;
      oddArraySize = cardNumber.length()/2;
    }
    else if(cardNumber.length()%2 == 1)
    {
      evenArraySize = cardNumber.length()/2;
      oddArraySize = (cardNumber.length()/2)+1;
    }
    // Create new arrays of the correct size
    int[] evenArray = new int[evenArraySize];
    int[] oddArray = new int[oddArraySize];
    
    //Values to use for odd and even number array inputs
    int x = 0; // Odd
    int y = 0; // Even
    
    // Boolean to check if this is the first loop or not, to find end
    boolean runFirst = true;
    
    // Move the string into split arrays
    for(int i = 0; i < cardNumber.length(); i++)
    {
      //If it's an even amount of numbers
      if((cardNumber.length()%2) == 0)
      {
        if((i%2) == 0)
        {
          oddArray[x] = Integer.parseInt(cardNumber.substring(i,i+1));
          x++;
        }
        else
        {
          evenArray[y] = Integer.parseInt(cardNumber.substring(i,i+1));
          y++;
        }
      }
      //If it's an odd amount of numbers
      else
      {
        if((i%2) == 0)
        {
          evenArray[y] = Integer.parseInt(cardNumber.substring(i,i+1));
          y++;
        }
        else
        {
          oddArray[x] = Integer.parseInt(cardNumber.substring(i,i+1));
          x++;
        }
      }
     // find modulus of i and see if even or odd and also check size of string
    }
    
    for(int i = 0; i < oddArray.length; i++)
    {
      oddArray[i] = oddArray[i]*2;
      if(oddArray[i] >= 10)
      {
        oddArray[i] = oddArray[i]-10+1;
      }
    }
    
    for(int i = 0; i < oddArray.length; i++)
    {
      oddArrayTotal += oddArray[i];
    }
    for(int i = 0; i < evenArray.length; i++)
    {
      evenArrayTotal += evenArray[i];
    }
    
    if(((oddArrayTotal+evenArrayTotal)%10) == 0)
    {
      System.out.println(oddArraySize + " " + evenArraySize);
      return "It is a valid credit card number";
    }
    else
    {
      System.out.println(oddArraySize + " " + evenArraySize);
      return "It is not a valid credit card number";
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
    return 2;
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