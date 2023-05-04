public class Swedbank extends Pank implements Arvutused{
    double igaKuineLisaTasu = 2.5;

    public Swedbank(double intress, int maxPeriood) {
        super(intress, maxPeriood);
    }

    @Override
    public double arvutaKuumakse(Laen laen) {
        if (laen.periood <= this.maxPeriood) {
            return ((laen.laenuSumma / laen.periood) + (this.intress / 100 * laen.laenuSumma)) + this.igaKuineLisaTasu;
        } else {
            throw new Error("Laenuperiood üle maksimumi");
        }
    }

    @Override
    public double arvutaIntressiSumma(Laen laen) {
        return this.arvutaKuumakse(laen) * laen.periood - laen.laenuSumma;
    }
}
