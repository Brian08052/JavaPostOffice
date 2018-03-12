class Customer{
  int ID;
  int arrivalTime;
  int waitTime;
  
  public Customer(int ID, int arrivalTime){
    this.ID = ID;
    this.arrivalTime = arrivalTime;
  }
  
  public String toString() {
    return("Customer: "+ ID + " ");
  }
  
  public int getArrivalTime() {
    return this.arrivalTime;
  }
  
}