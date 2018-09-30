public class CallTestCentre
{
    public static void main(String args [])
    {
        int choice;
        //Ask the user to enter the maximum number of calls that can be stored in the call centre. 
        System.out.print("Enter the maximum number of calls that can be taken in the centre: ");
        int num = EasyScanner.nextInt();  
        
        CallCentre call = new CallCentre(num);   //creating call centre object
        
        do
        {   
            
             System.out.println();
             System.out.println("Call Centre System");
             System.out.println();
             System.out.println("1.Add a call");
             System.out.println("2.Remove a call");
             System.out.println("3.Update call status");
             System.out.println("4.Check if the call list is empty");
             System.out.println("5.Check if the call list is full");
             System.out.println("6.Call details...");
             System.out.println("7.Update suggested length of call");
             System.out.println("8.Exit System");
             System.out.println();
        
             System.out.print("Please enter choice (1-8 only): ");
             choice = EasyScanner.nextInt();
             System.out.println();
             
                 switch (choice)
                 {
                     case 1: option1(call);
                               break;
                     case 2: option2(call);
                               break;
                     case 3: option3(call);
                               break;
                     case 4: option4(call);
                               break;
                     case 5: option5(call);
                               break;
                     case 6: option6(call);
                               break;
                     case 7: option7(call);
                               break;
                     case 8: break;

                     default:  System.out.println("Invalid entry");
                 }
                
        }while(choice != 8);
        
        System.out.print("Thank you for using the call centre system");
    } 
    
    private static void option1(CallCentre call)
    {      
        System.out.println("Add a call");
        System.out.print("\t Enter call id: ");
        String callId = EasyScanner.nextString();
        
        System.out.print("\t Enter length of call (minutes): ");
        int length = EasyScanner.nextInt();
        
        System.out.print("\t Enter the call status (open, pending or closed): ");
        String status = EasyScanner.nextString();
        
        System.out.print("\t Do you need to call the customer back (y or n): ");
        char callBack = EasyScanner.nextChar();
        boolean callCustomer = false;
        
        if(callBack != 'y' && callBack != 'n' && callBack != 'Y' && callBack != 'N') 
        {
            System.out.print("\t Error - Please enter a valid call back status (y or n) ");
            callBack = EasyScanner.nextChar();
        }
        else
        {
            callCustomer = true;
        }
        
        System.out.print("\t Enter agent name: ");
        String name = EasyScanner.nextString();
        
        System.out.print("\t How happy was your customer? 1 (very happy) to 5 (very unhappy): ");
        int rating = EasyScanner.nextInt();
     
        while(rating < 1 || rating > 5)
        {
            System.out.print("\t How happy was your customer? 1 (very happy) to 5 (very unhappy): ");
            rating = EasyScanner.nextInt();
        }    
                                             //creating new account 
        Call list = new Call(callId, length, status, callCustomer, name, rating);
        
        if(call.add(list))
        {
           System.out.println("Call added");
        } 
        else
        {
           System.out.println("Call not added");
        }    
    }
    
    private static void option2(CallCentre call)
    {
       System.out.println("Delete a call");
       System.out.print("\t Enter call id to remove: ");
       String callId = EasyScanner.nextString();    //getting call id to remove
       
       if (call.remove(callId))   //delete item if it exists
       {
           System.out.println("Call with id number " + callId + " is removed");
       }  
       else
       {
          System.out.println("Cannot delete call as no such call exists");
       }
           
    }
    
    
    private static void option3(CallCentre call)
    {
       System.out.println("Update the status on a call");
       System.out.print("\t Enter call Id: ");
       String callId = EasyScanner.nextString();
      
       Call update = call.getItem(callId);
       
       if(update == null)
       {
           System.out.print("No such Id exists");  
       }
       else
       {
           System.out.println("Enter the call status (open, pending or closed): ");
           String newStatus = EasyScanner.nextString().toLowerCase();
           update.setCallStatus(newStatus);
       }
    }
    
    private static void option4(CallCentre call)
    {
       if(call.isEmpty())
       {
           System.out.print("The call list is empty");
           System.out.println();
       }
       else
       {
           System.out.print("The call list is not empty");
           System.out.println();
       }    
    }
    
    private static void option5(CallCentre call)
    {
        if(call.isFull())
       {
           System.out.print("The call list is full");
           System.out.println();
       }
       else
       {
           System.out.print("The call list is not full");
           System.out.println();
       }  
    }
    
    private static void option6(CallCentre call)
    {
       char choice = ' ';
       
            System.out.println("Call Centre System");
            System.out.println();
            System.out.println("1.Add a call");
            System.out.println("2.Remove a call");
            System.out.println("3.Update call status");
            System.out.println("4.Check if the call list is empty");
            System.out.println("5.Check if the call list is full");
            System.out.println("6.Call details...");
            System.out.println("\t a. Display Details of a specific call");
            System.out.println("\t b. Display All calls");
            System.out.println("\t c. Display longest call");
            System.out.println("\t d. Display shortest call");
            System.out.println("\t e. Display all calls above the suggested length of a call");
            System.out.println("7.Update suggested length of call");
            System.out.println("8.Exit System");
            System.out.println();
            
            System.out.print("Enter choice [a - e]: ");
            choice = EasyScanner.nextChar();
            System.out.println();
            
            switch(choice)
            {
                case 'a': option6a(call);
                          break;
                case 'b': option6b(call);
                          break;
                case 'c': option6c(call);
                          break;
                case 'd': option6d(call);
                          break;
                case 'e': option6e(call);
                          break;
                default : System.out.println("Invalid entry");
            }
         
    }
    
    private static void option6a(CallCentre call)
    {
        System.out.println("Display a specific call");
        System.out.print("\t Enter Call id: ");
        String callId = EasyScanner.nextString(); 
        System.out.println();
        
        Call list = call.getItem(callId);
        
        if (list.equals(""))
        {
            System.out.println("No such call Id");
        }
        else
        {
            System.out.println(list.toString());   //calling toString method
            System.out.println(); 
        }
    }
    
    private static void option6b(CallCentre call)
    {
        String callDetails = call.listCalls();
        System.out.println(callDetails);
    }
    
    private static void option6c(CallCentre call)
    {
        System.out.println(call.checkLongestCall());
    }
    
    private static void option6d(CallCentre call)
    {
        System.out.println(call.checkShortestCall());
    }
    
    private static void option6e(CallCentre call)
    {
        System.out.println("Displaying all calls above the suggested length of a call: " + Call.getSuggestedlengthOfCall());
        System.out.println();
        System.out.println(call.listCallsAboveSuggestedLength());
    }
    
    private static void option7(CallCentre call)
    {
        System.out.print("Enter the new suggested length of each call: ");
        int newLength = EasyScanner.nextInt();
        
        call.updateSuggestedLengthOfCall(newLength);
    }
    
    //   private static String getValidCallStatus()
    //   {
    //      
    //   }
}