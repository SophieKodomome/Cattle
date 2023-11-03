package betail;

public class Omby {
    String name;
    int iD;
    double weight;
    int price;
    int idOwner;
    String isLost;

    public Omby() {
    }

    public Omby(String n, int iD, double w, int p, int iDO, String i) {
        this.setName(n);
        this.setID(iD);
        this.setWeight(w);
        this.setPrice(p);
        this.setIDOwner(iDO);
        this.setLost(i);
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

    public void setIDOwner(int iDO) {
        this.idOwner = iDO;
    }

    public void setLost(String l) {
        this.isLost = l;
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

    public int getIDOwner() {
        return this.idOwner;
    }

    public String getLost() {
        return this.isLost;
    }
}
