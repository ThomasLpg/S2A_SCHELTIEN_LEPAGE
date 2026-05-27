import java.util.ArrayList;

/**
 * Classe qui décrit les graphes en fonction des listes de noeud et de liste de leur adjacent
 */
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

    /**
     * Méthode qui ajoute ou modifie l'objet Arcs des noeuds en fonction de la source de la destination et du poids
     * @param source noeud source
     * @param dest nooeud destination
     * @param poids poids de l'Arc
     */
    public void addNode(String source, String dest, int poids){
        int indexSource = this.nodeList.indexOf(source);
        int indexAdj = this.adjNodeList.size() - 1;

        //Si le tableau d'adjacent est plus petit que le tableau de noeuds :
        if(indexSource > indexAdj){
            //On doit creer un objet Arcs
            Arcs arcs = new Arcs();
            //On creer un objet Arc qu'on ajoute a la liste d'arc de Arcs
            arcs.ajouterArc(new Arc(dest, poids));
            //On ajoute l'objet Arc a la lste d'adjacent
            this.adjNodeList.add(indexSource, arcs);
        } else{
            //On a juste a ajouter un nouvel objet Arc a notre liste d'arc dans l'objet Arcs qui existe deja
            this.adjNodeList.get(indexSource).getListArc().add(new Arc(dest, poids));
        }

    }

    /**
     * Méthode ajouterArc, ajoute un Arc, en fonction du noeud source, destination et du poids de l'arc
     * @param source noeud source
     * @param dest noeud destination
     * @param poids poids de l'Arc
     */
    public void ajouterArc(String source, String dest, int poids) {
        //Si le noeud source et destination existe dans la liste de noeud
        if (this.nodeList.contains(source) && this.nodeList.contains(dest)){
            //On a juste a modifier la liste d'Arc dans l'objet Arcs dans la liste d'adjacent
            addNode(source, dest, poids);
        //Sinon si le noeud source existe mais pas le noeud destination dans la liste de noeud
        } else if (this.nodeList.contains(source) && !(this.nodeList.contains(dest))) {
            //On doit ajouter le noeud destination a la liste de noeud
            this.nodeList.add(dest);
            //modifier la liste d'Arc dans l'objet Arcs dans la liste d'adjacent
            addNode(source, dest, poids);
            //On ajoute un nouvel objet Arcs dans la liste d'adjacent, qui sera au meme index que le noeud destination
            //dans la la liste de noeud
            this.adjNodeList.add(new Arcs());
        //Sinon si ni la source ni la destination existe dans la liste de noeud
        }else if (!(this.nodeList.contains(source)) && !(this.nodeList.contains(dest))){
            //On ajoute les deux a la liste de noeuds
            this.nodeList.add(source);
            this.nodeList.add(dest);
            //modifier la liste d'Arc dans l'objet Arcs dans la liste d'adjacent
            addNode(source, dest, poids);
            //On ajoute un nouvel objet Arcs dans la liste d'adjacent, qui sera au meme index que le noeud destination
            //dans la la liste de noeud
            this.adjNodeList.add(new Arcs());
        } else{
            //Si la source n'existe pas dans la liste de noeud mais que la destination existe,
            //On ajoute la source dans la liste de noeud
            this.nodeList.add(source);
            //modifier la liste d'Arc dans l'objet Arcs dans la liste d'adjacent
            addNode(source, dest, poids);
        }
    }

    /**
     * Méthode toString affiche le contenu d'un graphe
     * @return une chaine de caractère
     */
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

