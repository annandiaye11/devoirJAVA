package services;

import java.util.ArrayList;
import java.util.List;

import core.Service;
import entities.Cours;

public class ServiceCours implements Service<Cours>{
    List<Cours> cours = new ArrayList<>();
    @Override
    public void add(Cours data) {
        this.cours.add(data);
    }

    @Override
    public List<Cours> show() {
        return cours;
    }

    @Override
    public Cours getBy(String professeur) {
        for (Cours coursRechercher : cours) {
            if (coursRechercher.getProfesseur().equals(professeur)) {
                return coursRechercher;
            }
        }
        return null;
    }
    
    
    
}
