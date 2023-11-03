package client; 

import betail.*;

public class Olona {
    String name;
    int iD;
    int credit;
    Omby[] betail;

    public Olona(){}

    public Olona(String n, int iD, int c,Omby[] b){
        this.setName(n);
        this.setID(iD);
        this.setCredit(c);
        this.setBetail(b);
    }

    public void setName(String n){
        this.name=n;
    }

    public void setID(int iD){
        this.iD=iD;
    }

    public void setCredit(int c){
        this.credit=c;
    }

    public void setBetail(Omby[] b){
        this.betail=b;
    }

    public String getName(){
        return this.name;
    }

    public int getID(){
        return this.iD;
    }

    public int getCredit(){
        return this.credit;
    }

    public Omby[] getbetail(){
        return this.betail;
    }
}
