/**
 * Classe Addition - Utile pour l'addition de deux nombres.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */
abstract class Addition {

    /**
     * Effectue l'additon du membre de gauche et de droite.
     *
     * @param membreDroit La valeur situé à gauche lors de l'addition.
     * @param membreDroit La valeur situé à droite lors de l'addition.
     * 
     * @return Le résultat de l'addition.
     *
     * @since 1.0
     */
    static double addition(double membreDroit, double membreGauche) {
        return membreDroit + membreGauche;
    }

}