public class Contador{
    
    private int valor;

    public Contador(int valor){
        this.valor = valor;
    }

    public int getValor(){
        return this.valor;
    }

    public void incrementValor(int increment){
        this.valor += increment;
    }

}