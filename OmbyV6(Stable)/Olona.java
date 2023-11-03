package client;

import java.util.*;
import betail.*;

public class Olona {
    String name;
    int iD;
    int credit;
    ArrayList<Omby> betail = new ArrayList<>();

    public Olona() {
    }

    public Olona(String n, int iD, int c, ArrayList<Omby> b) {
        this.setName(n);
        this.setID(iD);
        this.setCredit(c);
        this.setBetail(b);
    }

    public static Olona getOwnerbyID(Omby om, ArrayList<Olona> ol) {
        Olona olona = new Olona();
        for (int i = 0; i < ol.size(); i++) {
            if (om.getIDOwner() == ol.get(i).getID()) {
                olona = ol.get(i);
            }
        }
        return olona;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public void setCredit(int c) {
        this.credit = c;
    }

    public void setBetail(ArrayList<Omby> b) {
        this.betail = b;
    }

    public void setBetail(Omby o) {
        this.betail.add(o);
    }

    public String getName() {
        return this.name;
    }

    public int getID() {
        return this.iD;
    }

    public int getCredit() {
        return this.credit;
    }

    public ArrayList<Omby> getBetail() {
        return this.betail;
    }

    public Omby getOmby(int i) {
        return this.betail.get(i);
    }
}
