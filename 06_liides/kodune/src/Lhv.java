public class Lhv extends Pank implements Arvutused {
    double lepinguTasu = 25.0;

    public Lhv(double intress, int maxPeriood) {
        super(intress, maxPeriood);
    }

    @Override
    public double arvutaKuumakse(Laen laen) {
        if (laen.periood <= this.maxPeriood) {
            return ((laen.laenuSumma + this.lepinguTasu) / laen.periood) + (this.intress / 100 * laen.laenuSumma);
        } else {
            throw new Error("Laenuperiood üle maksimumi");
        }
    }

    @Override
    public double arvutaIntressiSumma(Laen laen) {
        return this.arvutaKuumakse(laen) * laen.periood - laen.laenuSumma;
    }
}
