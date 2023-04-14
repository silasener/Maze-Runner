import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {
    public static void main(String[] args) throws IOException {

        URL senaryo1 = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url1.txt");
        ReadableByteChannel rbc = Channels.newChannel(senaryo1.openStream());
        FileOutputStream fos = null;
        fos = new FileOutputStream("/Users/silasener/Desktop/Senaryo1ilk.txt");
        //      /Users/silasener/Desktop/Senaryo1ilk.txt
       //      /Users/emreterzi/Desktop/Senaryo1ilk.txt
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);


        URL website = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt");
        ReadableByteChannel rbc2 = Channels.newChannel(website.openStream());
        FileOutputStream fos2 = null;
        fos2 = new FileOutputStream("/Users/silasener/Desktop/Senaryo1ikinci.txt");
        //       /Users/silasener/Desktop/Senaryo1ikinci.txt
        //      /Users/emreterzi/Desktop/Senaryo1ikinci.txt
        fos2.getChannel().transferFrom(rbc2, 0, Long.MAX_VALUE);

        gezginRoborGUİ gezginRoborGUİ=new gezginRoborGUİ();
    }
}
