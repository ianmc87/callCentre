
public class CallCentre
{                            //attributes
     private Call[] calls; //to hold the accounts  
     private int total;   //keeping track of the number of calls
        
     public CallCentre(int size)   //constructor
     {
         calls = new Call[size];   //setting size of the array
         total = 0;               //setting number of calls to 0
     } 
     
     public int getTotal()   //returns total number of calls
     {
         return total; 
     } 
     
     public boolean add(Call callIn)  //adding a call object to the array, provided there is space
     {
         if(!isFull())   //checking if the array is full
         {
            calls [total] = callIn;   //add item
            total++;                  //increment total
            return true;              //indicate success
         }
         else
         {
            return false;            //indicate failure
         }   
     }  
     
     public boolean remove(String code)   //removing a call from the array
     {
        int index = search(code);    // find index of account
        if(index == -20)    // if no such account
        {
           return false;   // remove was unsuccessful
        }
        else
        {      // overwrite items by shifting other items along
           for(int i = index; i < total-1; i++)
           {
                  calls[i] = calls[i+1];
           }   
           total--;       // decrement total number of accounts
           return true;   // remove was successful
        }
     } 
     
     public boolean isEmpty()   // checking if the call list is empty
     {
         if(total == 0)
         {
            return true;    // list is empty
         } 
         else
         {
            return false;   // list is not empty
         } 
     } 
     
     public boolean isFull()  // checking if the list is full
     {
         if(total == calls.length)
         {
            return true;   // list is full
         }
         else
         {
            return false;   // list is empty
         }    
     } 
     
     public Call checkLongestCall()
     {
         int index = 0;
         double max = calls[0].getNumMinutes();
         for(int i = 1; i < total; i++) 
         {
             if(calls[i].getNumMinutes() > max)
             {
                max = calls[i].getNumMinutes();
                index = i;
             }
         }
         return calls[index];
     }
     
     public Call checkShortestCall()
     {
         int index = 0;
         double min = calls[0].getNumMinutes();
         for(int i = 1; i < total; i++ )
         {
             if(calls[i].getNumMinutes() < min)
             {
                min = calls[i].getNumMinutes();
                index = i;
            }
         }
         return calls[index];
     }
     // helper method to find the index of a specified call
     private int search(String code)  //holds user input
     {
         for(int i = 0; i < total; i++)
         {
            if(calls[i].getCallId().equals(code))  //is the string we just entered equal to our call id 
            {
                return i;     //number will be returned
            }
         }  
         return -20;   //error code
     }
     
     public String listCalls()  //returns a string containing all the calls in the array
     {
         String callDetails = "";    //creating somewhere to hold the Strings
         for(int i = 0; i < total; i++)    
         {
             callDetails += calls[i].toString() + "\n";   //calling toString method in Call class,going through each array amd storing information in the callDetails variable
         }
         return callDetails;
     }
     
     public String listCallsAboveSuggestedLength()
     {
         String callDetails = "";
         if(!isEmpty())
         {
            for(int i = 0; i < total; i++)
            {
                if(calls[i].getNumMinutes() > Call.getSuggestedlengthOfCall())
                {
                    callDetails = callDetails + calls[i].toString() + "\n";
                }
            }
         }
         return callDetails;
     }
     
     public Call getItem(String code) // return an account at a particular place in the Call array
     {
         int index = search(code);
         if(index == -20)
         {
            return null; // indicate invalid index
         }
         else
         {
            return calls[index];
         }
     }
     
     public void updateSuggestedLengthOfCall(int callIn)
     {
         Call.setSuggestedlengthOfCall(callIn); 
     }
}
