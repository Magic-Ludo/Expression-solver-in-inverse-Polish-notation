/**
 * Classe Main - Classe principale pour le lancement du programme.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019 
 */

import java.util.HashMap;
import java.util.Map;

public class Main {

    /**
     * <p>
     * Méthode main principale.
     * </p>
     *
     * @return Juste de l'affichage et de l'appel aux autres méthodes.
     * 
     * @see Saisie#Saisie()
     * @see Saisie#Saisie(Map<String, Double>, int, ArrayList<String>)
     * @see Saisie#retourSaisie()
     * @see Saisie#retourMap()
     * @see Noeud#Noeud()
     * @see Noeud#Affiche(Noeud)
     * @see Expressions#lireExpr()
     * @see Expressions#ajouteVar(Noeud, Map<String, Double>)
     * @see Expressions#executerArbre(Noeud) 
     *
     * @since 1.0
     */
    public static void main(String[] args) {

        // Initialisation d'une HashMap.
        Map<String, Double> map = new HashMap<>();

        // Récupération de la saisie utilisateur et affichage.
        Saisie saisie = new Saisie();
        Expressions.st = saisie.retourSaisie();

        // Création du noeud "graine".
        Noeud root = new Noeud();

        // Récupération du nombre de variables présent dans l'expression.
        int nbVariables = Noeud.Affiche(root = Expressions.lireExpr());

        // Récupération des valeurs saisies par l'utilisateur.
        Saisie saisie2 = new Saisie(map, nbVariables, Noeud.variables);
        map = saisie2.retourMap();

        // On remplace les variables par les valeurs saisies.
        Expressions.ajouteVar(root, map);
        System.out.println("\nLe resultat est : " + Expressions.executerArbre(root));
    }
}