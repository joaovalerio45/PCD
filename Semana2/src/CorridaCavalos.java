import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CorridaCavalos {
  
    private JFrame frame;
    private List<Cavalo> cavalos;

    public CorridaCavalos(){
        frame = new JFrame();

        cavalos = new ArrayList<>();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        
    }

    public void addCavalo(Cavalo cavalo){
        cavalos.add(cavalo);
    }

    public void open(){
        setComponents();
        frame.setVisible(true);
    }

    public void terminarCorrida(Cavalo cavalo){
        for(Cavalo c : cavalos){
            c.interrupt();
        }
        JDialog endgame = new JDialog(frame, "Fim da Corrida");
        endgame.add(new JLabel("Ganhou o cavalo " + cavalo.getCavaloName()));

        endgame.setLayout(new FlowLayout());

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> endgame.dispose());
        endgame.add(okButton);

        endgame.setSize(250, 80);

        endgame.setLocationRelativeTo(frame);
        endgame.setVisible(true);
    }
    public void setComponents(){

        frame.setLayout(new FlowLayout());
        frame.setTitle("Corrida de cavalos");
        frame.setSize(new Dimension(300,100));

        for(Cavalo cavalo : cavalos){
            frame.add(cavalo.getTextField());
        }

        JButton startButton = new JButton();
        startButton.setText("Iniciar");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Cavalo cavalo : cavalos){
                    cavalo.start();
                }
            }
            
        });
        frame.add(startButton);
    }

    public static void main(String[] args) {
		CorridaCavalos corrida = new CorridaCavalos();
        corrida.addCavalo(new Cavalo("A", corrida));
        corrida.addCavalo(new Cavalo("B", corrida));
        corrida.addCavalo(new Cavalo("C", corrida));

        corrida.open();
	}
}
