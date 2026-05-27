import org.junit.jupiter.api.Test;

public class TestGraphe {

        @Test
        public void testGrapheExemple() {
            GrapheListe graphe = new GrapheListe();

            graphe.ajouterArc("A", "B", 12);
            graphe.ajouterArc("A", "D", 87);
            graphe.ajouterArc("B", "E", 11);
            graphe.ajouterArc("C", "A", 19);
            graphe.ajouterArc("D", "B", 23);
            graphe.ajouterArc("D", "C", 10);
            graphe.ajouterArc("E", "D", 43);


            System.out.println(graphe);
        }
}
