import java.util.Scanner;

import entities.Cours;
import entities.Professeur;
import services.ServiceCours;
import services.ServiceProfesseur;
import views.ViewCours;
import views.ViewProfesseur;

public class App {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws Exception {
       ViewProfesseur viewProfesseur = new ViewProfesseur();
       ServiceCours serviceCours = new ServiceCours();
       ServiceProfesseur serviceProfesseur = new ServiceProfesseur();
       ViewCours viewCours = new ViewCours(serviceCours, serviceProfesseur);
       int choice;
       do {
            choice = showMenu();
            switch (choice) {
                case 1:
                    serviceProfesseur.add(viewProfesseur.saisie());
                    break;
                case 2:
                    viewProfesseur.liste(serviceProfesseur.show());
                break;
                case 3:
                    Cours cours = viewCours.saisie();
                    if (cours != null){
                        serviceCours.add(cours);
                    } else{
                        System.out.println("Veuillez enregistrer un professeur avant la creation d'un cours");
                    }
                break;
                case 4:
                    viewCours.liste(serviceCours.show());
                break;
                case 5:
                    if (!serviceCours.show().isEmpty()){
                        Professeur professeur = new Professeur();
                        viewProfesseur.liste(serviceProfesseur.show());
                        scanner.nextLine();
                        System.out.println("Veuillez saisir le nom complet du professeur");
                        professeur = serviceProfesseur.getBy(scanner.nextLine());
                        if (professeur !=null){
                            for (Cours coursProfesseur : professeur.getCours()) {
                                System.out.println(coursProfesseur);
                            }
                        } else {
                            System.out.println("Aucun professeur trouve avec ce nom");
                        }
                    } else {
                        System.out.println("Veuillez enregistrer un cours");
                    }
                break;
                default:
                    break;
            }
        
       } while (choice !=6);
    }
    public static int showMenu(){
        System.out.println("1-Ajouter un Professeur");
        System.out.println("2-Lister les Professeurs");
        System.out.println("3-Créer un Cours");
        System.out.println("4-Lister Tous les cours");
        System.out.println("5-Lister les cours d’un professeur");
        System.out.println("6-Quitter");
        return scanner.nextInt();
    }
}
