import java.util.List;

public class MainTransport {
    public static void main(String[] args) {
        if(!(args.length < 2)){
            String depart = args[0];
            String arrivee = args[1];

            String fichierStations = "./stan.nodes.txt";
            String fichierConnexions = "./stan.edges.txt";

            Graphe g = LireReseau.lire(fichierStations, fichierConnexions);

            System.out.println("Pour l'algorithlme de Dijkstra : ");

            long startTime = System.nanoTime();

            Dijkstra dijkstra = new Dijkstra();
            Valeurs res = dijkstra.resoudre(g, depart);

            double log42 = Math.log(42);
            long endTime = System.nanoTime();
            System.err.println("Temps exécution : " + (endTime - startTime) + " ns");

            if(res.getValeur(arrivee)==Double.MAX_VALUE){
                System.out.println("Aucun chemin trouvé");
            }else{
                List<String> cheminTrouve = res.calculerChemin(arrivee);

                String resultat = String.join(";", cheminTrouve);
                System.out.println(resultat);
            }


            System.out.println("Pour l'algorithlme de BellmanFord : ");
            long startTime2 = System.nanoTime();

            BellmanFord bmf = new BellmanFord();
            Valeurs resBmf = bmf.resoudre(g, depart);
            double log42_ = Math.log(42);
            long endTime2 = System.nanoTime();
            System.err.println("Temps exécution : " + (endTime2 - startTime2) + " ns");

            if(resBmf.getValeur(arrivee) == Double.MAX_VALUE){
                System.out.println("Aucun chemin trouvé");
            } else{
                List<String> cheminTrouve = res.calculerChemin(arrivee);

                String resultat = String.join(";", cheminTrouve);
                System.out.println(resultat);
            }

        }else{
            System.out.println("Indiquez le nom de départ et le nom d'arrivé en paramètre");
        }
    }
}
