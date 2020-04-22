import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Igra {
    private JTextField pritisniDugmeTextField;
    private JButton a1Button;
    private JButton a3Button;
    private JButton a2Button;
    public JLabel label;
    public JPanel panel;
    private JLabel label2;

    public Igra(int a, int b, int c) {

       //Random random= new Random();
        //int a=random.nextInt(101);
        a1Button.setText(Integer.toString(a));

       // int b=random.nextInt(101);
        a2Button.setText(Integer.toString(b));

       // int c=random.nextInt(101);
        a3Button.setText(Integer.toString(c));


        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText("Pritisnuto je " + a1Button.getText() + "!");
                //  a1Button.setVisible(false);
                a1Button.setEnabled(false);

                if(!a1Button.isEnabled() && !a2Button.isEnabled() && !a3Button.isEnabled())
                    label2.setText("Sve je pritisnuto!");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText("Pritisnuto je " + a2Button.getText() + "!");
                // a2Button.setVisible(false);
                a2Button.setEnabled(false);

                if(!a1Button.isEnabled() && !a2Button.isEnabled() && !a3Button.isEnabled())
                    label2.setText("Sve je pritisnuto!");
            }
        });


        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                label.setText("Pritisnuto je " + a3Button.getText() + "!");
                //a3Button.setVisible(false);
                a3Button.setEnabled(false);

                if(!a1Button.isEnabled() && !a2Button.isEnabled() && !a3Button.isEnabled())
                    label2.setText("Sve je pritisnuto!");
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame= new JFrame("Igra");
        Random random= new Random();
        int x=random.nextInt(101);
        int y=random.nextInt(101);
        int z=random.nextInt(101);
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setContentPane(new Igra(x,y,z).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);


    }
}



