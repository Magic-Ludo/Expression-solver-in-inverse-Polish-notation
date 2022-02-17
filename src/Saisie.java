/**
 * Classe Saisie - Permet de gérer la saisie de l'utilisateur.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Saisie {

    /**
     * <p>
     * Chaine de caractère où sera stocké l'expression préfixé saisie par
     * l'utilisateur.
     * </p>
     *
     * @see Saisie#saisie()
     */
    String saisie;

    /**
     * <p>
     * stringTk est une StringTokenizer où est mis la String saisie.
     * </p>
     *
     * @see Saisie#retourSaisie()
     * 
     */
    StringTokenizer stringTk;

    /**
     * <p>
     * La Hashmap map stocke la valeur numérique (qui est saisie par l'utilisateur)
     * en fonction des variables présentes dans l'espression.
     * </p>
     * 
     * @see Saisie#retourMap()
     */
    Map<String, Double> map;

    /**
     * <p>
     * L'ArrayList<String> variables stocke de manière temporaire les variables
     * associées à l'expression au fur et à mesure de la construction de l'arbre.
     * </p>
     * 
     * @see Saisie#saisie()
     */
    static ArrayList<String> variables;

    /**
     * Constructeur Saisie.
     *
     * <p>
     * Affiche les spécificitées de notre programme.
     * </p>
     * <p>
     * Demande à l'utilisateur de saisir une expression pour ensuite la stocker dans
     * une String. Puis faire passer la String en StringTokenizer en remplaçant les
     * caractères génant comme les parenthèses par des espaces et les virgules par
     * de points.
     * 
     * </p>
     */
    Saisie() {
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║               ███    ███ ███████ ███████              ║");
        System.out.println("║               ████  ████ ██      ██                   ║");
        System.out.println("║               ██ ████ ██ █████   ███████              ║");
        System.out.println("║               ██  ██  ██ ██           ██              ║");
        System.out.println("║               ██      ██ ███████ ███████              ║");
        System.out.println("║                                                       ║");
        System.out.println("║                 Math Expression Solver                ║");
        System.out.println("║                                                       ║");
        System.out.println("║Ce programme vous permet de saisir une expression en   ║");
        System.out.println("║notation préfixée, comme vous pouvez le voir :         ║");
        System.out.println("║   (*(+(/(- 9 a) -6) Bob) 27,63)                       ║");
        System.out.println("║ = ((((9 - a) / (-6)) + Bob) * 27.63)                  ║");
        System.out.println("║                                                       ║");
        System.out.println("║Vous pouvez donc saisir ou non des variables avec ou   ║");
        System.out.println("║sans majuscules. Suivez le processus de résolution de  ║");
        System.out.println("║votre formule. Notez que pour les nombres à virgule,   ║");
        System.out.println("║lors de l'affectation aux variables, vous devez les    ║");
        System.out.println("║saisir avec une virgule (,) et non un point (.)        ║");
        System.out.println("║Faites crtl + c pour quitter le programme.             ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝");
        System.out.println("\n\nVeuillez saisir une expression :");
        Scanner sc = new Scanner(System.in);
        saisie = sc.nextLine();
        // sc.close();

        stringTk = new StringTokenizer(saisie.replaceAll("[()]", " ").replaceAll(",", "."), " ");

    }

    /**
     * Constructeur Saisie.
     * <p>
     * Demande à l'utilisateur de saisir les valeurs des n variables se trouvant
     * dans son expression. Puis intègre ces valeur à leurs clés respective dans la
     * HashMap.
     * </p>
     *
     * @param map         Une hashMap qui va contenir les variables et leurs
     *                    valeurs.
     * @param nbVariables Le nombres de variables à renseigner.
     * @param variables   La liste de toutes les variables rentrées dans
     *                    l'expression initiale.
     * 
     * @exception InputMismatchException()
     */
    Saisie(Map<String, Double> map, int nbVariables, ArrayList<String> variables) {
        this.map = map;
        Scanner sc = new Scanner(System.in);

        if (nbVariables == 0) {
            System.out.println("\n\nIl n'y a aucune variables dans votre expression...\n\n");
        } else if (nbVariables == 1) {
            System.out.println("\n\nIl y a une seule variable dans votre expression...\n\n");
            System.out.println("Donnez une valeur à la variable : ");
        } else {
            System.out.println("\n\nIl y a : " + nbVariables + " variables dans votre expression...\n\n");
            System.out.println("Donnez une valeur aux variables : ");
        }

        for (int i = 0; i < nbVariables; i++) {

            System.out.print(variables.get(i) + " = ");
            try {
                map.put(variables.get(i), (double) sc.nextDouble());
            } catch (InputMismatchException e) {
                throw new InputMismatchException(
                        "Utilisez des virgules (,) plutôt que des points lors du remplissage des variables.");
            }

        }
        sc.close();
    }

    /**
     * Renvoie le StringTokenizer en cours.
     *
     * @return Le StringTokenizer en cours.
     */
    public StringTokenizer retourSaisie() {
        return stringTk;
    }

    /**
     * Renvoie la HashMap en cours.
     *
     * @return La HashMap en cours.
     */
    public Map<String, Double> retourMap() {
        return map;
    }
}