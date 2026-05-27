import java.util.ArrayList;

public class GrapheListe implements Graphe{
    ArrayList<String> nodeList;

    ArrayList<Arcs> adjNodeList;

    @Override
    public ArrayList<String> getNodeList() {
        return nodeList;
    }

    @Override
    public ArrayList<Arcs>getAdjNodeList() {
        return adjNodeList;
    }

    public void ajouterArc(String source, String dest, int poids){
        
    }


}
