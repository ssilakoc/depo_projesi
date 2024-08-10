package DepoUygulamasi;

import java.util.*;

public class Depo {
    static Scanner input = new Scanner(System.in);

    public static int idCounter = 1000;
    static HashMap<Integer, UrunTanimlama> urunler = new HashMap<>();
    static HashSet<Integer> urunIdList = new HashSet<>();


    public static void urunTanimlama() {


        System.out.println("Urun ismini giriniz: ");
        String urunAdi = input.nextLine();

        System.out.println("Uretici adini giriniz: ");
        String ureticiAdi = input.nextLine();

        System.out.println("Urun birimini giriniz: (kg/cuval...)");
        String birim = input.nextLine();

        UrunTanimlama yeniUrun = new UrunTanimlama(idCounter, urunAdi, ureticiAdi, birim, 0, "-");
        urunler.put(yeniUrun.getUrunId(), yeniUrun);

        idCounter++;

        for (Map.Entry<Integer, UrunTanimlama> w : urunler.entrySet()) {

            urunIdList.add(w.getKey());
        }

    }

    public static void urunListeleme() {

        System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n", "ID", "Urun Adı", "Uretici", "Birim", "Miktar", "Raf");
        System.out.println("--------------------------------------------------------------------------");

        for (Map.Entry<Integer, UrunTanimlama> w : urunler.entrySet()) {
            System.out.printf("%-10s%-15s%-15s%-15s%-15s%-15s\n",
                    w.getValue().getUrunId(),
                    w.getValue().getUrunIsmi(),
                    w.getValue().getUretici(),
                    w.getValue().getBirim(),
                    w.getValue().getMiktar(),
                    w.getValue().getRaf());
        }

        System.out.println();
    }

    public static void urunGirisi() {
        if (!urunler.isEmpty()) {

            System.out.println("Urun girisi yapmak istediginiz urun id'sini yazınız!");

            try {
                int girisId = input.nextInt();
                input.nextLine();

                if (urunIdList.contains(girisId)) {
                    System.out.println("Girmek istediginiz miktarı yazınız!");

                    try {
                        int girilenMiktar = input.nextInt();
                        input.nextLine();

                        if (girilenMiktar > 0) {

                            for (Map.Entry<Integer, UrunTanimlama> entry : urunler.entrySet()) {
                                if (girisId == entry.getKey()) {
                                    UrunTanimlama urun = entry.getValue();

                                    int stockMiktari = urun.getMiktar();
                                    int yeniMiktar = stockMiktari + girilenMiktar;

                                    urun.setMiktar(yeniMiktar);

                                    if (yeniMiktar <= 10) {
                                        System.err.println("Dikkat: Urunden 10 veya daha az kaldi!");
                                    }

                                    System.out.println("Stock guncellendi:");
                                    System.out.printf("Yeni miktar: %d\n", urun.getMiktar());
                                }
                            }
                        } else {
                            System.err.println(" 0 veya negatif sayı girilemez!");
                            urunGirisi();
                        }
                    } catch (InputMismatchException e) {
                        System.err.println(" HATALI GİRİS! Sayısal bir miktar girisi yapiniz! ");
                        input.nextLine();
                    }

                } else {
                    System.err.println("Girdiğiniz ID numarasına ait ürün bulunamadı!");
                    urunGirisi();
                }

            } catch (InputMismatchException e) {
                System.err.println(" HATALI GİRİS! Sayısal bir ürün ID numarası giriniz! ");
                input.nextLine();
            }
        } else {
            System.err.println(" Urun listesi bos! Lutfen urun ekleyin! ");
            System.out.println();
        }
    }

