/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Scanner;

/**
 *
 * @author HP Envy i7
 */
public class MasterMind {

    static String saisie;
    static Scanner sc = new Scanner(System.in);
    static ImplementationMstMind i = new ImplementationMstMind();

    public static void format() {
        System.out.print("Vous>");
    }

    public static void saisir() {
        System.out.println("");
        System.out.println("C'est parti");
        System.out.println("Entrer vos choix de couleurs parmis ['R','J','B','O','V','N']");
        System.out.println("Vous n'avez droit qu'à 4 choix de couleur");
        format();
        saisie = sc.nextLine();
    }

    public static void erreur() {
        System.out.println("Erreur de saisie!");
        System.out.println("Veuillez choisir des couleurs parmi ['R','J','B','O','V','N']");
        format();
        saisie = sc.nextLine();
    }
    
  //Afficher les couleurs générées par la machine
    public static void ordi(char [] tab){
        //faire le test
        for (int y = 0; y < 4; y++) {
            System.out.print(tab[y]);
        }
        //fin test
    }

    //fonction principale
    public static void main(String[] args) {
        int u = 1;
        char ge[] = i.generer();
        saisir();
        while (u < i.tour) {
            
            if (i.verifier(i.tab, saisie)) {//vérification du choix de l'utilisateur
                
                i.afficher(saisie,i.sortie(ge,saisie), u);
                
                if (i.sortie(ge,saisie)[0] == 4) {
                    System.out.println("GAGNE!");
                    break;
                }
                u++;
                format();
                saisie = sc.nextLine();
            } else {
               erreur();
            }

        }

        System.out.println("Fin");

    }

}
