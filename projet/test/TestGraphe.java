import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertEquals;

public class TestGraphe {

    @Test
    public void testGrapheExemple() {
        GrapheListe graphe = new GrapheListe();

        graphe.ajouterArc("A", "B", 12);

        System.out.println(graphe);

        assertEquals("A -> B(12)\nB -> \n", graphe.toString());
    }

    @Test
    public void testGrapheVide(){
        GrapheListe graphe2 = new GrapheListe();

        try{
            graphe2.ajouterArc(null, null, 0);
        }
        catch (NullPointerException npe){
            System.out.println("Erreur : graphe vide");
        }
    }

    @Test
    public void TestGrapheLuiMeme(){

        GrapheListe graphe3 = new GrapheListe();

        graphe3.ajouterArc("A","A",0);

        System.out.println(graphe3);

        assertEquals("A -> A(0)\nA -> \n",graphe3.toString());

    }
}
