import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class KlijentHandlerRinnable implements Runnable {
    private Socket klijent;
    private int a;
    private int b;
    private int c;

    public KlijentHandlerRinnable(Socket klijent, int a, int b, int c) {
        this.klijent=klijent;
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(this.klijent.getInputStream(), StandardCharsets.UTF_8));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.klijent.getOutputStream(), StandardCharsets.UTF_8))) {

            // Ceka ime klijenta
            String ime = in.readLine();

            //Salje pozdravnu poruku
       //     out.write("Dobrodosao u igru " + ime);
        //    out.newLine();
         //   out.flush();


            //Zapocinje igru
          //  out.write("Pokusaj da pogodis koji sam broj izmedju 0 i 100 zamislio:");
          //  out.newLine();
           // out.flush();

            //Generise ranodom broj iz [0,100]
           // Random random= new Random();
           // int zamisljen_broj = random.nextInt(101);
           // System.err.println("Zamislio sam " + zamisljen_broj);
           // int brojac_pokusaja=0;
           // String pokusaj;


            //while((pokusaj =in.readLine()) != null ){
              //  System.out.println("Stigao pokusaj "+ pokusaj + " od " + ime);

                //if(pokusaj.equalsIgnoreCase("kraj"))
                  //  break;
                //int pokusaj_parsovan_u_int=Integer.parseInt(pokusaj);

                //if(pokusaj_parsovan_u_int != zamisljen_broj){
                  //  out.write("Promasaj!");
                   // out.newLine();
                    //out.flush();}
                //else {
                  //  out.write("Pogodak");
                   // out.newLine();
                    //out.flush();}




                    /*Da li da saljem i hint?
                    Zamisljen broj je ");

                    if(pokusaj < zamisljen_broj)
                        System.out.println("veci od " + pokusaj + "!\n");
                    else
                        System.out.println("manji od " + pokusaj + "!\n");
                    */


               // brojac_pokusaja++;

           // }//end while

           // System.out.println("---------------------------------------------------------------");
            //System.out.println("Broj je pogodjen u "+ brojac_pokusaja + " pokusaja\nDovidjenja " + ime + " !\n");

            JFrame frame= new JFrame("Igra");
            frame.setPreferredSize(new Dimension(300, 300));
            frame.setContentPane(new Igra(a,b,c).panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                this.klijent.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }//end finally
    }//end run
}//end class
