public class IsikukoodFI extends Isikukood implements Andmed {

    public IsikukoodFI(String nimi, String isikukood) {
        super(nimi, isikukood);
    }

    @Override
    public String getSugu() {
        if (Integer.parseInt(isikukood.substring(9,10)) % 2 != 0) {
            return "M";
        } else {
            return "F";
        }
    }

    @Override
    public String getKuupaev() {
        if (isikukood.charAt(6) == '-') {
            return  isikukood.substring(4,6) + "." + isikukood.substring(2,4) + ".19" + isikukood.substring(0,2);
        } else if (isikukood.charAt(6) == 'A') {
            return isikukood.substring(4,6) + "." + isikukood.substring(2,4) + ".20" + isikukood.substring(0,2);
        } else {
            return "Vigane isikukood!";
        }
    }

    @Override
    public int getVanus() {
        return 0;
    }
}