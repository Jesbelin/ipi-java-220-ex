package com.ipiecoles.java.java220;

public class Main {
    public static void main(String[] args){
        Employe e = new Technicien();
        e.setNom("Pierre");
        Employe e2 = new Technicien();
        e2.setNom("Pierre");
        System.out.println(e.toString());
        System.out.println(e2.hashCode());
        System.out.println(e.equals(e));
        System.out.println(e.equals(e2));
    }
}
