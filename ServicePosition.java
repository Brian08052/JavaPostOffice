import java.util.Random;


class ServicePosition{
  int serviceTime = 0;
  int minTime;
  int maxTime;
  
  
  Customer currentCustomer = null;
  Random randy = new Random();
  
  public ServicePosition(int minTime, int maxTime){
    this.minTime = minTime;
    this.maxTime = maxTime;
  }
  
  public void setServiceTime(){
    this.serviceTime = randy.nextInt(this.maxTime+1 - this.minTime) + this.minTime;
  }
  
  public void setCurrentCustomer(Customer c){
    this.currentCustomer = c;
  }
  
  public void removeCurrentCustomer(){
    this.currentCustomer = null;
    
  }
  public String toString(){
    String output = "Service Position: ";
    if (this.currentCustomer != null){
      output += currentCustomer;
    }
    else{
      output += "unoccupied";
    }
    return output;
  }
}
