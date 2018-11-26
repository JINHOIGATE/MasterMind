/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mastermind;

import java.util.Random;

/**
 *
 * @author HP Envy i7
 */
public class ImplementationMstMind implements IMasterMind{
   
    
    @Override
    public char[] generer() {
        //couleurs généreés par l'ordinateur
        char [] ge=new char[cte];
        //le random en entier
        Random rd=new Random();
        for (int i=0; i<cte;i++){
            ge[i]=tab[rd.nextInt(6)];
        }
        //choix des couleurs générées
        return ge;
    }

    @Override
    public boolean verifier(char[] tab, String saisie) {
        char [] saisie1;
        boolean continuer=true,trouve=false;
        //Condition déjà sur la longueur du choix des couleurs qui doit être = 4
        if (saisie.length()!=4)
            continuer=false;
        else {//si la longueur du choix egal à 4, on vérifie maintenant l'existance des couleurs RJBOVN
           saisie1=decomposer(saisie);
            for (int u=0;u<saisie1.length;u++){//On parcourt les choix de couleur de l'utilisateur
                trouve=false;
                for (int i=0;i<tab.length;i++){//On parcourt les couleurs de base
                        if (saisie1[u]==tab[i])//on vérifie si le choix de couleur de l'utilisateur fait parti des couleurs de base
                            trouve=true;
                }
                if (!trouve) {//On sort de la 1er boucle lorsque le choix de l'utilisateur ne figure pas dans les couleurs de base
                    continuer=false;
                     break;
                }
            }
        }
        return continuer;
    }

   

    @Override
    public void afficher(String saisie, int[] retour,int essai) {
        String saisie1=saisie.toUpperCase();
        System.out.println("|-------------------- |");
        System.out.println("|"+saisie1+"|"+" "+retour[0]+" "+"|"+" "+retour[1]+" "+"|"+" "+essai+"/"+tour+" "+"|");
        System.out.println("|---------------------|");
        
    }

    @Override
    public int position(char val, char[] ge) {
        int i=0;
        while (i<cte && val!=ge[i])
            i++;
        return (i<cte?i:-1);
    }

    @Override
    public char[] decomposer(String saisie) {
        String saisie1=saisie.toUpperCase();
        char retour[]=new char [cte];
        for (int i=0;i<cte;i++)
            retour[i]=saisie1.charAt(i);
        return retour;
    }



    @Override
    public int bienTrouver(char[] ge, final String saisie) {
        int c1=0;
        for (int i=0;i<cte;i++)
            if (ge[i]==decomposer(saisie)[i]){
                c1++;
                ge[i]=bienPlace;
            }
        return c1;
    }

    @Override
    public int malTrouver(char[] ge,final  String saisie) {
          int p;
          int c2=0;
        for (int i=0;i<cte;i++)
            if (ge[i]!=bienPlace){
                p=position(decomposer(saisie)[i], ge);
                if (p!=-1){
                    c2++;
                    ge[i]=malPlace;
                }
            }
        return c2;
    }

    @Override
    public int[] sortie(char[] ge,String saisie) {
        int c1=0;
        int c2=0;
        int tab[]=new int [2];
        char copie[]=new char [cte];
        copier(ge,copie);
        c1=bienTrouver(copie, saisie);
        c2=malTrouver(copie, saisie);
        tab[0]=c1;
        tab[1]=c2;
        return tab;
    }

    @Override
    public void copier(final char[] ge, char[] copie) {
        for (int i=0;i<cte;i++)
            copie[i]=ge[i];
    }
    
}
