import java.io.*;

public class LireReseau {
    public static Graphe lire(String fichier_stations, String fichier_connexions){
        GrapheListe g = new GrapheListe();
        try{
            FileReader frStations = new FileReader(fichier_stations);
            BufferedReader brStations = new BufferedReader(frStations);

            String ligneStations = brStations.readLine();

            while(ligneStations != null){
                String[] contenuLigne = ligneStations.split(";");
                if(contenuLigne.length>=5){
                    String id_arret = contenuLigne[0];
                    String nom_arret = contenuLigne[1];
                    String coordonnee_x = contenuLigne[2];
                    String coordonne_y = contenuLigne[3];
                    String nom_ligne = contenuLigne[4];

                }
            }

        }catch (FileNotFoundException e){
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try{
            FileReader frConnexions = new FileReader(fichier_connexions);
            BufferedReader brConnexions = new BufferedReader(frConnexions);

            String ligneConnextions = brConnexions.readLine();

            while(ligneConnextions != null){
                String[] contenuLigne = ligneConnextions.split(";");
                if(contenuLigne.length >=3){
                    String id_arret_depart = contenuLigne[0];
                    String id_arret_arrivee = contenuLigne[1];
                    double distance = Double.parseDouble(contenuLigne[2]);
                    int distanceInt = (int) distance;

                    g.ajouterArc(id_arret_depart, id_arret_arrivee, distanceInt);
                    g.ajouterArc(id_arret_arrivee, id_arret_depart, distanceInt);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return g;
    }
}
