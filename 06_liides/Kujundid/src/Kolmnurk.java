public class Kolmnurk extends Tasapinnaline implements Arvutused {
    double kylg1;
    double kylg2;
    double kylg3;

    public Kolmnurk(int tippudeArv, double kylg1, double kylg2, double kylg3) {
        super(tippudeArv);
        this.kylg1 = kylg1;
        this.kylg2 = kylg2;
        this.kylg3 = kylg3;
    }

    @Override
    public double arvutaYmberMoot() {
        return kylg1 + kylg2 + kylg3;
    }

    @Override
    public double arvutaPindala() {
        return 0;
    }
}