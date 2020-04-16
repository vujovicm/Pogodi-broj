import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static int port=1234;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(port)
        ) {
            System.out.println("Server pokrenut, osluskuje na portu " + port);
            System.out.println("Uneti broj igraca: ");

            Scanner s= new Scanner(System.in);
            int broj_igraca= s.nextInt();
            int brojac=0;


            while(brojac<broj_igraca){
                Socket klijent=server.accept();
                System.out.println("Prihvacen klijent! Broj igraca je "+ ++brojac);
                new Thread(new KlijentHandlerRinnable(klijent)).start();


            }//end while


        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
