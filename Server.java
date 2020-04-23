import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Server {

    public static int port = 1234;
   /* private static Random random = new Random();
    //Ovo treba uopstit u niz... I sad uvek pokrece za Igru sa kartama prva, druga, treca, to treba da se uopsti da pokrece sa 3 iz niza
    private static int prva = random.nextInt(101);
    private static int druga = random.nextInt(101);
    private static int treca = random.nextInt(101);
    private static int cetvrta = random.nextInt(101);
    private static int peta = random.nextInt(101);
    private static int sesta = random.nextInt(101);*/
    static int []niz = RandomNumbers();


// (2) some time later ... assign elements to the array



    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)
        ) {
            System.out.println("Server pokrenut, osluskuje na portu " + port);
            System.out.println("Uneti broj igraca: ");

            Scanner s = new Scanner(System.in);
            int broj_igraca = s.nextInt();
            int brojac = 0;
            int brojac_niza = 0;


            while (brojac < broj_igraca) {
                Socket klijent = server.accept();
                System.out.println("Prihvacen klijent! Broj igraca je " + ++brojac);
                new Thread(new KlijentHandlerRinnable(klijent, niz[brojac_niza++], niz[brojac_niza++], niz[brojac_niza++])).start();


            }//end while


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] RandomNumbers(){
        //redja brojeve iz (0,100] na random nacin u niz

        final Random r = new Random();
        int[] result = new int[100];
        Set<Integer> used = new HashSet<Integer>();

        for (int i = 0; i < 100; i++) {

            int newRandom;
            do {
                newRandom = r.nextInt(100)+1; //ovo +1 je da ne bude ukljucena 0
            } while (used.contains(newRandom));
            result[i] = newRandom;
            used.add(newRandom);
        }
        return result;
    }


}
