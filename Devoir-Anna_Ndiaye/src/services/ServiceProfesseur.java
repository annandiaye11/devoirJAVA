package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Professeur;

public class ServiceProfesseur implements Service<Professeur> {
    List<Professeur> professeurs = new ArrayList<>();

    @Override
    public void add(Professeur professeur) {
        professeurs.add(professeur);
        
    }

    @Override
    public List<Professeur> show() {
        return professeurs;
    }

    @Override
    public Professeur getBy(String data) {
        for (Professeur professeur : professeurs) {
            if (professeur.getNomComplet().equals(data)) {
                return professeur;
            }
        }
        return null;
    }
    
    
}
