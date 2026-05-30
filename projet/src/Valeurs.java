import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;

/**
 * Classe fournie, permet de stocker des valeurs associées au noeud et
 * des parents
 * - un noeud est represente par un String (son nom)
 * - on accede avec des get (getValeur et getParent)
 * - on modifie avec des set (setValeur et setParent)
 */
public class Valeurs {

    /**
     * attributs pour stocker les informations
     * (type Map = Dictionnaire)
     */
    Map<String, Double> valeur;
    Map<String, String> parent;

    /**
     * constructeur vide (initialise la possibilité de stocker
     * des valeurs)
     */
    public Valeurs() {
        this.valeur = new TreeMap<>();
        this.parent = new TreeMap<>();
    }

    /**
     * permet d'associer une valeur a un nom de noeud (ici L(X))
     *
     * @param nom    le nom du noeud
     * @param valeur la valeur associée
     */
    public void setValeur(String nom, double valeur) {
        // modifie valeur
        this.valeur.put(nom, valeur);
    }

    /**
     * permet d'associer un parent a un nom de noeud (ici parent(X))
     *
     * @param nom    nom du noeud
     * @param parent nom du noeud parent associe
     */
    public void setParent(String nom, String parent) {
        this.parent.put(nom, parent);
    }

    /**
     * accede au parent stocke associe au noeud nom passe en
     * parametre
     *
     * @param nom nom du noeud
     * @return le nom du noeud parent
     */
    public String getParent(String nom) {
        return this.parent.get(nom);
    }


    /**
     * accede a la valeur associee au noeud nom passe en
     * parametre
     *
     * @param nom nom du noeud
     * @return la valeur stockee
     */
    public double getValeur(String nom) {
        return this.valeur.get(nom);
    }

    /**
     * retourne une chaine qui affiche le contenu
     * - par noeud stocke
     * - a chaque noeud, affiche la valeur puis le noeud
     *   parent
     *
     * @return descriptif du noeud
     */
    public String toString() {
        String res = "";
        // pour chaque noeud
        for (String s : this.valeur.keySet()) {
            // ajoute la valeur et le noeud parent
            Double valeurNoeud = valeur.get(s);
            String noeudParent = parent.get(s);
            res += s + " ->  V:" + valeurNoeud + " p:" + noeudParent + "\n";
        }
        return res;

    }
    public List<String> calculerChemin(String destination){
        List<String> cheminNormal = new ArrayList<>(); //objet pour stocker le chemin normal
        List<String> cheminInverse = new ArrayList<>();//objet pour stocker le chemin inverse
        String courant = destination; //je récupère le paramètre que je mets dans courant

        while(courant!=null){
            cheminInverse.add(courant);               //j'ajoute la valeur courante dans inverse
            courant = this.getParent(courant);  //la valeur courante prend la valeur de son parent
        }

        for (int i = cheminNormal.size() -1; i--) {  //je vais "en arrière" dans la liste normale
            cheminInverse.add(cheminInverse.get(i)); //j'ajoute dans le cheminInverse
        }
        return cheminInverse;
    }

}
