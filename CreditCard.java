// Credit Card Verifyer
// by William Kwok
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
      oddArraySize = (cardNumber.length()/2)+1; // Adds one more because odd will have one more value
    }
    
    // Create new arrays of the correct size
    int[] evenArray = new int[evenArraySize];
    int[] oddArray = new int[oddArraySize];
    
    //Values to use for odd and even number array inputs
    int x = 0; // Even
    int y = 0; // Odd
    
    // Move the string into split arrays
    for(int i = 0; i < cardNumber.length(); i++)
    {
      //If it's an even amount of numbers
      if((cardNumber.length()%2) == 0)
      {
        //Checks if the position is an even or odd number and will add it to the array.
        if((i%2) == 0)
        {
          evenArray[x] = Integer.parseInt(cardNumber.substring(i,i+1));
          x++; //Increments position that will be input
        }
        else
        {
          oddArray[y] = Integer.parseInt(cardNumber.substring(i,i+1));
          y++;
        }
      }
      //If it's an odd amount of numbers
      else
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
    }
    
    // Doubles all values in the even array, and also checks if the double is greater than 10, and makes it into the correct single digit number
    for(int i = 0; i < evenArray.length; i++)
    {
      evenArray[i] = evenArray[i]*2;
      if(evenArray[i] >= 10)
      {
        evenArray[i] = evenArray[i]-10+1; // Subtracting by 10 and adding 1 will create a fake (but correct) effect of adding the two digits together
      }
    }
    
    // Adds all values in the arrays together
    for(int i = 0; i < evenArray.length; i++)
    {
      evenArrayTotal += evenArray[i];
    }
    for(int i = 0; i < oddArray.length; i++)
    {
      oddArrayTotal += oddArray[i];
    }
    
    // Returns valid or invalid if the total is divisible by 10 and has a remainder of 0 or something else.
    if(((oddArrayTotal+evenArrayTotal)%10) == 0)
    {
      return "It is a valid credit card number";
    }
    else
    {
      return "It is not a valid credit card number";
    }     
  }
  
  public int findType(String cardNumber)
  {
    // Create new array for values
    int[] cardArray = new int[cardNumber.length()];
    
    // Puts values of individual digits into the array
    for(int i = 0; i < cardNumber.length(); i++)
    {
      cardArray[i] = Integer.parseInt(cardNumber.substring(i,i+1));
    }
    
    // Brute force for starting with 3. 
    if(cardArray[0] == 3)
    {
      if(cardArray[1] == 4 || cardArray[1] == 7)
      {
        return 3;
      }
      else if(cardArray[1] == 6 || cardArray[1] == 8)
      {
        return 5;
      }
      else if(cardArray[1] == 0)
      {
        if(cardArray[2] >= 1 && cardArray[2] <= 5)
        {
          return 5;
        }
      }
    }
    
    // Brute force for Visa
    else if(cardArray[0] == 4)
    {
      return 2;
    }
    
    // Brute force for Master Card, checking if it also has the second digit working
    else if(cardArray[0] == 5)
    {
      if(cardArray[1] >= 1 && cardArray[1] <= 5)
      {
        return 1;
      }
    }
    
    // Brute force for Discover Card, checking if the first 4 digits match 6011
    else if(cardArray[0] == 6)
    {
      if(cardArray[1] == 0)
      {
        if(cardArray[2] == 1)
        {
          if(cardArray[3] == 1)
          {
            return 4;
          }
        }
      }
    }    
    
    // Else it'll return 0.
    return 0;
  }
}