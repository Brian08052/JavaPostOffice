class QueueOfCustomers{
    Customer[] que;
    int head = 0;
    int tail = 0;
    int size = 0;
    int capacity;
    
    
    public QueueOfCustomers(int capacity){
        this.capacity = capacity;
        que = new Customer[this.capacity];
    }
    
    public int length(){
      return this.size;
    }
    
    public boolean isEmpty(){
      if (size == 0){
	return true;
      }
      else{
        return false;
      }
    }
    
    public boolean isFull(){
      if (size == capacity){
        return true;
      }
      else{
        return false;
      }
    }
       
    public void insert(Customer item){
      if (!isFull()){
	if (tail == capacity){
	  que[0] = item;
	  tail = 1;
	  }
	else{
	  que[tail] = item;
	  tail++;
	}
	size += 1;
      }
    }
    
    public Customer getFront(){
      return que[head];
    }
      
    public void remove(){
      if (!isEmpty()){
        //System.out.println("(queue): Removing Customer " + que[head].ID + ", Queue Length: " + (this.size -1));
	que[head] = null;
	head += 1;
	this.size -= 1;
	if(head == capacity){
	  head = 0;
	}
	
      }
    }
    
    public String toString() {
        String output = "Head = " + this.head + " Tail = " + this.tail + "\nQueue: [ ";
        /**int index = 0;
        for(int n = 0; n < this.capacity; ++n){
           
           output += (que[index]);
           index++;
           //if(index == capacity){index = 0;}
	   
	}*/
	String output2 = "Queue: [ ";
        int index = head;
        for(int n = 0; n < this.size; ++n){
           if(index == capacity){index = 0;}
           output2 += (que[index]);
           index++;
        }
        return(output2 + "]" );
	   
	    }
	
	  
}