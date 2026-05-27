import javax.crypto.spec.DESedeKeySpec;
import java.util.AbstractList;
import java.util.ArrayList;

public class GrapheListe implements Graphe {
    ArrayList<String> nodeList;
    ArrayList<Arcs> adjNodeList;

    @Override
    public ArrayList<String> getNodeList() {
        return nodeList;
    }

    @Override
    public ArrayList<Arcs> getAdjNodeList() {
        return adjNodeList;
    }

    public void addNode(String source, String dest, int poids){
        int indexSource = this.nodeList.indexOf(source);

        Arcs arcs = new Arcs();
        arcs.ajouterArc(new Arc(dest, poids));

        this.adjNodeList.add(indexSource, arcs);
    }

    public void ajouterArc(String source, String dest, int poids) {
        //Cas où le noeud source existe dans la liste de noeud et que dans la liste d'adjacence, l'index est deja
        // raccordé au noeud source
        if (this.nodeList.contains(source) && this.nodeList.contains(dest)) {
            addNode(source, dest, poids);
        }else{
            this.nodeList.add(source);
            addNode(source, dest, poids);
        }
    }
}

