

class PostOffice{
  double probabilityOfArrival;
  int IDindex = 0;
  int time = 0;
  
  int served = 0;
  int turnedAway = 0;
  int totalCustomers = 0;
  
  int busyTime = 0;
  int idleTime = 0;
  int[] queueTimes;
  
  public PostOffice(int capacity, double probabilityOfArrival, int minServiceTime,
  int maxServiceTime){
      QueueOfCustomers q = new QueueOfCustomers(capacity);
      ServicePosition sp = new ServicePosition(minServiceTime, maxServiceTime);
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
        po.run(15, true);
        
        /* Display stats
         */
        po.displayStats();
    }
    
    private void addCustomer(QueueOfCustomers q){
      Customer c = new Customer(this.IDindex, this.time);
      if(q.isFull()){
        turnedAway++;
      }
      else{
        q.insert(c);
        IDindex++;
        totalCustomers++;}
    }
    
    private void nextPlease(QueueOfCustomers q){
      if(q.getFront() != null){
        busyTime++;
        Customer c = q.getFront();
        q.remove();
        sp.setCurrentCustomer(c);
        
      }
      idleTime++;
    }
    
    
    private void run(int period, boolean isVerbose){
      queueTimes = new int[period]; //doesnt need to be that long
      for (int i = 0; i < period; ++i){
        //Thread.sleep(1000);
	
	
	if(sp.currentCustomer != null){
	  if(sp.serviceTime<1){
	    int aT = sp.currentCustomer.arivalTime;
	    int waitTime = this.time - aT;
	    queueTimes[waitTime]++;
	    
	    //array of length period; initialised at zero?
            //waitTime = this.time - c.arrivalTime
            //waitTimes[waitTime]++;
	    sp.removeCurrentCustomer();
	    served++;
	    nextPlease();
	    
	  }
	  busyTime++;
	  sp.serviceTime -= 1;
	}
	
	else{
	  nextPlease(q);
	}
	
	if(Math.random() < probabilityOfArrival){
	  addCustomer(q);
	}
	
    
    
        time++;
        if(verbose){
            System.out.println("Time: " + this.time);
            System.out.println(sp);
            System.out.println(q);
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
          for(int i = 0; i < queueTimes[i]; ++i){
            qTime += "*";}
          System.out.println(i + " " + qTime);
        
        }
      }
        
        
        
      
      }

    
    