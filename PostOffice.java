

class PostOffice{
  double probabilityOfArrival;
  int IDindex = 0;
  int time = 0;
  boolean isVerbose;
  int period;
  
  int served = 0;
  int turnedAway = 0;
  int totalCustomers = 0;
  
  int busyTime = 0;
  int idleTime = 0;
  int[] queueTimes;
  
  QueueOfCustomers q;
  ServicePosition sp;
  
  public PostOffice(int capacity, double probabilityOfArrival, int minServiceTime,
  int maxServiceTime){
      q = new QueueOfCustomers(capacity);
      sp = new ServicePosition(minServiceTime, maxServiceTime);
      this.probabilityOfArrival = probabilityOfArrival;
  }

 
  public static void main(String[] args) {
        /* Create a post office in which
            - queue capacity is 4
            - probability of arrival is 0.6
            - min serving time is 1
            - max serving time is 5
         */ 
        PostOffice po = new PostOffice(4, 0.6, 1, 5);
        
        /* Run the simulation
            - for a period of 15 mins
            - in verbose mode (hence lots of output)
         */
        po.run(20, true);
        
        /* Display stats
         */
        po.displayStats();
    }
    
    private void addCustomer(QueueOfCustomers q){
      System.out.println("Adding Customer " + this.IDindex + ", New Queue length: " + (q.size + 1));
      //System.out.println(q);
      Customer c = new Customer(this.IDindex, this.time);
      if(q.isFull()){
        turnedAway++;
        //System.out.println("No Room in the Inn tongiht");
        
      }
      else{
        //System.out.println("Adding... " + c + " size: " + q.size);
        q.insert(c);
        IDindex++;
        totalCustomers++;}
        //System.out.println("Added... " + c + " size: " + q.size);
        //System.out.println(q);
    } 
      
      
    
    private void nextPlease(QueueOfCustomers q, ServicePosition sp){
      
      if(q.getFront() != null){
        busyTime++;
        Customer c = q.getFront();
        System.out.println("Calling Customer " + c.ID);
        q.remove();
        sp.setCurrentCustomer(c);
        sp.setServiceTime();
        //System.out.println("Setting Service Time to " + sp.serviceTime);
        //System.out.println("reducing time by 1");
        sp.serviceTime -= 1;
      }
    }
    
    
    private void run(int period, boolean isVerbose){
      this.period = period;
      this.isVerbose = isVerbose; //dont know if necessary
      queueTimes = new int[period]; //doesnt need to be that long
      
      for (int i = 0; i < period; ++i){

	
	if(this.sp.currentCustomer != null){
	  if(this.sp.serviceTime<1){
	    int aT = sp.currentCustomer.getArrivalTime();
	    int waitTime = this.time - aT;
	    queueTimes[waitTime]++;

	    sp.removeCurrentCustomer();
	    served++;
	    nextPlease(q, sp);
	    
	  }
	  else{
	    //System.out.println("reducing time by 1");
	    sp.serviceTime -= 1;
	  }
	}
	
	else{
	  nextPlease(q, sp);
	}
	
	if(this.sp.currentCustomer != null){
	  busyTime++;
	} else {
	  idleTime++;
	}
	
	if(Math.random() < probabilityOfArrival){
	  addCustomer(q);
	}
	
    
    
        time++;
        if(isVerbose){
            //System.out.println("\n");
            System.out.println("Time: " + this.time);
            System.out.println(sp);
            System.out.println(q);
            //System.out.println("Customer requires " + sp.serviceTime + " minutes");
            //System.out.println("Queue Size: " + q.size);
            System.out.println("=====================================================================================================");
        
        }
    //still in queue = queue.size
      }
    }
      
      private void displayStats(){
        System.out.println("STATISTICS \n");
        System.out.println("Total Customers: " + totalCustomers);
        System.out.println("Turned away: " + turnedAway);
        System.out.println("Still in queue: " + q.length());
        System.out.println("Service Position idle time: " + idleTime);
        System.out.println("Service Position busy time: " + busyTime);
        System.out.println("Waiting Times \n");
        for(int i = 0; i < period; ++i){
          String qTime = " ";
          for(int j = 0; j < queueTimes[i]; ++j){
            qTime += "*";}
          System.out.println(i + " " + qTime);
        
        }
      }
        
        
        
      
      }

    
    