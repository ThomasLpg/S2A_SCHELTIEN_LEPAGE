import javax.swing.*;
import java.util.ArrayList;

public class BellmanFord {
    public Valeurs resoudre(Graphe g, String depart){

        Valeurs valeurs = new Valeurs();               //création de l'objet valeur pour les résultats
        ArrayList<String> sommets = g.getNodeList();   //on récupère les noeuds du graphe

        for (String v : sommets){
            valeurs.setValeur(v, Double.MAX_VALUE);     //je mets chaque noeud à la sa valeur max
            valeurs.setParent(v, null);          //je mets les parents à null, on n'a pas encore leurs valeurs
        }
        valeurs.setValeur(depart,0);        //et je mets le noeud de départ à 0

        for (int i = 0; i < sommets.size() -1; i++){
            for (String u : sommets){                   //pour chaque sommet (que je nomme u)
                int indexU = sommets.indexOf(u);        //je cherche leur index
                Arcs arcs = g.getAdjNodeList().get(indexU); //je récupère les sommets adj et je fais des arcs

                for (Arc a : arcs.getListArc()){        //puis pour chaque arc
                    String s = a.getNoeudCible();       // je prends la destination

                    double valeurN = valeurs.getValeur(u) + a.getPoids(); //je prends la valeur de u et le poids de l'arc

                    if (valeurN < valeurs.getValeur(s)){ //je fais des comparaisons si je trouve un chemin plus court / moins lourd
                        valeurs.setValeur(s, valeurN);   //je remplace la valeur
                        valeurs.setParent(s,u);          //et le parent
                    }
                }
            }
        }
    return valeurs;
    }
}
