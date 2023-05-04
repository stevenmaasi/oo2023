public class Isikukood {
    String nimi;
    String isikukood;

    public Isikukood(String name, String isikukood) {
        this.nimi = name;
        this.isikukood= isikukood;
    }

    public String getIsikukoodJaNimi() {
        return "Isikukood: " + this.isikukood + " | Nimi: " + this.nimi;
    }
}
