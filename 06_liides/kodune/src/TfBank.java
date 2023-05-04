public class TfBank extends Pank implements Arvutused {
    public TfBank(double intress, int maxPeriood) {
        super(intress, maxPeriood);
    }

    @Override
    public double arvutaKuumakse(Laen laen) throws Exception {
        if (laen.periood <= this.maxPeriood) {
            return (laen.laenuSumma / laen.periood) + (this.intress / 100 * laen.laenuSumma);
        } else {
            throw new Exception("Laenuperiood yle maksimumi");
        }
    }

    @Override
    public double arvutaIntressiSumma(Laen laen) throws Exception {
        return this.arvutaKuumakse(laen) * laen.periood - laen.laenuSumma;
    }
}
