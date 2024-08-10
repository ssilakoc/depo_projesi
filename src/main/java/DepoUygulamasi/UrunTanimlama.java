package DepoUygulamasi;

public class UrunTanimlama {
    private int urunId;
    private String urunIsmi;
    private String uretici;
    private String birim;
    private int miktar;
    private String raf;

    public UrunTanimlama(int urunId, String urunIsmi, String uretici, String birim, int miktar, String raf) {
        this.urunId = urunId;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.birim = birim;
        this.miktar = miktar;
        this.raf = raf;
    }

    public int getUrunId() {
        return urunId;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public String getBirim() {
        return birim;
    }

    public int getMiktar() {
        return miktar;
    }

    public String getRaf() {
        return raf;
    }

    public void setUrunId(int urunId) {
        this.urunId = urunId;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }
}