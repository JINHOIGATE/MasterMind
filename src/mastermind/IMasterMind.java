/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

/**
 *
 * @author HP Envy i7
 */
public interface IMasterMind {
    //nombre de couleurs générées par l'ordinateur
      static final int cte=4;
    //les couleurs de bases
     static final char [] tab={'R','J','B','O','V','N'};
     //le nombre total de tour 
     static final int tour=10;
     //la valeur trouvée
     static final char bienPlace='W';
     //la valeur mal placée
     static final char malPlace='Z';
     
     //les fonctions à implémenter
    public char[] generer();
    public boolean verifier(char[] tab,String saisie );
    public int position (char val,char []ge);
    public char[] decomposer(String saisie);
    public int bienTrouver(char []ge,final String saisie);
    public int malTrouver(char []ge,final String saisie);
    public int [] sortie(char [] ge,String saisie);
    public void copier (final char []ge, char [] copie);
    public void afficher (String saisie,int[] retour,int essai);
}
