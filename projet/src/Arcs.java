import java.util.ArrayList;

public class Arcs {

    private ArrayList<Arc> listeArcs = new ArrayList<>();

    public ArrayList<Arc> listeVide(){
        ArrayList<Arc> listeVide = new ArrayList<>();
        return listeVide;
    }

    public void ajouterArc(Arc a){
        listeArcs.add(a);
    }

    public ArrayList<Arc> getListArc(){
        return this.listeArcs;
    }

    public int tailleList(){
        return this.listeArcs.size();
    }

    public String toString(){
        String res ="";
        for (int i = 0; i < this.listeArcs.size(); i++) {
            res += this.listeArcs.get(i).toString();
        }
        return res;
    }

}
