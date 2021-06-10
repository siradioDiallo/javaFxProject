package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Etudiant;
import models.Groupe;

public class MainController implements Initializable {
	
List<Etudiant> etudiants;
List<Groupe> groupes;

   
@FXML
private AnchorPane application;

@FXML
private VBox gpGroupe;

@FXML
private Button btnEtudiant;

@FXML
private Button btnProfesseur;

@FXML
private Button btnGroupe;

@FXML
private Button btnGestionGroupe;

@FXML
private GridPane gpProfesseur;

@FXML
private TableView<?> tvProf;

@FXML
private Button btnSearchProf;

@FXML
private Button btnAddprof;

@FXML
private Button btnModifEtd1;

@FXML
private Button btnDellEtd1;

@FXML
private VBox vbSelectGp;

@FXML
private Button btnOpenModifGp;

@FXML
private Button btnCancelModifGp;

//GESTION ETUDIANT PROPERTIES *********************************************************************

@FXML
private GridPane gpStudent;

@FXML
private TableView<Etudiant> tabViewEtudiant;

@FXML
private TableColumn<Etudiant, Integer> colEtudiantId;

@FXML
private TableColumn<Etudiant, String> colEtudiantNom;

@FXML
private TableColumn<Etudiant, String> colEtudiantPrenom;

@FXML
private TableColumn<Etudiant, String> colEtudiantMatricule;

@FXML
private TableColumn<Etudiant, String> colEtudiantTel;

@FXML
private TableColumn<Etudiant, String> colEtudiantEmail;

@FXML
private TableColumn<Etudiant, String> colEtudiantAdresse;

@FXML
private TableColumn<Etudiant, String> colEtudiantGpSanguin;

@FXML
private TableColumn<Etudiant, String> colEtudiantDateN;

@FXML
private TableColumn<Etudiant, String> colEtudiantLieuN;

@FXML
private TableColumn<Etudiant, String> colEtudiantNationalite;

@FXML
private TableColumn<Etudiant, String> colEtudiantEtatCivil;

@FXML
private TableColumn<Etudiant, String> colEtudiantGenre;

@FXML
private TableColumn<Etudiant, String> colEtudiantEtatC;

@FXML
private Button btnSearchEtd;

@FXML
private Button btnAddEtudiant;

@FXML
private Button btnModifEtudiant;

@FXML
private Button btnDeleteEudiant;

@FXML 
private AnchorPane anchorPaneAjoutEtudiant;

@FXML 
private AnchorPane anchorPaneSelectEtudiantIdModifier;

@FXML 
private AnchorPane anchorPaneSelectEtudiantIdDelete;


//	 GESTION ETUDIANT END *****************************************************
@FXML
private GridPane gridGpEtudiant;

@FXML
private TableView<Etudiant> tabViewGroupeEtudiant;

@FXML
private TableColumn<Etudiant, Integer> colGestEtudiantId;

@FXML
private TableColumn<Etudiant, String> colGestEtudiantNom;

@FXML
private TableColumn<Etudiant, String> colGestEtudiantPrenom;

@FXML
private TableColumn<Etudiant, String> colGestEtudiantMatricule;

@FXML
private TableColumn<Etudiant, String> colGestEtudiantTel;

@FXML
private TableColumn<Etudiant, String> colGestEtudiantEmail;

@FXML
private TableColumn<Etudiant, String> colGestEtudiantAdresse;

@FXML
private Button btnSearchEtd11;

@FXML
private Button btnDellEtd111;

@FXML
private Button btnModifEtd11112;

@FXML
private Button btnModifEtd11111;


// GESTION GROUPE PROPERTIES ***********************************************
@FXML
private GridPane gridGp;

@FXML
private TableView<Groupe> tvGroupe;

@FXML
private TableColumn<Groupe, Integer> idGroupe;

@FXML
private TableColumn<Groupe, String> nomGroupe;

@FXML
private TableColumn<?, Integer> nbreEtdGp;

@FXML
private Button btnSearchEtd1;

@FXML
private Button btnModifEtd11;

@FXML
private Button btnDellEtd11;

@FXML
private TextField tfIdGroupe;

@FXML
private Button btnAddEtdGroupe;

@FXML
private Pane pnStatus;

@FXML
private Text pnText;

@FXML
private Label pnLabel;

@FXML
private FontAwesomeIcon btnClose;

@FXML
private Button btnAddGroupe;

@FXML
private Button btnAddEffacer;

@FXML
private TextField textFieldeGroupe;


@FXML
private Button btnGroupeDelete;

@FXML
private VBox vbDelete;

@FXML 
private VBox vbModifier;

@FXML 
private TextField textFieldGroupeDell;

@FXML
private Button btnConfirmDeleteGroupe;

@FXML
private Button btnModifAnnuller;

@FXML
private Button btnUpdateGpAnnuler;

@FXML
private Button btnModififGroupe;

@FXML
private Button btnConfirmUpdateGp;

@FXML
private Button btnAddNewGroupe;

@FXML
private TextField textFieldIGpToUpdate;

@FXML
private TextField textFielNomGpUpdated;

@FXML
private VBox vbAjout;


//End GestionGroupe Properties -------------------------------------------

double x=0,y=0;

@FXML
void showAddGroupe(ActionEvent event) {
	
	if(event.getSource()==btnAddNewGroupe)
	  {
		  vbAjout.toFront();
	  }
	else if(event.getSource()==btnModifAnnuller) {
		  vbAjout.toBack();  
	  }
}


@FXML
void deleteGroupe(ActionEvent event) {
	
	if(event.getSource()==btnGroupeDelete)
	  {
		  vbDelete.toFront();
	  }
	else if(event.getSource()==btnModifAnnuller) {
		  vbDelete.toBack();  
	  }
}

@FXML
void updateGroupe(ActionEvent event) {
	
	if(event.getSource()==btnModififGroupe)
	  {
		vbModifier.toFront();
	  }
	else if(event.getSource()==btnUpdateGpAnnuler) {
		vbModifier.toBack();  
	  }
}

@FXML
void modifInfoGroupe(MouseEvent event) {
	
  if(event.getSource()==btnAddGroupe) {

	  if(textFieldeGroupe.getText()=="") {
		  
	  }
	  else {
		  String nomGroupe = textFieldeGroupe.getText();
		  Groupe grp = new Groupe(nomGroupe);
		  new GestionGroupeController().add(grp);
		  textFieldeGroupe.setText("");
	  }  
  }
  
  else if(event.getSource()==btnConfirmDeleteGroupe)
  {
	  String idString = textFieldGroupeDell.getText();
	  int idGroupe = Integer.valueOf(idString).intValue();
	
	  Groupe grp = new GestionGroupeController().getById(idGroupe);
	  new GestionGroupeController().delete(grp);
	  textFieldGroupeDell.setText("");
	  vbAjout.toFront();
	  
  }
  else if(event.getSource()==btnConfirmUpdateGp) {
	  
  }
  
  else if(event.getSource()==btnAddEffacer) {
	  textFieldeGroupe.setText("");
  }
  
}

@FXML
private void handleClicked(ActionEvent event) throws IOException {
	
	if(event.getSource()==btnEtudiant) {
		 pnLabel.setText("/home/étudiant");
		 pnText.setText("Gestion Etudiant");
		//pnStatus.setBackground(new Background(new BackgroundFill(Color.rgb(59, 38, 166),CornerRadii.EMPTY,Insets.EMPTY)));

        gpStudent.toFront();
        tabViewEtudiant.toFront();
	}
	else if(event.getSource()==btnGroupe) {
		pnLabel.setText("/home/groupe");
		pnText.setText("Gestion Groupe");
		//btnAdd.setText("Ajouter un groupe");
		gridGp.toFront();
		
		}
	else if(event.getSource()==btnProfesseur) {
		pnLabel.setText("/home/professeur");
		pnText.setText("Gestion professeur");
		//btnAdd.setText("Ajouter un professeur");
		gpProfesseur.toFront();
		
	   }
	else if(event.getSource()==btnGestionGroupe) {
		pnLabel.setText("/home/groupe étudiant");
		pnText.setText("Gestion Groupe Etudiant");
		//btnAdd.setText("Ajouter un étudiant");
		vbSelectGp.toFront();
		/*
		Parent root = FXMLLoader.load(getClass().getResource("/views/modifModal.fxml"));
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(new Scene(root));
		stage.show();
		*/
	}
		
}

@FXML
void handleModifClicked(ActionEvent event) {
   if(event.getSource()==btnOpenModifGp) {
	   gridGpEtudiant.toFront();
	   vbAjout.toFront();
   }
}


//GESTION ETUDIANT FUNCTIONS ***************************************************

@FXML
void addEtudiant(MouseEvent event) {
	anchorPaneAjoutEtudiant.toFront();
}

@FXML
void deleteEtudiant(MouseEvent event) {
	anchorPaneSelectEtudiantIdDelete.toFront();
}

@FXML
void updateEtudiant(MouseEvent event) {
	anchorPaneSelectEtudiantIdModifier.toFront();
}



// END GESTION ETUDIANT ********************************************************


//  GET ALL LIST 

public ObservableList<Groupe> listGroupe(){
	return FXCollections.observableArrayList(new GestionGroupeController().findAll());
}

public ObservableList<Etudiant> listEtudiant(){
	return FXCollections.observableArrayList(new GestionEtudiantController().findAll());
}

@FXML
private void handleClose(MouseEvent event) {

	if(event.getSource()==btnClose) {
		javafx.application.Platform.exit();
	}
}

 
private void makeDraggable() {
	
	application.setOnMousePressed((event)->{
		x=event.getSceneX();
		y=event.getSceneY();
	});
	
	application.setOnMouseDragged((event) ->{
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setX(event.getSceneX()-x);
		stage.setY(event.getSceneY()-y);
		//stage.setOpacity(0.8f);
		
	});
	/*
	application.setOnDragDone((event)->{
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setOpacity(1.0f);
	});
	
	application.setOnMouseReleased((event)->{
		Node node = (Node) event.getSource();
		Stage stage = (Stage) node.getScene().getWindow();
		stage.setOpacity(1.0f);
	});
	*/
}


@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	makeDraggable();
	
	//initialisation du tableView de Gestion Groupe
	idGroupe.setCellValueFactory(new PropertyValueFactory<Groupe,Integer>("groupeId"));
	nomGroupe.setCellValueFactory(new PropertyValueFactory<Groupe,String>("nomGroupe"));
	tvGroupe.setItems(listGroupe());
	
	//Initialisation du tableView de gestion Etudiant
	colEtudiantId.setCellValueFactory(new PropertyValueFactory<Etudiant,Integer>("etudiantId"));
	colEtudiantNom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
	colEtudiantPrenom.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
	colEtudiantAdresse.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("adresse"));
	colEtudiantMatricule.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("matricule"));
	colEtudiantEmail.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("email"));
	colEtudiantDateN.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("dateNaissance"));
	colEtudiantNationalite.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nationalite"));
	colEtudiantLieuN.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("lieuNaissance"));
	colEtudiantGpSanguin.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("groupeSanguin"));
	colEtudiantGenre.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("genre"));
	colEtudiantTel.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("tel"));
	colEtudiantEtatC.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("situationMatrimoniale"));
	tabViewEtudiant.setItems(listEtudiant());
}

}


