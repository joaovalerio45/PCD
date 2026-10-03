class MainNameThread {
    public static void main(String[] args){

        NameThread nt1 = new NameThread("nt1");

        NameThread nt2 = new NameThread("nt2");

        nt1.start();
        nt2.start();

        try {
            nt1.join();
            nt2.join();
        } catch (InterruptedException e) {
            
            return;
        }
        System.out.println("Main acabou de correr.");
        
    }
}
