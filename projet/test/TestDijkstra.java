import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestDijkstra {
    @Test
    public void testCheminPlusCourtDijkstra(){
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A", "B", 12);
        g.ajouterArc("A", "D", 87);
        g.ajouterArc("B", "E", 11);
        g.ajouterArc("C", "A", 19);
        g.ajouterArc("D", "B", 23);
        g.ajouterArc("D", "C", 10);
        g.ajouterArc("E", "D", 43);

        Dijkstra d = new Dijkstra();
        Valeurs res = d.resoudre(g, "A");

        assertEquals(0.0, res.getValeur("A"));
        assertEquals(12.0, res.getValeur("B"));
        assertEquals(76.0, res.getValeur("C"));
        assertEquals(66.0, res.getValeur("D"));
        assertEquals(23.0, res.getValeur("E"));
    }

    @Test
    public void testCheminLuiMeme(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("B", "C", 87);

        Dijkstra d = new Dijkstra();
        Valeurs res = d.resoudre(g, "B");


        assertEquals("Le coût du chemin de B vers B dois etre null",
                0.0, res.getValeur("B"));
        assertEquals("Le noeud B, le départ, doit etre null",
                null, res.getParent("B"));
    }

    @Test
    public void testCheminCasse(){
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 12);
        g.ajouterArc("D", "E", 87);

        Dijkstra d = new Dijkstra();
        Valeurs res = d.resoudre(g, "A");

        assertEquals("Le noeud est coupé du chemin, ca valeur reste a +infini",
                Double.MAX_VALUE, res.getValeur("D"));
        assertEquals("Le noeud est coupé du chemin, ca valeur reste a +infini",
                Double.MAX_VALUE, res.getValeur("E"));
        assertEquals("Le noeud coupe du chemoin n'a pas de parents",
                null, res.getParent("D"));
        assertEquals("Le noeud coupe du chemin n'a pas de parents",
                null, res.getParent("E"));
    }
}
