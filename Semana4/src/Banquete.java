import java.util.ArrayList;

public class Banquete {

    private ArrayList<Javali> mesa;
    private int maxSize;
    
    public Banquete(int maxSize){
        this.mesa = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public synchronized void adicionaJavali(Javali javali){
        while(mesa.size() >= maxSize){
            wait();
        }
        mesa.add(javali);
        notifyAll();
    }

    public synchronized Javali retiraJavali(){
        while(mesa.isEmpty()){
            wait();
        }
        Javali javali = mesa.get(0);
        mesa.remove(javali);
        notifyAll();
        return javali;
    }
}
