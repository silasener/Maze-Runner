import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Robot2 {
    private Robot2 sol;
    private Robot2 sag;
    private Robot2 asagi;
    private Robot2 yukari;
    private int xkoord;
    private int ykoord;
    private final int genislik = 35;
    private final int yukseklik = 35;

    private Color dugumrengi = Color.LIGHT_GRAY;

    public Robot2(int xkoord, int ykoord) {
        this.xkoord = xkoord;
        this.ykoord = ykoord;
    }
    public void yonbulmalabirent(Robot2 sol, Robot2 sag, Robot2 yukari, Robot2 asagi){
        this.sol=sol;
        this.sag=sag;
        this.yukari=yukari;
        this.asagi=asagi;
    }

    public List<Robot2> komsubul(){
        List<Robot2> komsular=new ArrayList<>();
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

    public static double uzaklik(Robot2 konum1, Robot2 konum2){
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
    public Robot2 setX(int x){ xkoord=x; return this; }
    public int getY(){return (ykoord-15)/yukseklik;}
    public Robot2 setY(int y){ ykoord=y; return this; }

    public Robot2 getSol() {
        return sol;
    }

    public void setSol(Robot2 sol) {
        this.sol = sol;
    }

    public Robot2 getSag() {
        return sag;
    }

    public void setSag(Robot2 sag) {
        this.sag = sag;
    }

    public Robot2 getAsagi() {
        return asagi;
    }

    public void setAsagi(Robot2 asagi) {
        this.asagi = asagi;
    }

    public Robot2 getYukari() {
        return yukari;
    }

    public void setYukari(Robot2 yukari) {
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
