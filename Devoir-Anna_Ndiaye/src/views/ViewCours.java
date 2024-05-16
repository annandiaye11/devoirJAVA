package views;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import core.Service;
import entities.Cours;
import entities.Professeur;

public class ViewCours extends View<Cours> {
    private Service<Cours> serviceCours;
    private Service<Professeur> serviceProfesseur;
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
    ViewProfesseur viewProfesseur = new ViewProfesseur();
    public ViewCours(Service<Cours> ServiceCours, Service<Professeur> serviceProfesseur) {
        this.serviceCours = serviceCours;
        this.serviceProfesseur = serviceProfesseur;
    }

    @Override
    public Cours saisie() {
            if (serviceProfesseur.show().isEmpty()){
                return null;
            }
            Cours cours = new Cours();
            System.out.println("Veuillez saisir le module du cours");
            cours.setModule(scanner.nextLine());
            cours.setHeureDb(saisieTime("debut"));
            cours.setHeureFin(saisieTime("fin"));
            do {
                viewProfesseur.liste(serviceProfesseur.show());
                System.out.println("Veuillez saisir le nom complet d'un professeur");
                cours.setProfesseur(serviceProfesseur.getBy(scanner.nextLine()));
                if (cours.getProfesseur() == null){
                    System.out.println("Aucun professeur trouve avec ce nom");
                } else {
                    Professeur professeur = cours.getProfesseur();
                    professeur.addCours(cours);
                }
            } while (cours.getProfesseur() == null);
        
        return cours;
    }

    public LocalTime saisieTime(String message){
        LocalTime heure = null;
        boolean ok = false;
        do {
            System.out.println("Veuillez saisir l'heure de " + message + " format(HH:mm)") ;
            try {
                heure = LocalTime.parse(scanner.nextLine(), format);
                ok = true;
            } catch (DateTimeParseException e) {
                System.out.println("Heure invalide\nVeuillez reessayer");
            }
        } while (!ok);
        return heure;
    }
}

