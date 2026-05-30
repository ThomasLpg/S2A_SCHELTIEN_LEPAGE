import java.util.ArrayList;

public class Dijkstra {
     /*
        Entrées :
        G un graphe orienté avec une pondération positive des arcs
        (coût ou poids)
        A un sommet (départ) de G
      */
    public Valeurs resoudre(Graphe g, String depart){
        //Début
        Valeurs valeurs = new Valeurs();

        //Q <- {} // utilisation d'une liste de noeuds à traiter
        ArrayList<String> q = new ArrayList<>();


        //Pour chaque sommet v de G faire
        for(String v : g.getNodeList()){
            //v.valeur <- Infini
            valeurs.setValeur(v, Double.MAX_VALUE);
            //v.parent <- Indéfini
            valeurs.setParent(v, null);
            //Q <- Q U {v} // ajouter le sommet v à la liste Q
            q.add(v);
        //Fin Pour
        }

        //A.valeur <- 0
        valeurs.setValeur(depart, 0.0);


        //Tant que Q est un ensemble non vide faire
        while(!q.isEmpty()){
            //u <- un sommet de Q telle que u.valeur est minimal
            String u = q.get(0);
            double minimalValue = valeurs.getValeur(u);

            for(String v : q){
                if(valeurs.getValeur(v) < valeurs.getValeur(u)){
                    minimalValue = valeurs.getValeur(v);
                    u = v;
                }
            }

            // enlever le sommet u de la liste Q
            //Q <- Q \ {u}
            q.remove(u);

            int placeU = g.getNodeList().indexOf(u);
            Arcs arcU = g.getAdjNodeList().get(placeU);

            //Pour chaque sommet v de Q tel que l'arc (u,v) existe faire
            for(Arc a : arcU.getListArc()){
                String v = a.getNoeudCible();
                if(q.contains(u)){
                    //d <- u.valeur + poids(u,v)
                    double d = valeurs.getValeur(u) + a.getPoids();
                    //Si d < v.valeur
                    if(d < valeurs.getValeur(v)) {
                        // le chemin est plus interessant
                        //Alors v.valeur <- d
                        valeurs.setValeur(v, d);
                        //v.parent <- u
                        valeurs.setParent(v, u);
                        //Fin Si
                    }
                }
            //Fin Pour
            }
        //Fin Tant que
        }
        return valeurs;
    }
    //Fin
}
