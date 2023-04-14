import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Izgara2 {
    private static String path="/Users/silasener/Desktop/senaryo2.txt";
    //   /Users/emreterzi/Desktop/senaryo2.txt
    //   /Users/silasener/Desktop/senaryo2.txt
    private  static int boyut2;

    public static  void RandomUretmeYAzdirma(int boyut){ //Girilen boyutta random labirent oluşturur
        int[][] maze = new int[boyut][boyut];
         Random random = new Random();

        for (int i = 0; i <boyut ; i++) { maze[0][i]=0;}             //labirentin
        for (int i = 0; i <boyut ; i++) { maze[boyut-1][i]=0;}       // 4 köşesi
        for (int i = 0; i <boyut ; i++) { maze[i][0]=0; }            //0 lanır
        for (int i = 0; i <boyut ; i++) { maze[i][boyut-1]=0; }

    for (int i = 1; i < boyut-1; i++) {
        for (int j = 1; j < boyut-1; j++) {
               if (random.nextBoolean()) {maze[i][j] = 1;}
               else {maze[i][j] = 0;} // içteki kareye random 0-1 üretilir
          }
      }

    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path)); //Oluşturulan labirent okunmak için txt'ye yazdırılır
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                bw.write(maze[i][j] +"");
            }
            bw.newLine();
        }
        bw.flush();
    } catch (IOException e) {}

}

        public static int getBoyut2() throws FileNotFoundException {
        FileInputStream w = new FileInputStream(path); //Txt'ye yazdırılan random labirentin boyutunu hesaplar
        Scanner scanner  = new Scanner(w);
        List<Double> numbers = new ArrayList<Double>();
        while (scanner.hasNextDouble()) {
            numbers.add(scanner.nextDouble());
          }
            boyut2 = numbers.size();
         return boyut2;
        }

    public static void setBoyut2(int boyut2) {
        Izgara2.boyut2 = boyut2;
    }
    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Izgara2.path = path;
    }

}




