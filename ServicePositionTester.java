class ServicePositionTester {

    public static void main(String[] args) {
        
        ServicePosition sp = new ServicePosition(1, 3);
        Customer c1 = new Customer(1, 12);
        sp.setCurrentCustomer(c1);
        
        
        
        System.out.println(sp.serviceTime);
        System.out.println(sp);
        sp.setServiceTime();
        System.out.println(sp.serviceTime);
        sp.setServiceTime();
        System.out.println(sp.serviceTime);
        sp.setServiceTime();
        System.out.println(sp.serviceTime);
        sp.setServiceTime();
        System.out.println(sp.serviceTime);
        
        
        
    }
    
    
        
}