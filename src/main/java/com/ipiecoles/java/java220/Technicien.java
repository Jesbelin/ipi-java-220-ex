package com.ipiecoles.java.java220;

import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

public class Technicien extends Employe {
    private Integer grade;

    public Technicien () {

    }

    public Technicien(
            String nom,
            String prenom,
            String matricule,
            LocalDate dateEmbauche,
            Double salaire,
            Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    @Override
    public Double getPrimeAnnuelle() {
        Double prime = Entreprise.primeAnnuelleBase();
        Double bonification = prime * (grade/10.0);
        return prime + bonification + Entreprise.PRIME_ANCIENNETE*this.getNombreAnneeAnciennete();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) throws TechnicienException{
        if (grade == null || grade < 1 || grade >5) {

            throw new TechnicienException(this,grade);
        }
        this.grade = grade;
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * (1 + grade / 10.0));
    }

    @Override
    public Integer getNbConges() {
        return (super.getNbConges()+ this.getNombreAnneeAnciennete());
    }

    @Override
    public String toString() {
        return "Technicien{grade="
            + grade
            + "} "
            + super.toString();
    }
}