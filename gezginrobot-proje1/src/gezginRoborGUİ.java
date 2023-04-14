import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gezginRoborGUİ extends JFrame{
    private JPanel Mainpanel;
    private JButton SENARYO1Button;
    private JButton SENARYO2Button;
    private static String senaryo2boyut;

    public gezginRoborGUİ() {
        
            setContentPane(Mainpanel);
            setTitle("GEZGİN-ROBOT");
            setSize(500,400);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);

            SENARYO1Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Senaryo-1 Çalıştırılıyor");
                    setVisible(false);
                    new Senaryo1().senaryo1calistir();
                }
            });


            SENARYO2Button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    senaryo2boyut= JOptionPane.showInputDialog(null, "Boyut Giriniz", "Matris Boyutu Alma", JOptionPane.QUESTION_MESSAGE);
                    System.out.println("Senaryo-2 Çalıştırılıyor");
                    setVisible(false);
                    new Senaryo2().senaryo2calistir();
                }
            });
        }



    public JPanel getMainpanel() {
        return Mainpanel;
    }

    public void setMainpanel(JPanel mainpanel) {
        Mainpanel = mainpanel;
    }

    public JButton getSENARYO1Button() {
        return SENARYO1Button;
    }

    public void setSENARYO1Button(JButton SENARYO1Button) {
        this.SENARYO1Button = SENARYO1Button;
    }

    public JButton getSENARYO2Button() {
        return SENARYO2Button;
    }

    public void setSENARYO2Button(JButton SENARYO2Button) {
        this.SENARYO2Button = SENARYO2Button;
    }
    public static String getSenaryo2boyut() {
        return senaryo2boyut;
    }

    public static void setSenaryo2boyut(String senaryo2boyut) {
        gezginRoborGUİ.senaryo2boyut = senaryo2boyut;
    }
}



