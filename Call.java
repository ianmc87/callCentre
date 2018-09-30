public class Call    //template or blueprint class
{    
    private String callId;     // instance variables storing data
    private int numMinutes;
    private String callStatus;
    private boolean callBackCustomer;
    private String callAnsweredBy;
    private int customerSatisfactionRating;
    private static int suggestedlengthOfCall;
    
    public Call(String callId, int numMinutes, String callStatus, boolean callBackCustomer, String callAnsweredBy, int customerSatisfactionRating)
    {
        this.callId = callId;     //the constructor updates variables  with info passed in as parameters
        this.numMinutes = numMinutes;
        this.callStatus = callStatus;
        this.callBackCustomer = callBackCustomer;
        this.callAnsweredBy = callAnsweredBy;
        this.customerSatisfactionRating = customerSatisfactionRating;
    }
    
    public String getCallId()
    {
        return callId;
    }
    
    public int getNumMinutes()
    {
        return numMinutes;
    } 
    
    public String getCallStatus()
    {
        return callStatus;
    } 
    
    public boolean isCallBackCustomer()
    {
        return callBackCustomer;
    } 
    
    public String getCallAnsweredBy()
    {
        return callAnsweredBy;
    }
    
    public int getCustomerSatisfactionRating()
    {
        return customerSatisfactionRating;
    }
    
    public void setCallId(String callId)
    {
        this.callId = callId;
    } 
    
    public void setNumMinutes(int numMinutes)
    {
        this.numMinutes = numMinutes;
    } 
    
    public void setCallStatus(String callStatus)
    {
        this.callStatus = callStatus;
    }
    
    public void setCallBackCustomer(boolean callBackCustomer)
    {
        this.callBackCustomer = callBackCustomer;
    } 
    
    public void setCallAnsweredBy(String callAnsweredBy)
    {
        this.callAnsweredBy = callAnsweredBy;
    }
    
    public void setCustomerSatisfactionRating(int customerSatisfactionRating)
    {
        this.customerSatisfactionRating = customerSatisfactionRating;
    } 
    
    public static int getSuggestedlengthOfCall()
    {
        return suggestedlengthOfCall;
    }
    
    public static void setSuggestedlengthOfCall(int suggestedlengthOfCallIn)
    {
        suggestedlengthOfCall = suggestedlengthOfCallIn;
    }
    
    public String toString()
    {
        return "Call Id = " + callId + " (" + numMinutes + " minutes)\n" + 
               " Status = " + callStatus + ", " + "CallBack customer = " + callBackCustomer + "\n" +
               " Answered By = " + callAnsweredBy + ", " + "Customer Satisfaction Rating = " + customerSatisfactionRating;
    }
}