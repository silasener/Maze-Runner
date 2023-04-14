import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics2D;

public class Robot1 {
    private Robot1 sol;
    private Robot1 sag;
    private Robot1 asagi;
    private Robot1 yukari;
    private int xkoord;
    private int ykoord;
    private final int genislik = 35;
    private final int yukseklik = 35;
    private Color dugumrengi = Color.LIGHT_GRAY;

    public Robot1(int xkoord, int ykoord) {
        this.xkoord = xkoord;
        this.ykoord = ykoord;
    }

    public void yonbulmalabirent(Robot1 sol, Robot1 sag, Robot1 yukari, Robot1 asagi){
        this.sol=sol;
        this.sag=sag;
        this.yukari=yukari;
        this.asagi=asagi;
    }

    public List<Robot1> komsubul(){
        List<Robot1> komsular=new ArrayList<>();
        if(sol!=null && sol.yolmu())
            komsular.add(sol);
        if(asagi!=null && asagi.yolmu())
            komsular.add(asagi);
        if(sag!=null && sag.yolmu())
            komsular.add(sag);
        if(yukari!=null && yukari.yolmu())
            komsular.add(yukari);
        return komsular;
    }

    public static double uzaklik(Robot1 konum1, Robot1 konum2){
        double x_uzaklik=Math.pow(konum1.xkoord-konum2.xkoord,2 );
        double y_uzaklik=Math.pow(konum1.ykoord- konum2.ykoord,2);

        return Math.sqrt(x_uzaklik+y_uzaklik);
    }

    public void renderal(Graphics2D grafik){
        grafik.setColor(Color.BLACK);
        grafik.drawRect(xkoord,ykoord,genislik,yukseklik);
        grafik.setColor(dugumrengi);
        grafik.fillRect(xkoord+1,ykoord+1,genislik-1,yukseklik-1);
    }


    public void dugumtemizle(){ dugumrengi=Color.LIGHT_GRAY;}

    public boolean engelmi(){ return (dugumrengi==Color.BLACK);}

    public boolean baslangicmi(){return (dugumrengi==Color.GREEN);}
    public boolean bitismi(){return(dugumrengi==Color.red);}
    public boolean yolmu(){return (dugumrengi==Color.LIGHT_GRAY || dugumrengi==Color.red);}
    public boolean izlenenyolmu(){return(dugumrengi==Color.BLUE || dugumrengi==Color.ORANGE);}



    public int getX(){return(xkoord-15)/genislik;}
    public Robot1 setX(int x){ xkoord=x; return this; }
    public int getY(){return (ykoord-15)/yukseklik;}
    public Robot1 setY(int y){ ykoord=y; return this; }

    public Robot1 getSol() {
        return sol;
    }

    public void setSol(Robot1 sol) {
        this.sol = sol;
    }

    public Robot1 getSag() {
        return sag;
    }

    public void setSag(Robot1 sag) {
        this.sag = sag;
    }

    public Robot1 getAsagi() {
        return asagi;
    }

    public void setAsagi(Robot1 asagi) {
        this.asagi = asagi;
    }

    public Robot1 getYukari() {
        return yukari;
    }

    public void setYukari(Robot1 yukari) {
        this.yukari = yukari;
    }

    public int getXkoord() {
        return xkoord;
    }

    public void setXkoord(int xkoord) {
        this.xkoord = xkoord;
    }

    public int getYkoord() {
        return ykoord;
    }

    public void setYkoord(int ykoord) {
        this.ykoord = ykoord;
    }

    public int getGenislik() {
        return genislik;
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public Color getDugumrengi() {
        return dugumrengi;
    }
    public void setDugumrengi(Color dugumrengi) {
        this.dugumrengi = dugumrengi;
    }


}
