package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private  LocalDate dateEmbauche;
    private Double salaire = Entreprise.SALAIRE_BASE;

    public Employe(){

    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete (){
        return LocalDate.now().getYear() - this.dateEmbauche.getYear();
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public LocalDate getDateEmbauche() { return dateEmbauche; }
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        //date antérieure : ok
        if (dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() { return salaire; }
    public void setSalaire(Double salaire) { this.salaire = salaire; }

    public Integer getNbConges (){
        return Entreprise.NB_CONGES_BASE;
    }

    public String toString() {
        return "Employe{" +
                "nom='" + nom + "', prenom='" + prenom +
                "', matricule='" + matricule +
                "', dateEmbauche=" + dateEmbauche +
                ", salaire=" + salaire +
                "}";
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        Employe e = (Employe) o;
        return nom == e.nom &&
            Objects.equals(prenom, e.prenom) &&
            Objects.equals(matricule, e.matricule) &&
            Objects.equals(dateEmbauche, e.dateEmbauche) &&
            Double.compare(e.salaire, salaire) == 0;
    }

    /* Autre technique:
        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (!(o instanceof Employe)) return false;
            Employe e = (Employe) o;
            return this.hashCode() == o.hashCode();
     */

    @Override
    public int hashCode(){
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    public void augmenterSalaire (Double pourcentage){
        this.salaire = this.salaire * (1 + pourcentage);
    }
}
