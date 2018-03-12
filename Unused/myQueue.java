class myQueue{
    Integer[] que;
    int head = 0;
    int tail = 0;
    int size = 0;
    int capacity;
    
    
    public myQueue(int capacity){
        this.capacity = capacity;
        que = new Integer[this.capacity];
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
       
    public void insert(int item){
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
    
    public Integer getFront(){
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