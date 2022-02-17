/**
 * Classe Expressions - Gère la création de l'abre noeuds après noeuds.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019 
 */

import java.util.Map;
import java.util.StringTokenizer;

abstract class Expressions {

    /**
     * Permet de stocker l'expression de l'utilisateur.
     * 
     * @see Main#main
     *
     * @since 1.0
     */
    static StringTokenizer st;

    /**
     * <p>
     * Permet d'obtenir l'expression suivante de la ligne qui a été lu.
     * </p>
     *
     * @return Le prochain groupe de mot ou une chaine vide.
     * 
     * @since 1.0
     */
    static String exprSuivante() {
        if (st.hasMoreTokens())
            return st.nextToken();
        else
            return "";
    }

    /**
     * <p>
     * Permet la lecture des entrées en ordre prefixe et la construction de l'arbre.
     * </p>
     *
     * @return Un nouveau noeud.
     * 
     * @exception NumberFormatException
     * 
     * @see VerifObjets#estTexte()
     * @see VerifObjets#estOperation()
     * @see VerifObjets#estNumerique()
     * @see VerifObjets#estNumeriqueNeg()
     * @see Noeud#Noeud()
     * @see Noeud#Noeud(String, Noeud, Noeud)
     *
     * @since 1.0
     */
    static Noeud lireExpr() {

        String expr = exprSuivante();
        // Instanciation d'un nouvel objet vérifiable.
        VerifObjets verification = new VerifObjets(expr);

        if (verification.estOperation())
            return new Noeud(expr, lireExpr(), lireExpr());
        else {
            try {
                if (verification.estTexte() || verification.estNumerique() || verification.estNumeriqueNeg()) {
                    return new Noeud(expr);

                } else {
                    // Récupération de l'erreur si l'utilisateur n'a pas bien fait sa saisie.
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Vérifiez si votre syntaxe est correcte !");
            }

        }

    }

    /**
     * <p>
     * Permet le parcours et le calcul des valeurs dans l'arbre.
     * </p>
     * 
     * @param Noeud Un noeud déjà existant.
     *
     * @return Un nouveau noeud.
     *
     * @see Addition#addition(double, double)
     * @see Division#division(double, double)
     * @see Soustraction#soustraction(double, double)
     * @see Multiplication#multiplication(double, double)
     * 
     * @since 1.0
     */
    static double executerArbre(Noeud arbre) {

        // On teste les différentes options possible pour les opérations binaires.
        if (arbre.element.equals("+")) {
            return Addition.addition(executerArbre(arbre.gauche), executerArbre(arbre.droit));
        }
        if (arbre.element.equals("-")) {
            return Soustraction.soustraction(executerArbre(arbre.gauche), executerArbre(arbre.droit));
        }
        if (arbre.element.equals("*")) {
            return Multiplication.multiplication(executerArbre(arbre.gauche), executerArbre(arbre.droit));
        }
        if (arbre.element.equals("/")) {
            return Division.division(executerArbre(arbre.gauche), executerArbre(arbre.droit));
        }
        if (arbre.element.equals("^")) {
            return Puissance.puissance(executerArbre(arbre.gauche), executerArbre(arbre.droit));
        }

        return Double.valueOf(arbre.element).doubleValue();
    }

    /**
     * <p>
     * Permet de remplacer les variables dans l'arbre par celles présentes dans la Hashmap.
     * </p>
     * 
     * @param Noeud Un noeud déjà existant.
     * @param Map<String,Double>
     *
     * @return Un nouveau noeud.
     * 
     * @see VerifObjets#estTexte()
     * @see VerifObjets#estOperation()
     *
     * @since 1.0
     */
    public static void ajouteVar(Noeud noeud, Map<String, Double> map) {

        if (noeud != null) {
            // Instanciation d'un nouvel objet vérifiable.
            VerifObjets verif = new VerifObjets(noeud.element);
            if (verif.estOperation()) {
                // On parcours l'arbre.
                ajouteVar(noeud.gauche, map);
                ajouteVar(noeud.droit, map);
            } else if (verif.estTexte()) {
                // On remplace par les valeurs.
                noeud.element = String.valueOf(map.get(noeud.element));
            }
        }
    }

}
