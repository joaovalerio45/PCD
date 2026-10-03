import javax.swing.JTextField;

class Cavalo extends Thread{

    private int moves;
    private JTextField textField;
    private String name;
    CorridaCavalos corrida;

    public Cavalo(String name, CorridaCavalos corrida){
        this.moves = 30;
        this.textField = new JTextField();
        this.name = name;
        textField.setText(((Integer)(moves)).toString());
        this.corrida = corrida;
    }

    public JTextField getTextField(){
        return this.textField;
    }

    public int getMoves(){
        return this.moves;
    }

    public String getCavaloName(){
        return name;
    }

    @Override 
    public void run(){
        while(moves > 0){
            textField.setText(((Integer)(--moves)).toString());
            try {
                sleep((long)(Math.random() * 100));
            } catch (InterruptedException e) {
                System.out.print("O cavalo " + name + "foi interrompido.");
                return;
            }
        }
        corrida.terminarCorrida(this);

    }
  
}
