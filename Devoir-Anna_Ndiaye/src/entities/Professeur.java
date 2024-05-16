package entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur {
    private int id;
    private String nomComplet;
    private static int nbre;
    private List<Cours> cours;

    public Professeur() {
        id = ++nbre;
        this.cours = new ArrayList<>(); 
    }
    public List<Cours> getCours() {
        return cours;
    }
    public void addCours(Cours cours) {
        this.cours.add(cours);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    public static int getNbre() {
        return nbre;
    }
    public static void setNbre(int nbre) {
        Professeur.nbre = nbre;
    }
    @Override
    public String toString() {
        return "Professeur [id=" + id + ", nomComplet=" + nomComplet + "]";
    }
}
