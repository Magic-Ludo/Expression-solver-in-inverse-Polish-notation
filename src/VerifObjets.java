/**
 * Classe VerifObjets - Permet de connaître le type de notre élément.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */
public class VerifObjets {

    /**
     * Elément contenue dans le VerifObjets.
     * 
     * @since 1.0
     */
    String element1;

    /**
     * Constructeur VerifObjets par défaut.
     * 
     * @since 1.0
     */
    VerifObjets() {

    }

    /**
     * Constructeur VerifObjets.
     * <p>
     * Créé un VerifObjets ayant pour élément un String.
     * </p>
     * 
     * @since 1.0
     */
    VerifObjets(String element1) {
        this.element1 = element1;
    }

    /**
     * Renvoie true si l'élément est un symbole d'opération binaire, false sinon.
     * 
     * @return true si l'élément est un symbole d'opération binaire, false sinon.
     *
     * @since 1.0
     */
    public boolean estOperation() {

        if (element1.equals("+") || element1.equals("*") || element1.equals("/") || element1.equals("-")
                || element1.equals("^")) {
            return true;
        }

        else {
            return false;
        }
    }

    /**
     * Renvoie true si l'élément est un symbole numérique ou une chaine de symbole numérique, false sinon.
     * 
     * @return true si l'élément est un symbole numérique ou une chaine de symbole numérique, false sinon.
     *
     * @since 1.0
     */
    public boolean estNumerique() {
        int i = 0;
        char[] chaineTab = element1.toCharArray();

        while (i < chaineTab.length) {
            // System.out.println("Objet analysé :" + (int)chaineTab[i] + "~");
            if (((int) chaineTab[i] < 48 || (int) chaineTab[i] > 57) && chaineTab[i] != '.') {
                return false;
            }
            i++;
        }

        return true;
    }

    /**
     * Renvoie true si l'élément est un symbole numérique négatif ou une chaine de symbole numérique négative, false sinon.
     * 
     * @return true si l'élément est un symbole numérique ou une chaine de symbole numérique, false sinon.
     *
     * @since 1.0
     */
    public boolean estNumeriqueNeg() {
        int i = 0;
        char[] chaineTab = element1.toCharArray();

        while (i < chaineTab.length) {
            // System.out.println("Objet analysé :" + (int)chaineTab[i] + "~");
            if (chaineTab[0] == '-' && ((int) chaineTab[i] < 48 || (int) chaineTab[i] > 57) && chaineTab[i] != '.') {
                return true;
            }
            i++;
        }

        return false;
    }

    /**
     * Renvoie true si l'élément est un symbole alphabétique ou une chaine de symbole alphabétique, false sinon.
     * 
     * @return true si l'élément est un symbole alphabétique ou une chaine de symbole alphabétique, false sinon.
     *
     * @since 1.0
     */
    public boolean estTexte() {
        int i = 0;
        char[] chaineTab = element1.toCharArray();

        while (i < chaineTab.length) {
            // System.out.println("Objet analysé :" + (int)chaineTab[i] + "~");
            if (((int) chaineTab[i] < 65 || (int) chaineTab[i] > 90)
                    && ((int) chaineTab[i] < 97 || (int) chaineTab[i] > 122)) {
                return false;
            }
            i++;
        }

        return true;
    }

}