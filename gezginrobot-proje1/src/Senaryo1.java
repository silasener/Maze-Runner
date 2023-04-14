import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Senaryo1 extends Canvas implements Runnable {

    private static int pathsayaci=0;
    private static Robot1 start = null;
    private static Robot1 target = null;
    private static JFrame frame;
    private Robot1[][] nodeList;
    private static Senaryo1 runTimeMain;
    private static Uygulama1 algorithm;
    private final static int WIDTH = 1024;
    private final static int HEIGHT = 1024;
   private static List<Object> random_start_target=new ArrayList<Object>();


    public void senaryo1calistir(){

        frame = new JFrame("GEZGİN ROBOT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setLayout(null);
        Senaryo1 m = new Senaryo1();
        algorithm =  new Uygulama1();
        m.setBounds(0, 25, WIDTH, HEIGHT);
        SetupMenu(frame);
        runTimeMain = m;
        frame.add(m);
        frame.setVisible(true);
        m.start();

    }

    public static void SetupMenu(JFrame frame) {
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

        JMenuItem yeni_izgara = new JMenuItem("URL Değiştir");

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
                JOptionPane.showMessageDialog(karesonuclar, "Gezilen Toplam Kare Sayısı: "+Uygulama1.getToplamgezilenkare());
                System.out.println("Gezilen Toplam Kare Sayısı: "+Uygulama1.getToplamgezilenkare());
            }
        });

        suresonuc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(karesonuclar, "Hedefe Ulaşmak İçin Geçen Süre: "+Uygulama1.getGecensaniye());
                System.out.println("Hedefe Ulaşmak İçin Geçen Süre: "+Uygulama1.getGecensaniye());
            }
        });

        kisayolkaresayisi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(karesonuclar, "Kısa Yoldaki Kare Sayısı: "+Uygulama1.getKisayolkaresayisi());
                System.out.println("Kısa Yoldaki Kare Sayısı: "+Uygulama1.getKisayolkaresayisi());
            }
        });

        kisayolhesaplamasuresi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(karesonuclar, "Kısa Yol Bulmak İçin Geçen Süre: "+Uygulama1.getKygecensaniye());
                System.out.println("Kısa Yol Bulmak İçin Geçen Süre:: "+Uygulama1.getKygecensaniye());
            }
        });
       toplamsure.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JOptionPane.showMessageDialog(karesonuclar, "Toplam Süre: "+(Uygulama1.getKygecensaniye()+Uygulama1.getGecensaniye()));
                System.out.println("Toplam Süre: "+(Uygulama1.getKygecensaniye()+Uygulama1.getGecensaniye()));
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
                random_start_target.clear();
                pathsayaci++;
                System.out.println("\n\nURL DEĞİŞTİRİLİYOR YENİ IZGARA OLUŞTURULUYOR");
                try {
                    getRunTimeMain().init();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }//runTimeMain.dugumolustur(true);
                Uygulama1.setGecensaniye(0);
                Uygulama1.setKisayolkaresayisi(0);
                Uygulama1.setToplamgezilenkare(0);
            }
        });


        astar_algoritmasi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (runTimeMain.baslangic_ve_hedef_varmi()) {
                    try {
                        algorithm.AStar_alg(runTimeMain.start, runTimeMain.target, Izgara1.getBoyut(), Izgara1.getBoyut());
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
        nodeList = new Robot1[Izgara1.getBoyut()][Izgara1.getBoyut()];
        dugumolustur(false);
        labirentyonuayarla();
    }

    public void labirentyonuayarla() throws FileNotFoundException {
        for (int i = 0; i < nodeList.length; i++) {
            for (int j = 0; j < nodeList[i].length; j++) {
                Robot1 up = null,down = null,left = null,right = null;
                int u = j - 1;
                int d = j + 1;
                int l = i - 1;
                int r = i + 1;

                if(u >= 0) up = nodeList[i][u];
                if(d < Izgara1.getBoyut()) down =  nodeList[i][d];
                if(l >= 0) left = nodeList[l][j];
                if(r < Izgara1.getBoyut()) right =  nodeList[r][j];

                nodeList[i][j].yonbulmalabirent(left, right, up, down);
            }
        }
    }

    public void dugumolustur(boolean ref) {
        System.out.println("IZGARA BOYUTU: "+nodeList.length+"x"+ nodeList.length);
        for (int i = 0; i < nodeList.length; i++) {
            for (int j = 0; j < nodeList[i].length; j++) {
                if(!ref) nodeList[i][j] = new Robot1(i, j).setX(15 + i * 35).setY(15 + j * 35);
                nodeList[i][j].dugumtemizle();
            }
        }
    }


    public void labirentiolustur() throws IOException {

        if(pathsayaci%2==0){ //okunması gereken path1 ise (txt1)
            System.out.println("Okunan Uzantı: "+Izgara1.getPath1());
            BufferedReader reader = new BufferedReader(new FileReader(Izgara1.getPath1()));
            String line = null;
            for (int i = 0; i < Izgara1.getBoyut(); i++) {
                line = reader.readLine();
                System.out.println(line);
                for (int j = 0; j < Izgara1.getBoyut(); j++) {

                    int karaktertipi_1 = Character.getNumericValue(line.charAt(j));

                    switch (karaktertipi_1) {
                        case 0:
                            nodeList[j][i].setDugumrengi(Color.LIGHT_GRAY);
                            random_start_target.add(nodeList[j][i]);
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
                }
            }
            Random start_target=new Random();
            int start_konum=start_target.nextInt(random_start_target.size());
            start = (Robot1) random_start_target.get(start_konum);
            start.setDugumrengi(Color.GREEN);
            int finish_konum=start_target.nextInt(random_start_target.size());
            while (finish_konum==start_konum){
                finish_konum=start_target.nextInt(random_start_target.size());
            }
            System.out.println("Başlangıç Konumu: "+start_konum+"\nBitiş Konumu: "+finish_konum);
            target =(Robot1) random_start_target.get(finish_konum);
            target.setDugumrengi(Color.red);
            reader.close();
        }

        else if(pathsayaci%2==1){ //okunması gereken path2 ise (txt2)
            System.out.println("Okunan Uzantı: "+Izgara1.getPath2());
            BufferedReader reader = new BufferedReader(new FileReader(Izgara1.getPath2()));
            String line = null;
            for (int i = 0; i < Izgara1.getBoyut(); i++) {
                line = reader.readLine();
                System.out.println(line);
                for (int j = 0; j < Izgara1.getBoyut(); j++) {

                    int karaktertipi_2 = Character.getNumericValue(line.charAt(j));

                    switch (karaktertipi_2) {
                        case 0:
                            nodeList[j][i].setDugumrengi(Color.LIGHT_GRAY);
                            random_start_target.add(nodeList[j][i]);
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
                }
            }
            Random start_target=new Random();
            int start_konum=start_target.nextInt(random_start_target.size());
            start = (Robot1) random_start_target.get(start_konum);
            start.setDugumrengi(Color.GREEN);
            int finish_konum=start_target.nextInt(random_start_target.size());
            while (finish_konum==start_konum){ //başlangıç ve bitiş aynı nokta olmaması için kontrol
                finish_konum=start_target.nextInt(random_start_target.size());
            }
            System.out.println("Başlangıç Konumu: "+start_konum+"\nBitiş Konumu: "+finish_konum);
            target =(Robot1) random_start_target.get(finish_konum);
            target.setDugumrengi(Color.red);
            reader.close();
        }

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
        new Thread(this).start();
    }
    public boolean baslangic_ve_hedef_varmi() {
        return target == null ? false : true && start == null ? false : true;
    }


    public static Robot1 getStart() {
        return start;
    }

    public static void setStart(Robot1 start) {
        Senaryo1.start = start;
    }

    public static Robot1 getTarget() {
        return target;
    }

    public static void setTarget(Robot1 target) {
        Senaryo1.target = target;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        Senaryo1.frame = frame;
    }

    public Robot1[][] getNodeList() {
        return nodeList;
    }

    public void setNodeList(Robot1[][] nodeList) {
        this.nodeList = nodeList;
    }

    public static Senaryo1 getRunTimeMain() {
        return runTimeMain;
    }

    public static void setRunTimeMain(Senaryo1 runTimeMain) {
        Senaryo1.runTimeMain = runTimeMain;
    }

    public static Uygulama1 getAlgorithm() {
        return algorithm;
    }

    public static void setAlgorithm(Uygulama1 algorithm) {
        Senaryo1.algorithm = algorithm;
    }

    public static int getPathsayaci() {
        return pathsayaci;
    }

    public static void setPathsayaci(int pathsayaci) {
        Senaryo1.pathsayaci = pathsayaci;
    }

    public List<Object> getRandom_start_target() {
        return random_start_target;
    }

    public void setRandom_start_target(List<Object> random_start_target) {this.random_start_target = random_start_target;}
}