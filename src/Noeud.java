/**
 * Classe Noeud - Gère la créeation et l'affichage des Noeuds.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */

import java.util.ArrayList;

/**
 * <b>Noeud est la classe représentant un Noeud d'un arbre binaire.</b>
 * <p>
 * Un Noeud est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un élément qui le représente.</li>
 * <li>Un fils gauche pouvant être un noeud ou une feuille (noeud avec des fils
 * égaux à null).</li>
 * <li>Un fils droit pouvant être un noeud ou une feuille (noeud avec des fils
 * égaux à null).</li>
 * </ul>
 * </p>
 * 
 */
public class Noeud {

    /**
     * Element contenu dans le noeud.
     * 
     * @since 1.0
     */
    String element;

    /**
     * Fils gauche et droit du noeud.
     *
     * <p>
     * Ils sont eux aussi des noeuds. Si leurs fils sont null ils seront considéré
     * comme des feuilles dans l'arbre.
     * </p>
     * 
     * @since 1.0
     */
    Noeud gauche, droit;

    /**
     * Nombre de variables dans l'expression de l'utilisateur.
     *
     * <p>
     * Initialisé à 0 et incrémenté de 1 à chaque variable se trouvant dans
     * l'expression saisie par l'utilisateur.
     * </p>
     * 
     * @see Saisie#Affiche(Noeud)
     *
     * @since 1.0
     */
    static int nbVariables = 0;

    /**
     * Liste de String.
     *
     * <p>
     * Liste dans laquel les variables vont être stocké jusqu'à ce que l'utilisateur
     * entre leurs valeurs.
     * </p>
     * 
     * @see Saisie#Affiche(Noeud)
     *
     * @since 1.0
     */
    static ArrayList<String> variables = new ArrayList<String>();

    /**
     * Constructeur Noeud.
     * <p>
     * Créé un Noeud vide.
     * </p>
     * 
     * @since 1.0
     */
    Noeud() {
    }

    /**
     * Constructeur Noeud.
     * <p>
     * Créé un Noeud avec des fils initialisés à null.
     * </p>
     * 
     * @param element L'élément que l'on veut attribuer au noeud.
     * 
     * @see Saisie#element
     * @see Saisie#gauche
     * @see Saisie#droit
     *
     * @since 1.0
     */
    Noeud(String element) {
        this.element = element;
        droit = gauche = null;
    }

    /**
     * Constructeur Noeud.
     * <p>
     * Créé un Noeud avec un noeud dans son fils gauche et son fils droit initialisé
     * à null.
     * </p>
     * 
     * @param element L'élément que l'on veut attribuer au noeud.
     * @param gauche  Attribut que l'on place dans le fils gauche du noeud.
     *
     * @see Saisie#element
     * @see Saisie#gauche
     * @see Saisie#droit
     *
     * @since 1.0
     */
    Noeud(String element, Noeud gauche) {
        this.element = element;
        this.gauche = gauche;
        droit = null;
    }

    /**
     * Constructeur Noeud.
     * <p>
     * Créé un Noeud avec des noeud dans ses 2 fils.
     * </p>
     * 
     * @param element L'élément que l'on veut attribuer au noeud.
     * @param gauche  Attribut que l'on place dans le fils gauche du noeud.
     * @param droit   Attribut que l'on place dans le fils droit du noeud.
     *
     * @see Saisie#element
     * @see Saisie#gauche
     * @see Saisie#droit
     *
     * @since 1.0
     */
    Noeud(String element, Noeud gauche, Noeud droit) {
        this.element = element;
        this.gauche = gauche;
        this.droit = droit;
    }

    /**
     * Affiche l'élément d'un noeud.
     *
     * <p>
     * On créé un objet VerifObjets que l'on initialise avec l'élément de notre
     * noeud. Si l'élément est une opération, on ouvre une parenthèse, on fait un
     * appele récursif sur cette méthode pour le fils gauche, on affiche l'élément,
     * on fait un appele récursif sur cette méthode pour le fils droit, puis on
     * ferme la parenthèse. Si l'élément est une valeur numérique négative on
     * affiche l'élément entre parenthèse. Si l'élément est une lettre ou une suite
     * de lettre alors on augmente nbVariables et on affiche l'élément. Sinon on
     * affiche l'élément.
     * </p>
     *
     * @param noeud Le noeud dont on veut afficher l'élément.
     * 
     * @return Le nombre de variable dans l'expression rentré par l'utilisateur.
     *
     * @see Saisie#nbVariables
     * @see VerifObjets#estTexte()
     * @see VerifObjets#estOperation()
     * @see VerifObjets#estNumeriqueNeg()
     *
     * @since 1.0
     */
    public static int Affiche(Noeud noeud) {

        if (noeud != null) {
            VerifObjets verif = new VerifObjets(noeud.element);

            if (verif.estTexte()) {
                nbVariables++;
                variables.add(noeud.element);
            }

            if (verif.estOperation()) {
                System.out.print("(");
                Affiche(noeud.gauche);

                System.out.print(noeud.element);
                Affiche(noeud.droit);
                System.out.print(")");
            } else if (verif.estNumeriqueNeg()) {
                System.out.print("(" + noeud.element + ")");
            }

            else {
                System.out.print(noeud.element);
            }
        }
        return nbVariables;
    }

}
