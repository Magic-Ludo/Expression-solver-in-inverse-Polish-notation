/**
 * Classe Puissance - Utile pour le calcul d'une puissance.
 * 
 * @author Vincent Boursat & Ludovic Corcos
 * @version Avril 2019
 */
abstract class Puissance {

    /**
     * Calcul le membre de gauche à la puissance membre de droite.
     *
     * @param membreDroit La valeur situé à gauche lors du calcul de la puissance.
     * @param membreDroit La valeur situé à droite lors du calcul de la puissance.
     *
     * @return Le résultat du calcul de la puissance.
     *
     * @since 1.0
     */
    static double puissance(double membreDroit, double membreGauche) {
        return Math.pow(membreDroit, membreGauche);

    }

}