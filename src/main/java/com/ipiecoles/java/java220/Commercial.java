package com.ipiecoles.java.java220;

public class Commercial extends Employe{

    public Commercial () {

    }

    private Double caAnnuel;

    public Double getCaAnnuel() {
        return caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
        double prime = Math.ceil(this.getCaAnnuel() * 0.05);
        double primeBase = 500;
        if (prime < 500){
            return primeBase;
        }
        return prime;
    }
}
