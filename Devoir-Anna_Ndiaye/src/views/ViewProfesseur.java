package views;

import entities.Professeur;

public class ViewProfesseur extends View<Professeur>  {

    @Override
    public Professeur saisie() {
        Professeur professeur = new Professeur();
        do {
            System.out.println("Veuillez saisir le nom complet du professeur");
            professeur.setNomComplet(scanner.nextLine());
        } while (professeur.getNomComplet() == null);
        return professeur;
    }
    
}
