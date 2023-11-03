package visuel;
import amidy.*;
import client.*;

public class Affiche
{
  public static void main(String[] args)
  {
     Olona jean=new Olona("jean", 1200, 40, "jean2020", 0);
     Omby vao=new Omby(2000000, 100, "balita", 4444, null, null, 0);
     Omby nou=new Omby(2000000, 100, "bala", 4445, null, null, 0);
     Omby bas=new Omby(2000000, 100, "baob", 4446, null, null, 0);
     Omby[] maro=new Omby[5];
     maro[0]=nou;
     maro[1]=bas;
     jean.setFanana(vao);
     jean.setFanana(maro);
     System.out.print(jean.getFanana()[2].getNom());
  }
}