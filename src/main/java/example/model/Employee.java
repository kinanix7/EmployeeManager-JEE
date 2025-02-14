package example.model;

public class Employee {
    private int id ;
    private String nom ;
    private String prenom ;
    private String email ;
    private String poste ;
    private double salaire ;


    public Employee() {}

    public Employee(int id, String nom, String prenom, String email, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.poste = poste;
        this.salaire = salaire;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }
}