    public static void urunRafaKoy() {
        if ((urunler != null)) {
            System.out.println(" Lutfen, Rafa koymak istediginiz urun ID numarasını giriniz!");
            try {
                int rafID = input.nextInt();
                input.nextLine();

                ArrayList<String> rafIsimListesi = new ArrayList<>();
                if (urunIdList.contains(rafID)) {


                    for (Map.Entry<Integer, UrunTanimlama> w : urunler.entrySet()) {
                        if (rafID == w.getKey() && w.getValue().getMiktar() <= 0) {
                            System.err.println("Urun miktari yetersiz");
                            return;
                        }
                    }


                    System.out.println(" Koymak istediginiz rafi giriniz! ");
                    String raf = input.nextLine();

                    for (Map.Entry<Integer, UrunTanimlama> w : urunler.entrySet()) {
                        if (rafID == w.getKey() && w.getValue().getMiktar() > 0) {
                            w.getValue().setRaf(raf);
                            System.out.println("Urun rafa  yerlestirildi.");
                        }
                    }

                } else {
                    System.err.println("Girdiginiz ID numarasina ait urun bulunamadı!");
                }

            } catch (InputMismatchException e) {
                System.err.println(" HATALI GİRİS! Sayisal bir urun ID numara giriniz");
                input.nextLine();
            }
        } else {
            System.err.println(" Urun listesi bos! Lutfen urun ekleyin! ");
            System.out.println();
        }
    }


    public static void urunCikis() {

        if ((urunler != null)) {


            System.out.println("Urun cikisi yapmak istediginiz urun ID'sini giriniz! ");

            if ((!urunler.isEmpty())) {

                try {
                    int id = input.nextInt();
                    input.nextLine();


                    if (urunIdList.contains(id)) {

                        for (Map.Entry<Integer, UrunTanimlama> w : urunler.entrySet()) {
                            if (id == w.getKey() && w.getValue().getMiktar() <= 0) {
                                System.err.println(" Urun miktari yetersiz! ");
                                return;
                            }
                        }


                        System.out.println(" Cikis yapmak istediginiz miktari giriniz!");

                        try {
                            int cikisMiktari = input.nextInt();
                            input.nextLine();


                            if (cikisMiktari > 0) {

                                for (Map.Entry<Integer, UrunTanimlama> w : urunler.entrySet()) {

                                    if (id == w.getKey()) {
                                        if (w.getValue().getMiktar() < cikisMiktari) {
                                            System.err.println("Yetersiz urun stogu!");
                                        } else {
                                            w.getValue().setMiktar(w.getValue().getMiktar() - cikisMiktari);
                                            break;
                                        }
                                    }
                                }

                            } else {

                                System.err.println(" 0 veya negatif sayı girilemez");
                                urunCikis();
                            }


                        } catch (InputMismatchException e) {
                            System.err.println(" HATALI GİRİS! Sayisal bir urun ID numara giriniz! ");
                            input.nextLine();
                        }

                    } else {
                        System.err.println("Girdiginiz ID numarasina ait urun bulunamadı!");

                    }

                } catch (InputMismatchException e) {
                    System.err.println(" HATALI GİRİS! Sayisal bir urun ID numara giriniz");
                    input.nextLine();
                }

            } else {
                System.err.println(" Urun listesi bos! Lutfen urun ekleyin! ");
                System.out.println();
            }
        }
    }

    public static void urunSilme() {
        if ((!urunler.isEmpty())) {

            System.out.println(" Silmek istediginiz ID numara giriniz! ");

            try {
                int silmeID = input.nextInt();
                input.nextLine();

                if (urunIdList.contains(silmeID)) {


                    Iterator<Map.Entry<Integer, UrunTanimlama>> liste = urunler.entrySet().iterator();

                    while (liste.hasNext()) {
                        Map.Entry<Integer, UrunTanimlama>
                                w = liste.next();


                        if (w.getKey() == silmeID) {

                            liste.remove();

                            urunIdList.remove(silmeID);

                            return;
                        }
                    }

                } else {
                    System.err.println("Girdiginiz ID numarasina ait urun bulunamadı!");
                }

            } catch (InputMismatchException e) {
                System.err.println(" HATALI GİRİS! Sayisal bir urun ID numara giriniz");
                input.nextLine();
            }
        } else {
            System.err.println(" Urun listesi bos! Lutfen urun ekleyin! ");
            System.out.println();
        }
    }
}