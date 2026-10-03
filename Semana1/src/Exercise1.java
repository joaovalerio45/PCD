import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Exercise1 {
  
    private JFrame frame;

    public Exercise1(){
        frame = new JFrame("Hello");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(300,150));

        addFrameContents();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                    int x = (screen.width - 300) / 2;
                    int y = (screen.height - 150) / 2;
                    frame.setLocation(x, y);

    }

    public void open(){

        frame.setVisible(true);
    }


    private void addFrameContents() {

        frame.setLayout(new GridLayout(4,4));

        JLabel label1 = new JLabel("title", SwingConstants.CENTER);
        frame.add(label1);

        JTextField textfield1 = new JTextField("Hello");
        textfield1.setHorizontalAlignment(JTextField.CENTER);
        frame.add(textfield1);

        JLabel label2 = new JLabel("width", SwingConstants.CENTER);
        frame.add(label2);
        
        JTextField textfield2 = new JTextField("300");
        textfield2.setHorizontalAlignment(JTextField.CENTER);
        frame.add(textfield2);

        JLabel label3 = new JLabel("height", SwingConstants.CENTER);
        frame.add(label3);

        JTextField textfield3 = new JTextField("150");
        textfield3.setHorizontalAlignment(JTextField.CENTER);
        frame.add(textfield3);

        JCheckBox checkbox1 = new JCheckBox("center");
        checkbox1.setHorizontalAlignment(SwingConstants.CENTER);

        JButton button1 = new JButton("update");
        button1.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                frame.setTitle(textfield1.getText());

                try{
                    int width = Integer.parseInt(textfield2.getText());
                    int height = Integer.parseInt(textfield3.getText());
                    frame.setSize(new Dimension(width, height));
                    
                    if (checkbox1.isSelected()) {
                        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                        int x = (screen.width - width) / 2;
                        int y = (screen.height - height) / 2;
                        frame.setLocation(x, y);
                    }
                }catch(Exception exception){
                    JOptionPane.showMessageDialog(button1, "O valor de altura e largura eram inválidos");
                }
                  

            }
        });
        frame.add(button1);
        frame.add(checkbox1);
    }

    public static void main(String[] args){
        Exercise1 window = new Exercise1();
        window.open();
        System.out.print(Toolkit.getDefaultToolkit().getScreenSize().toString());
    }

}
