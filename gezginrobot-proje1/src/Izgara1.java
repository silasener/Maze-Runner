import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Izgara1 {
    private static String path1="/Users/silasener/Desktop/Senaryo1ilk.txt";
    //     /Users/emreterzi/Desktop/Senaryo1ilk.txt
    //     /Users/silasener/Desktop/Senaryo1ilk.txt

    private static String path2="/Users/silasener/Desktop/Senaryo1ikinci.txt";
    //       /Users/emreterzi/Desktop/Senaryo1ikinci.txt
    //       /Users/silasener/Desktop/Senaryo1ikinci.txt
    private  static int boyut;


    public static int getBoyut() throws FileNotFoundException {
        if(Senaryo1.getPathsayaci()%2==0){
            FileInputStream w = new FileInputStream(path1);
            Scanner scanner  = new Scanner(w);
            List<Double> numbers = new ArrayList<Double>();
            while (scanner.hasNextDouble()){
                numbers.add(scanner.nextDouble());
            }
            boyut = numbers.size();

        }else if(Senaryo1.getPathsayaci()%2==1){
            FileInputStream w = new FileInputStream(path2);
            Scanner scanner  = new Scanner(w);
            List<Double> numbers = new ArrayList<Double>();
            while (scanner.hasNextDouble()){
                numbers.add(scanner.nextDouble());
            }
            boyut = numbers.size();
        }
        return boyut;
    }


    public static void setBoyut(int boyut) {
        Izgara1.boyut = boyut;
    }
    public static String getPath1() {
        return path1;
    }

    public static void setPath1(String path1) {
        Izgara1.path1 = path1;
    }
    public static String getPath2() {
        return path2;
    }

    public static void setPath2(String path2) {
        Izgara1.path2 = path2;
    }


}