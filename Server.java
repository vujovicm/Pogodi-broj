import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {

    public static int port = 1234;
    private static Random random = new Random();
    //Ovo treba uopstit u niz... I sad uvek pokrece za Igru sa kartama prva, druga, treca, to treba da se uopsti da pokrece sa 3 iz niza
    private static int prva = random.nextInt(101);
    private static int druga = random.nextInt(101);
    private static int treca = random.nextInt(101);
    private static int cetvrta = random.nextInt(101);
    private static int peta = random.nextInt(101);
    private static int sesta = random.nextInt(101);


// (2) some time later ... assign elements to the array



    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)
        ) {
            System.out.println("Server pokrenut, osluskuje na portu " + port);
            System.out.println("Uneti broj igraca: ");

            Scanner s = new Scanner(System.in);
            int broj_igraca = s.nextInt();
            int brojac = 0;


            while (brojac < broj_igraca) {
                Socket klijent = server.accept();
                System.out.println("Prihvacen klijent! Broj igraca je " + ++brojac);
                new Thread(new KlijentHandlerRinnable(klijent, prva, druga, treca)).start();


            }//end while


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  int getPrva() {
        return prva;
    }


}
