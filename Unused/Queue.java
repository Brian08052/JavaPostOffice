class QueueOfCustomers{
    Customer[] que;
    int head = 0;
    int tail = 0;
    int size = 0;
    int capacity;
    
    
    public Queue(int capacity){
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
	  tail = 0;
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
	que[head] = null;
	head += 1;
	if(head == capacity){
	  head = 0;
	}
	this.size -= 1;
      }
    }
}