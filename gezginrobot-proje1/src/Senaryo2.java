import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Senaryo2 extends Canvas implements Runnable{
    private static Robot2 start = null;
    private static Robot2 target = null;
    private static JFrame frame;
    private Robot2[][] nodeList;
    private static Senaryo2 runTimeMain;
    private static Uygulama2 algorithm;
    private String yeniboyut;
    private final static int WIDTH = 1024;
    private final static int HEIGHT = 1024;
    public boolean yeniizgara=false;

    public void senaryo2calistir(){

        if(yeniizgara==false){
            Izgara2.RandomUretmeYAzdirma(Integer.parseInt(gezginRoborGUİ.getSenaryo2boyut()));
        }

        frame = new JFrame("GEZGİN ROBOT-SENARYO-2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLayout(null);
        Senaryo2 m = new Senaryo2();
        algorithm =  new Uygulama2();
        m.setBounds(0, 25, WIDTH, HEIGHT);
        setupMenu2(frame);
        runTimeMain = m;
        frame.add(m);
        frame.setVisible(true);
        m.start();
}

    private void setupMenu2(JFrame frame) {
        JMenuBar bar = new JMenuBar();
        bar.setBounds(0, 0, WIDTH, 25);
        frame.add(bar);
        JMenu labirent_izgarasi = new JMenu("Labirent");
        bar.add(labirent_izgarasi);
        JMenu yeni_lab = new JMenu("Yeni Izgara");
        bar.add(yeni_lab);
        JMenu algoritma = new JMenu("İşlemler");
        bar.add(algoritma);
        JMenu karesonuclar =new JMenu("Taranan Kare Bilgileri");
        bar.add(karesonuclar);
        JMenu suresonuclar=new JMenu("Süre Bilgileri");
        bar.add(suresonuclar);
        JMenu geri=new JMenu("Menü");
        bar.add(geri);

        JMenuItem labirenti_olustur = new JMenuItem("Labirent Oluştur");

        JMenuItem yeni_izgara = new JMenuItem("Labirent Değiştir");

        JMenuItem astar_algoritmasi = new JMenuItem("Çalıştır (A-star Alg)");
        JMenuItem aramasuresi = new JMenuItem("Hareket Hızı (ms)");

        JMenuItem toplamsure =new JMenuItem("Total Süre");
        JMenuItem suresonuc=new JMenuItem("Hedefe Ulaşmak İçin Geçen Süre");
        JMenuItem kisayolhesaplamasuresi=new JMenuItem("Kısa Yol Bulmak İçin Geçen Süre");

        JMenuItem karesonuc=new JMenuItem("Gezilen Kare Sayısı");
        JMenuItem kisayolkaresayisi=new JMenuItem("Kısa Yol Kare Sayısı");

        JMenuItem menuyedon = new JMenuItem("Menü");


        labirenti_olustur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    runTimeMain.labirentiolustur();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        karesonuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(suresonuclar, "Gezilen Toplam Kare Sayısı: "+Uygulama2.getToplamgezilenkare());
                System.out.println("Gezilen Toplam Kare Sayısı: "+Uygulama2.getToplamgezilenkare());
            }
        });

        suresonuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(suresonuclar, "Hedefe Ulaşmak İçin Geçen Süre: "+Uygulama2.getGecensaniye());
                System.out.println("Hedefe Ulaşmak İçin Geçen Süre: "+Uygulama2.getGecensaniye());
            }
        });
        kisayolkaresayisi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(suresonuclar, "Kısa Yoldaki Kare Sayısı: "+Uygulama2.getKisayolkaresayisi());
                System.out.println("Kısa Yoldaki Kare Sayısı: "+Uygulama2.getKisayolkaresayisi());
            }
        });

        toplamsure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(karesonuclar, "Toplam Süre: "+(Uygulama2.getKygecensaniye()+Uygulama2.getGecensaniye()));
                System.out.println("Toplam Süre: "+(Uygulama2.getKygecensaniye()+Uygulama2.getGecensaniye()));
            }
        });


        kisayolhesaplamasuresi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(karesonuclar, "Kısa Yol Bulmak İçin Geçen Süre: "+Uygulama2.getKygecensaniye());
                System.out.println("Kısa Yol Bulmak İçin Geçen Süre:: "+Uygulama2.getKygecensaniye());
            }
        });

        menuyedon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("\n\nMENÜYE DÖNÜLÜYOR");
                frame.setVisible(false);
                gezginRoborGUİ gezginRoborGUİ=new gezginRoborGUİ();
            }
        });

        yeni_izgara.addActionListener(new ActionListener() { //yeni ızgara oluşturma
            public void actionPerformed(ActionEvent arg0) {
                yeniizgara=true;
                try {
                    getRunTimeMain().init();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }//runTimeMain.dugumolustur(true);
                Uygulama2.setGecensaniye(0);
                Uygulama2.setKisayolkaresayisi(0);
                Uygulama2.setToplamgezilenkare(0);
                yeniboyut= JOptionPane.showInputDialog(null, "Boyut Giriniz", "Matris Boyutu Alma", JOptionPane.QUESTION_MESSAGE);
                Izgara2.RandomUretmeYAzdirma(Integer.parseInt(getYeniboyut()));
                System.out.println("\n\nYeni Izgara Oluşuturuluyor");
                frame.setVisible(false);
                senaryo2calistir();
            }
        });



        astar_algoritmasi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (runTimeMain.isMazeValid()) {
                    try {
                        algorithm.AStar_alg(runTimeMain.start, runTimeMain.target, Izgara2.getBoyut2(), Izgara2.getBoyut2());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("HATA");
                }

            }
        });


        aramasuresi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String input = JOptionPane.showInputDialog(null, "Robotun hareket hızını milisaniye cinsinden giriniz", "Hareket Hızı", JOptionPane.QUESTION_MESSAGE);
                algorithm.setAramasuresi(Integer.parseInt(input));
            }
        });

        labirent_izgarasi.add(labirenti_olustur);
        geri.add(menuyedon);
        yeni_lab.add(yeni_izgara);
        algoritma.add(astar_algoritmasi);
        algoritma.add(aramasuresi);
        karesonuclar.add(karesonuc);
        karesonuclar.add(kisayolkaresayisi);
        suresonuclar.add(toplamsure);
        suresonuclar.add(suresonuc);
        suresonuclar.add(kisayolhesaplamasuresi);

    }


    @Override
    public void run() {
        try {
            init();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            BufferStrategy bs = getBufferStrategy();
            if (bs == null) {
                createBufferStrategy(2);
                continue;
            }
            Graphics2D grap = (Graphics2D) bs.getDrawGraphics();
            render(grap);
            bs.show();
            try {
                Thread.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void init() throws FileNotFoundException {
        requestFocus();
        nodeList = new Robot2[Izgara2.getBoyut2()][Izgara2.getBoyut2()];
        dugumolustur(false);
        labirentyonuayarla();
    }

    public void labirentyonuayarla() throws FileNotFoundException {
        for (int i = 0; i < nodeList.length; i++) {
            for (int j = 0; j < nodeList[i].length; j++) {
                Robot2 up = null,down = null,left = null,right = null;
                int u = j - 1;
                int d = j + 1;
                int l = i - 1;
                int r = i + 1;

                if(u >= 0) up = nodeList[i][u];
                if(d < Izgara2.getBoyut2()) down =  nodeList[i][d];
                if(l >= 0) left = nodeList[l][j];
                if(r < Izgara2.getBoyut2()) right =  nodeList[r][j];

                nodeList[i][j].yonbulmalabirent(left, right, up, down);
            }
        }
    }

    public void dugumolustur(boolean ref) {
        System.out.println("IZGARA BOYUTU: "+nodeList.length+"x"+ nodeList.length);
        for (int i = 0; i < nodeList.length; i++) {
            for (int j = 0; j < nodeList[i].length; j++) {
                if(!ref) nodeList[i][j] = new Robot2(i, j).setX(15 + i * 35).setY(15 + j * 35);
                nodeList[i][j].dugumtemizle();
            }
        }
    }

    public void labirentiolustur() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(Izgara2.getPath()));
        System.out.println("Random Labirent Oluşturuluyor");
        String line = null;
        for (int i = 0; i < Izgara2.getBoyut2(); i++) {
            line = reader.readLine();
            System.out.println(line);
            for (int j = 0; j < Izgara2.getBoyut2(); j++) {

                int karaktertipi = Character.getNumericValue(line.charAt(j));

                switch (karaktertipi) {
                    case 0:
                        nodeList[j][i].setDugumrengi(Color.LIGHT_GRAY);
                        break;
                    case 1:
                        nodeList[j][i].setDugumrengi(Engel1.getEngel1());
                        break;

                    case 2:
                        nodeList[j][i].setDugumrengi(Engel1.getEngel2());
                        break;
                    case 3:
                        nodeList[j][i].setDugumrengi(Engel1.getEngel3());
                        break;
                }
                nodeList[0][0].setDugumrengi(Color.GREEN);
                start = nodeList[0][0];
                nodeList[Izgara2.getBoyut2()-1][Izgara2.getBoyut2()-1].setDugumrengi(Color.red);
                target = nodeList[Izgara2.getBoyut2()-1][Izgara2.getBoyut2()-1];
            }
        }
        reader.close();
    }


    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (int i = 0; i < nodeList.length; i++) {
            for (int j = 0; j < nodeList[i].length; j++) {
                nodeList[i][j].renderal(g);
            }
        }
    }

    public void start() {
        new Thread(this).start(); //kontrol
        }

    public boolean isMazeValid() {  return target == null ? false : true && start == null ? false : true; }

    public static Senaryo2 getRunTimeMain() { return runTimeMain; }

    public static void setRunTimeMain(Senaryo2 runTimeMain) { Senaryo2.runTimeMain = runTimeMain; }
    public String getYeniboyut() {return yeniboyut;}

    public void setYeniboyut(String yeniboyut) {this.yeniboyut = yeniboyut;}

    public static Robot2 getStart() {return start;}

    public static void setStart(Robot2 start) {Senaryo2.start = start;}

    public static Robot2 getTarget() {return target;}

    public static void setTarget(Robot2 target) {Senaryo2.target = target;}

    public static JFrame getFrame() {return frame;}

    public static void setFrame(JFrame frame) {Senaryo2.frame = frame;}

    public Robot2[][] getNodeList() {return nodeList;}

    public void setNodeList(Robot2[][] nodeList) {this.nodeList = nodeList;}

    public static Uygulama2 getAlgorithm() {return algorithm;}

    public static void setAlgorithm(Uygulama2 algorithm) {Senaryo2.algorithm = algorithm;}

    public boolean isYeniizgara() {return yeniizgara;}

    public void setYeniizgara(boolean yeniizgara) {this.yeniizgara = yeniizgara;}
}
