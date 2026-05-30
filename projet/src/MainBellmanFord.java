public class MainBellmanFord {
    public static void main(String[] args){

        GrapheListe g = new GrapheListe();

        g.ajouterArc("A","B",3);
        g.ajouterArc("B","C",2);
        g.ajouterArc("C","D",3);
        g.ajouterArc("D","E",1);
        g.ajouterArc("A","C",4);
        g.ajouterArc("B","E",5);
        g.ajouterArc("C","E",4);

        System.out.println(g); //j'affiche le graphe

        BellmanFord bmf = new BellmanFord();
        Valeurs valeurs = bmf.resoudre(g,"A"); //je le résous

        System.out.println(valeurs); //je l'affiche

        System.out.println(valeurs.calculerChemin("E")); //j'affiche le chemin
    }
}
