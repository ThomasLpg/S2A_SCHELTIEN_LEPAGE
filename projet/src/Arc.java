public class Arc {
    private String noeudCible;
    private int poids;

    public Arc(String nc, int p){
        this.noeudCible = nc;
        if (p < 0){
            this.poids = 0;
        }
        else {
            this.poids = p;
        }
    }

    public String getNoeudCible() {
        return noeudCible;
    }

    public int getPoids() {
        return poids;
    }

    public String toString(){
        String res = "";
        res += this.noeudCible;
        res += "(";
        res += this.poids;
        res += ")";

        return res;
    }

}
