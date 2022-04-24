/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.commande;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.commandeService;

/**
 * FXML Controller class
 *
 * @author khouloud
 */
public class ModifCCFXMLController implements Initializable {

    private TableView<commande> table_commande;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_id_user_id;

    @FXML
    private DatePicker txt_date_cmd;

    @FXML
    private TextField txt_image;

    @FXML
    private TextField txt_statut;

    @FXML
    private Button modifier;

    @FXML
    private Button afficher;

    commandeService ss = new commandeService();

    commande CurrentCommande = AfficherCFXMLController.c;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        txt_id.setText(String.valueOf(CurrentCommande.getId()));
        txt_id_user_id.setText(String.valueOf(CurrentCommande.getId_user_id()));
        //  txt_date_cmd.setValue(CurrentCommande.getDate_cmd());
        txt_image.setText((CurrentCommande.getImage()));
        txt_statut.setText((CurrentCommande.getStatut()));

    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {

        CurrentCommande.setId_user_id(txt_id_user_id.getText());
     //   CurrentCommande.setDate_cmd(String.valueOf(txt_date_cmd.getValue()));
        CurrentCommande.setImage(txt_image.getText());
        CurrentCommande.setStatut(txt_statut.getText());
        ss.modifierCommande(CurrentCommande, CurrentCommande.getId());
        System.out.println("gui.ModifCCFXMLController.modifier()"+(CurrentCommande));
        Parent root = FXMLLoader.load(getClass().getResource("AfficherCFXML.fxml"));
        afficher.getScene().setRoot(root);
       
    }

    @FXML
    private void afficher(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherCFXML.fxml"));
            afficher.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
