/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zbercasu;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Katka
 */
public class ZberCasu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean pokracuj = true;
        System.out.println("Zaznam casu");
        int pocet = 0;
        while(pokracuj) {
            pocet++;
            System.out.println(Integer.toString(pocet)+".");
            Scanner keyboard = new Scanner(System.in);
            int volba = keyboard.nextInt();
            switch(volba) {      
                case(1):DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                        Date datePrichod = new Date();
                        try{
                            // pridavanie k existujucemu suboru -- NA ZACHYTENIE JEDNEHO CASU
                            /*BufferedWriter out2 =new BufferedWriter(new FileWriter("doba_obsluhy.txt",true));
                            out2.write(dateFormat.format(date));
                            out2.newLine();
                            out2.close();
                            System.out.println("Zapisal som : " + Integer.toString(pocet)+".");*/
                            
                            // NA ZACHYTENIE DVOCH CASOV
                            BufferedWriter out1 =new BufferedWriter(new FileWriter("doba_obsluhypokladne.txt",true));
                            out1.write(dateFormat.format(datePrichod));
                            out1.write("  ");
                            
                            int uloz = keyboard.nextInt();
                            if(uloz == 1) {
                                Date dateOdchod = new Date();   
                                out1.write(dateFormat.format(dateOdchod));   
                            }
                            
                            out1.close();
                            System.out.println("Zapisal som : " + Integer.toString(pocet)+".");
                            
                        }catch(IOException e){
                            System.out.print("Nastala nejaka chyba");
                        }
                        break;
                case(2): pokracuj = false;
                        System.out.print("*****************************************");
                        System.out.print("Zapisovanie udajov sa skoncilo");
                        System.out.print("Pocet udajov :" + Integer.toString(pocet));
                        System.out.print("*****************************************");
                break;
            }
        }
    }
    
}
