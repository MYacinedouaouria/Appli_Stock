package com.classes.pack;

import com.implementation.pack.Role;
import com.lowagie.text.Cell;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Produit {

    //les differents attributs
    private int id_produit;
    private String nom_produit;
    private float prix_unitaire;
    private String id_categorie;
    private int quantite;
    private int alert;

    public Produit() {
    }

    public Produit(String nom_produit, float prix_unitaire,
            String id_categorie, int quantite, int alert) {
        super();

        this.nom_produit = nom_produit;
        this.prix_unitaire = prix_unitaire;
        this.id_categorie = id_categorie;
        this.quantite = quantite;
        this.alert = alert;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(String id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getAlert() {
        return alert;
    }

    public void setAlert(int alert) {
        this.alert = alert;
    }

    public static List<String> recherche(String val) {
        // TODO Auto-generated method stub
        List<String> lp = new ArrayList<>();

        SingletonConnecction sg = new SingletonConnecction();
        Connection co = sg.getConnexion();
        int i = 0;
        try {
            PreparedStatement ps;

            ps = co.prepareStatement("select nom_pro from PRODUIT where nom_pro like ?");
            ps.setString(1, "%"+val + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                lp.add(rs.getString("nom_pro"));
                i++;

            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return lp;
    }

    //on surcharve la methose rechercher pour une implementation avec autocompletion
    public static ArrayList<String> recherche() {
        // TODO Auto-generated method stub
        //List<Produit> lp=new ArrayList<>();
        ArrayList<String> ls = new ArrayList<String>();
        SingletonConnecction sg = new SingletonConnecction();
        Connection co = sg.getConnexion();
        try {
            PreparedStatement ps;

            ps = co.prepareStatement("select nom_pro from PRODUIT");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                ls.add(rs.getString("nom_pro"));

            }
            ps.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ls;
    }

    //exportation de la liste des produits
    public static void export_excel(File fichier) {

        Role r = new Role();
        Workbook workbook = null;
        List<Produit> lp = new ArrayList<Produit>();
        Produit p = null;
        int nombre_exportaion = 0;
        int i = 1;
        try {
            /* Récupération du classeur Excel (en lecture) */
            workbook = Workbook.getWorkbook(fichier);

            /* Un fichier excel est composé de plusieurs feuilles, on y accède de la manière suivante*/
            Sheet sheet = workbook.getSheet(0);

            for (i = 1; i < sheet.getRows(); i++) {
                p = new Produit();
                for (int j = 0; j < sheet.getColumns(); j++) {

                    switch (j) {

                        
                        case 0:
                            p.setNom_produit(sheet.getCell(j, i).getContents().toLowerCase());
                            System.out.println(p.getNom_produit());
                            break;
                        case 3:
                            p.setId_categorie(sheet.getCell(j, i).getContents().toLowerCase());
                            break;
                        case 2:
                            p.setPrix_unitaire(Float.parseFloat(sheet.getCell(j, i).getContents().trim()));

                            break;
                        case 1:
                            p.setQuantite(Integer.parseInt(sheet.getCell(j, i).getContents()));
                            break;
                        case 4:
                            p.setAlert(Integer.parseInt(sheet.getCell(j, i).getContents()));
                            break;
                        default:
                            System.out.println("rien" + j);
                    }

                }
                    if(!p.getId_categorie().equals("layette")){
                        p.setNom_produit(p.getId_categorie()+" "+p.getNom_produit());
                    }
                if (!r.produit_existe(p.getNom_produit())) {
                    if (r.ajouter_produit(p)) {
                        nombre_exportaion++;
                    }
                }

            }
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                /* On ferme le worbook pour libérer la mémoire */
                workbook.close();

            }
        }

        JOptionPane.showMessageDialog(null, "vous avez pu exporter en terme de produit: " + nombre_exportaion + "/" + (i - 1));

    }
}
