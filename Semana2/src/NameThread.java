public class NameThread extends Thread {
    
    private String name;

    public NameThread(String name){
        this.name = name;
    }
    
    @Override 
    public void run(){
        for (int i = 0 ; i < 10; i++){
            System.out.println("Sou a thread " + name + "e estou no ciclo" + i);
            Long sleepDuration = (long) ((Math.random() + 1) * 1000);
            try {
                sleep(sleepDuration);
            } catch (InterruptedException e) {
                System.out.println("Sou a thread " + name + " e fui interronpida");
                return;
            }
        }
    }
}
