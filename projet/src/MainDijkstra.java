import java.util.List;

public class MainDijkstra {
    public static void main(String[] args) {
        //Création d'un graphe
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A","B",12);
        g.ajouterArc("A","D",87);
        g.ajouterArc("B","E",11);
        g.ajouterArc("C","A",19);
        g.ajouterArc("D","B",23);
        g.ajouterArc("D","C",10);
        g.ajouterArc("E","D",43);
        System.out.println("Le graphe : ");
        System.out.println(g);

        //Affiche le chemin le plus cours des noeuds depuis le noeud A
        Dijkstra dijkstra = new Dijkstra();
        Valeurs res = dijkstra.resoudre(g, "A");
        System.out.println("Chemin le plus court depuis le noeud A : ");
        System.out.println(res.toString());

        //Affichage du chemin le plus court pour une paire de noeud donnée : A,E
        String cheminAdeterminer = "E";

        List<String > chemin = res.calculerChemin(cheminAdeterminer);
        System.out.println("Chemin le plus court pour la paire de noeuds A,E : ");
        //Chemin trouvé :
        System.out.println("Chemin : " + chemin);
        //Coût du chemin :
        System.out.println("Coût : " + res.getValeur(cheminAdeterminer));
    }
}
