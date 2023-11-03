package client;
import amidy.*;

public class Olona
{
  String anarana;
  int marika;
  int age;
  String mdp;
  int isAdmin;
  double montant;
  Omby[] fananana= new Omby[10];
  public Olona(){}
  
  public Olona(String nom,int id,int taona,String password,int estAdmin)
  {
    setNom(nom);
    setId(id);
    setAge(taona);
    setMdp(password);
    setAdmin(estAdmin);
  }
  public void setId(int identifiant)
  {
    this.marika=identifiant;
  }
  public int getId()
  {
    return this.marika;
  }
  public void setNom(String name)
  {
    this.anarana=name;
  }
  public String getNom()
  {
    return this.anarana;
  }
  public void setAge(int ag)
  {
    this.age=ag;
  }
  public int getAge()
  {
    return this.age;
  }
  public String getMdp()
  {
    return this.mdp;
  }
  public void setMdp(String pass)
  {
     this.mdp=pass;
  }
  public void setAdmin(int adm)
  {
    this.isAdmin=adm;
  }
  public int getAdmin()
  {
    return this.isAdmin;
  }
  public void setMontant(double vola)
  {
    this.montant=vola;
  }
  public double getMontant()
  {
    return this.montant;
  }
  public void setFanana(Omby[] possession)
  {
    for(int i=0;i<possession.length;i++)
    {
       for(int j=0;j<this.fananana.length;j++)
       {
         if(this.fananana[j]==null)
         {
          this.fananana[j]=possession[i];
          break;
         }
       }
    }
  }
  public void setFanana(Omby possess)
  {
    for(int i=0;i<this.fananana.length;i++)
    {
      if(this.fananana[i]==null)
      {
        this.fananana[i]=possess;
        break;
      }    
    }
  }
  public Omby[] getFanana()
  {
     return this.fananana; 
  }
}