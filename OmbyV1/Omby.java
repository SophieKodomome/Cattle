package betail;

public class Omby {
    String name;
    int iD;
    double weight;
    int price;
    boolean isLost;

    public Omby() {
    }

    public Omby(String n, int iD, double w, int p) {
        this.setName(n);
        this.setID(iD);
        this.setWeight(w);
        this.setPrice(p);
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public void setWeight(double w) {
        this.weight = w;
    }

    public void setPrice(int p) {
        this.price = p;
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.iD;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getPrice() {
        return this.price;
    }
}
