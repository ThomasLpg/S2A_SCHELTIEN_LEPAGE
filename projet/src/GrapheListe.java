import javax.crypto.spec.DESedeKeySpec;
import java.util.AbstractList;
import java.util.ArrayList;

public class GrapheListe implements Graphe {
    ArrayList<String> nodeList = new ArrayList<>();
    ArrayList<Arcs> adjNodeList = new ArrayList<>();

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

        int indexAdj = this.adjNodeList.size() - 1;

        if(indexSource > indexAdj){
            Arcs arcs = new Arcs();
            arcs.ajouterArc(new Arc(dest, poids));
            this.adjNodeList.add(indexSource, arcs);
        } else{
            this.adjNodeList.get(indexSource).getListArc().add(new Arc(dest, poids));
        }

    }

    public void ajouterArc(String source, String dest, int poids) {
        //Si le noeud source existe  :
        if (this.nodeList.contains(source) && this.nodeList.contains(dest)){
            //On lui raccorde une destination a sa liste d'adjacent
            addNode(source, dest, poids);
        //Sinon
        } else if (this.nodeList.contains(source) && !(this.nodeList.contains(dest))) {
            this.nodeList.add(dest);
            addNode(source, dest, poids);
            this.adjNodeList.add(new Arcs());

        }else if (!(this.nodeList.contains(source)) && !(this.nodeList.contains(dest))){
            this.nodeList.add(source);
            this.nodeList.add(dest);
            addNode(source, dest, poids);
            this.adjNodeList.add(new Arcs());
        } else{
            this.nodeList.add(source);
            addNode(source, dest, poids);
        }
    }

    public String toString(){
        String res = "";

        for (int i = 0; i < this.nodeList.size(); i++) {
            res += getNodeList().get(i);
            res += " ->";
                res += " " + this.adjNodeList.get(i).toString();

            res+="\n";
        }
        return res;
    }
}

