package DepoUygulamasi;


import java.util.InputMismatchException;
import java.util.Scanner;

import static DepoUygulamasi.Depo.*;

public class Runner {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("   HOSGELDINIZ!    ");
        urunTanimlama();
        System.out.println();
        urunListeleme();

        do {
            System.out.print(
                    "                     \n"
                            + " " + "Urun Tanimlama:" + " 1 " + " " + " " + "Urun Girisi:" + "    2 " + "  " + "\n"
                            + "                      \n"
                            + " " + "Urunu Rafa Koy:" + " 3 " + " " + " " + "Urun Cikisi:" + "    4 " + "  " + "\n"
                            + "                   \n"
                            + " " + "Urun Silme:" + "     5 " + " " + " " + "Cikis:" + "          6 " + "  " + "\n"
                            + " ");
            System.out.println();
            System.out.print("Seciminizi yapiniz: ");


            try {
                int secim = input.nextInt();
                input.nextLine();

                switch (secim) {
                    case 1:
                        urunTanimlama();
                        System.out.println();
                        urunListeleme();
                        break;
                    case 2:
                        urunGirisi();
                        System.out.println();
                        urunListeleme();
                        break;
                    case 3:
                        urunRafaKoy();
                        System.out.println();
                        urunListeleme();
                        break;
                    case 4:
                        urunCikis();
                        System.out.println();
                        urunListeleme();
                        break;
                    case 5:
                        urunSilme();
                        System.out.println();
                        urunListeleme();
                        break;
                    case 6:
                        System.out.println("Programdan c覺k覺l覺yor...");
                        urunListeleme();
                        break;
                    default:
                        System.err.println("Gecersiz secim. ");
                        break;
                }

                if (secim == 6) {
                    break;
                }

            } catch (InputMismatchException e) {
                System.err.println("Hatal覺 Giris! Sayisal bir giris yapiniz! ");
                System.out.println();
                input.nextLine();
            }


        } while (true);

    }
}
