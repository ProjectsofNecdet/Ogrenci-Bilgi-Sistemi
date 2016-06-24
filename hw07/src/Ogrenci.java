/**
 * Created by Necdet on 25.5.2015.
 */
public class Ogrenci {
    private int no;
    private String ad;
    private String soyad;
    private String bolum;
    private double not;

    public Ogrenci(int no, String ad, String soyad, String bolum, double not) {
        this.no = no;
        this.ad = ad;
        this.soyad = soyad;
        this.bolum = bolum;
        this.not = not;
    }

    public int getNo() {
        return no;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public String getBolum() {
        return bolum;
    }

    public double getNot() {
        return not;
    }

    public String toString() {
        return no + " " + ad + " " + soyad + " " + bolum + " " + not;
    }

}