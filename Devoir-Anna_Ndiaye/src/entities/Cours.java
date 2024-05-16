package entities;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Cours {
    private int id;
    private String module;
    private static int nbre;
    private LocalTime heureDb;
    private LocalTime heureFin;
    private Professeur professeur;
    public LocalTime getHeureDb() {
        return heureDb;
    }
    public void setHeureDb(LocalTime heureDb) {
        this.heureDb = heureDb;
    }
    
    public LocalTime getHeureFin() {
        return heureFin;
    }
    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    public Cours() {
        id = nbre++;
    }
    public int getId() {
        return id;
    }
    public String getModule() {
        return module;
    }
    public void setModule(String module) {
        this.module = module;
    }
    public static int getNbre() {
        return nbre;
    }
    public static void setNbre(int nbre) {
        Cours.nbre = nbre;
    }
    @Override
    public String toString() {
        return "Cours [id=" + id + ", module=" + module + ", professeur=" + professeur + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((professeur == null) ? 0 : professeur.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cours other = (Cours) obj;
        if (professeur == null) {
            if (other.professeur != null)
                return false;
        } else if (!professeur.equals(other.professeur))
            return false;
        return true;
    }
}
