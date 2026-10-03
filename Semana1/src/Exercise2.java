import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
//codeshare.io/gq0Qmq
class Exercise2 {
  
    private JFrame frame;
    File[] files;

    public Exercise2(){
        frame = new JFrame("Photos");

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
        frame.setLayout(new BorderLayout());

        JLabel textLabel = new JLabel();


        JLabel imageLabel = new JLabel();

        JButton backButton = new JButton("<");
        backButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){

            }
        });

        JButton forwardButton = new JButton(">");
        forwardButton.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                
            }
        });

        frame.add(imageLabel, BorderLayout.CENTER);
        frame.add(backButton, BorderLayout.WEST);
        frame.add(forwardButton, BorderLayout.EAST);
        frame.add(textLabel, BorderLayout.NORTH);
    }

    public void readFilePath(String path){
        files = new File(path).listFiles(new FileFilter() {
        public boolean accept(File f) {    
            return true;
            }
        });

    }

    public static void main(String[] args) {

        Exercise2 frame = new Exercise2();
        frame.readFilePath("imagens");
        frame.open();

    }

}
