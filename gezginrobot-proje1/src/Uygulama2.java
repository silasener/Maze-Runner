import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Uygulama2 {
    private int aramasuresi=100;
    private   static int toplamgezilenkare;
    private static double gecensaniye;
    private static long  surebaslangici;
    private static long  surebitisi;
    private static long  gecenmilisaniye;
    private static int kisayolkaresayisi;

    private static long  kisayolsurebaslangici;
    private static long kisayolsurebitisi;
    private static long kisayolbulmasuresi;
    private static double kygecensaniye;

    private Robot2 gezilebilecekYollar(List<Robot2> yollistesi, Robot2 hedef, Robot2 baslangic){
        if(!yollistesi.isEmpty()){
            Robot2 gorulenyollistesi=yollistesi.get(0);
            for (int i = 1; i <yollistesi.size() ; i++) {
                double bitis1= Robot2.uzaklik(yollistesi.get(i),hedef);
                double gorulendevamyol1= Robot2.uzaklik(yollistesi.get(i),baslangic);

                double bitis2= Robot2.uzaklik(gorulenyollistesi,hedef);
                double gorulendevamyol2= Robot2.uzaklik(gorulenyollistesi,baslangic);
                if(bitis1+gorulendevamyol1 < bitis2+gorulendevamyol2){
                    gorulenyollistesi=yollistesi.get(i);
                }
            }
            return gorulenyollistesi;
        }
        return null;
    }


    public void kisayolbul(Robot2[][] onceki, Robot2 son_hedef){
        kisayolsurebaslangici=System.nanoTime();
        Robot2 yolyapimi=son_hedef;
        while (yolyapimi!=null){
            kisayolkaresayisi++;
            yolyapimi=onceki[yolyapimi.getX()][yolyapimi.getY()];

            if(yolyapimi!=null){
                yolyapimi.setDugumrengi(Color.ORANGE);
            }
            try {
                Thread.sleep(aramasuresi);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Kısa yoldaki kare sayısı: "+kisayolkaresayisi);
        kisayolsurebitisi=System.nanoTime();
        kisayolbulmasuresi=kisayolsurebitisi-kisayolsurebaslangici;
        kysurehesapla(kisayolbulmasuresi);
    }


    public void AStar_alg(Robot2 baslangic, Robot2 hedef, int l_genislik, int l_yukseklik){
        surebaslangici=System.nanoTime();
        toplamgezilenkare=0;
        List<Robot2> yollistesi=new ArrayList<>();
        Robot2[][] onceki=new Robot2[l_genislik][l_yukseklik];
        yollistesi.add(baslangic);

        while(!yollistesi.isEmpty()){
            Robot2 currentR=gezilebilecekYollar(yollistesi,hedef,baslangic);
            yollistesi.remove(currentR);
            toplamgezilenkare++;
            if(currentR.bitismi()){
                currentR.setDugumrengi(Color.orange);
                surebitisi=System.nanoTime();
                gecenmilisaniye=surebitisi- surebaslangici;
                surehesapla(gecenmilisaniye);
                break;
            }
            currentR.setDugumrengi(Color.ORANGE);
            try {
                Thread.sleep(aramasuresi);
            } catch (Exception e) {
                e.printStackTrace();
            }

            currentR.setDugumrengi(Color.BLUE);
            for (Robot2 bitisigindekikare:currentR.komsubul()) {
                if(bitisigindekikare.izlenenyolmu()){
                    continue;
                }

                double bitis1= Robot2.uzaklik(bitisigindekikare,hedef);
                double gorulendevamyol1= Robot2.uzaklik(currentR,baslangic);

                double bitis2= Robot2.uzaklik(bitisigindekikare,hedef);
                double gorulendevamyol2= Robot2.uzaklik(currentR,baslangic);

                if(!yollistesi.contains(bitisigindekikare) || (bitis1+gorulendevamyol1 < bitis2+gorulendevamyol2)){
                    onceki[bitisigindekikare.getX()][bitisigindekikare.getY()]=currentR;
                    if(!yollistesi.contains(bitisigindekikare)){
                        yollistesi.add(bitisigindekikare);
                    }
                }
            }
        }
        System.out.println("Toplam Gezilen Kare Sayısı: "+toplamgezilenkare);
        kisayolbul(onceki,hedef);
        System.out.println("Toplam Süre:"+(Uygulama2.getKygecensaniye()+Uygulama2.getGecensaniye()));
    }

    public static void surehesapla(double msaniye){
        gecensaniye=msaniye/1000000000;
        System.out.println("Hedefe Ulaşmak İçin Geçen saniye: "+gecensaniye);
    }

    public static void kysurehesapla(double kisayolbulmasuresi){
        kygecensaniye= kisayolbulmasuresi /1000000000;
        System.out.println("Kısa Yol Bulmak İçin Geçen saniye: "+kygecensaniye);
    }

    public static int getToplamgezilenkare() {
        return toplamgezilenkare;
    }

    public static void setToplamgezilenkare(int toplamgezilenkare) {
        Uygulama2.toplamgezilenkare = toplamgezilenkare;
    }

    public int getAramasuresi() {return aramasuresi;}
    public void setAramasuresi(int aramasuresi) {this.aramasuresi = aramasuresi;}
    public static double getGecensaniye() {
        return gecensaniye;
    }
    public static void setGecensaniye(double gecensaniye) {
        Uygulama2.gecensaniye = gecensaniye;
    }

    public static long getSurebaslangici() {return surebaslangici;}

    public static void setSurebaslangici(long surebaslangici) {
        Uygulama2.surebaslangici = surebaslangici;
    }

    public static long getSurebitisi() {
        return surebitisi;
    }

    public static void setSurebitisi(long surebitisi) {
        Uygulama2.surebitisi = surebitisi;
    }

    public static long getGecenmilisaniye() {
        return gecenmilisaniye;
    }

    public static void setGecenmilisaniye(long gecenmilisaniye) {
        Uygulama2.gecenmilisaniye = gecenmilisaniye;
    }
    public static int getKisayolkaresayisi() {
        return kisayolkaresayisi;
    }
    public static void setKisayolkaresayisi(int kisayolkaresayisi) {
        Uygulama2.kisayolkaresayisi = kisayolkaresayisi;
    }

    public static long getKisayolsurebaslangici() {
        return kisayolsurebaslangici;
    }

    public static void setKisayolsurebaslangici(long kisayolsurebaslangici) {
        Uygulama2.kisayolsurebaslangici = kisayolsurebaslangici;
    }

    public static long getKisayolsurebitisi() {
        return kisayolsurebitisi;
    }

    public static void setKisayolsurebitisi(long kisayolsurebitisi) {
        Uygulama2.kisayolsurebitisi = kisayolsurebitisi;
    }

    public static long getKisayolbulmasuresi() {
        return kisayolbulmasuresi;
    }

    public static void setKisayolbulmasuresi(long kisayolbulmasuresi) {
        Uygulama2.kisayolbulmasuresi = kisayolbulmasuresi;
    }

    public static double getKygecensaniye() {
        return kygecensaniye;
    }

    public static void setKygecensaniye(double kygecensaniye) {
        Uygulama2.kygecensaniye = kygecensaniye;
    }
}
