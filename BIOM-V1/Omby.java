package amidy;

public class Omby
{
    double vidiny;
    int lanjany;
    String anarana;
    int marika;
    String ray;
    String reny;
    int sex;
    public Omby(){}

    public Omby(double prix,int poids,String nom,int id,String pere,String mere,int sx)
    {
       setPrix(prix);
       setPoids(poids);
       setNom(nom);
       setId(id);
       setPere(pere);
       setMere(mere);
       setSex(sx);
    }

    public void setPrix(double price)
    {
        this.vidiny=price;
    }
    public double getPrix()
    {
       return this.vidiny;
    }
    public void setPoids(int lanja)
    {
        this.lanjany=lanja;
    }
    public int getPoids()
    {
       return this.lanjany;
    }
    public void setId(int identifiant)
    {
        this.marika=identifiant;
    }
    public int getId()
    {
       return this.marika;
    }
    public void setPere(String dada)
    {
        this.ray=dada;
    }
    public String getPere()
    {
       return this.ray;
    }
    public void setMere(String mama)
    {
       this.reny=mama;
    }
    public String getMere()
    {
        return this.reny;
    }
    public void setSex(int sexe)
    {
        this.sex=sexe;
    }
    public int getSex()
    {
       return this.sex;
    }
    public void setNom(String name)
    {
        this.anarana=name;
    }
    public String getNom()
    {
       return this.anarana;
    }
}