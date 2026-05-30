import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestBellmanFord {

    @Test
    public void testBellmanFord1(){
        GrapheListe g = new GrapheListe();

        g.ajouterArc("A","B",3);
        g.ajouterArc("B","C",2);
        g.ajouterArc("C","D",3);

        BellmanFord bmf = new BellmanFord();

        Valeurs v = bmf.resoudre(g, "A"); // g = nom du graphe et "A" = noeud de départ

        assertEquals(0.0, v.getValeur("A")); //0 car c'est le point de départ
        assertEquals(3.0, v.getValeur("B")); //3 car c'est la valeur de l'arc
        assertEquals(5.0, v.getValeur("C")); //5 car on ajoute l'arc suivant
        assertEquals(8.0, v.getValeur("D")); //8 car on ajoute l'arc suivant

        assertEquals("A", v.getParent("B")); //je vérifie le parent de B
        assertEquals("B", v.getParent("C")); //je vérifie le parent de C
        assertEquals("C", v.getParent("D")); //je vérifie le parent de D

        assertEquals("[A, B, C, D]", v.calculerChemin("D").toString());
    }
}
