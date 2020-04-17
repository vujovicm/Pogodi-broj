import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Klijent {

    public static void main(String[] args) {
        String hostname="localhost";

        System.out.println("Klijent se konektuje na server");

        try (Socket klijent = new Socket(hostname, Server.port)) {

            BufferedReader br = new BufferedReader(new InputStreamReader(klijent.getInputStream(), StandardCharsets.UTF_8));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(klijent.getOutputStream(), StandardCharsets.UTF_8));

            System.out.println("Klijent konektovan na server! Uneti ime igraca:");
            Scanner s=new Scanner(System.in);
            String ime=s.next();
            System.out.println("Klijent " + ime+ " konektovan na server!");

            bw.write(ime);
            bw.newLine();
            bw.flush();

            String pozdrav=br.readLine();
            System.out.println("Poruka od servera: " + pozdrav);
            String pocetak_igre=br.readLine();
            System.out.println(pocetak_igre);

            System.out.println("Krecem da pogadjam!");
            int prvi_pokusaj=s.nextInt();
            bw.write(Integer.toString(prvi_pokusaj));
            bw.newLine();
            bw.flush();

            int pokusaj;
            String poruka=br.readLine();
            boolean pogodak=false;

            while(!pogodak){
                if(poruka.equalsIgnoreCase("promasaj!")){
                    System.out.println( poruka + "Pokusacu opet: ");
                    pokusaj=s.nextInt();
                    bw.write(Integer.toString(pokusaj));
                    bw.newLine();
                    bw.flush();
                    poruka=br.readLine();

                }
                else {
                    System.out.println(poruka);
                    pogodak = true;
                    bw.write("kraj");
                    bw.newLine();
                    bw.flush();
                }
            }//end while



        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
