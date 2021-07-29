package controllers;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
private AnchorPane anchorPaneProfesseur;

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
private AnchorPane anchorPaneStudent;

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
private RadioButton rdBtnMasculin;

@FXML 
private AnchorPane anchorPaneAjoutEtudiant;

@FXML 
private AnchorPane anchorPaneSelectEtudiantIdModifier;

@FXML 
private AnchorPane anchorPaneSelectEtudiantIdDelete;

@FXML 
private AnchorPane anchorPaneModifEtudiant;

//LES BOUTTONS D'AJOUT ETUDIANT
@FXML
private TextField textFieldAddEtudiantNom;

@FXML
private TextField textFieldAddEtudiantPrenom;

@FXML
private TextField textFieldAddEtudiantAdresse;

@FXML
private TextField textFieldAddEtudiantTel;

@FXML
private TextField textFieldAddEtudiantMatricule;

@FXML
private TextField textFieldAddEtudiantEmail;

@FXML
private DatePicker dpAddEtudiantDateN;

@FXML
private TextField textFieldAddEtudiantLieuN;

@FXML
private TextField textFieldAddEtudiantNationlatiy;

@FXML
private TextField textFieldAddEtudiantGpSanguin;

@FXML
private TextField textFieldMajEtudiantNom;

@FXML
private TextField textFieldMajEtudiantPrenom;

@FXML
private TextField textFieldMajEtudiantAdresse;

@FXML
private TextField textFieldMajEtudiantTel;

@FXML
private TextField textFieldMajEtudiantMatricule;

@FXML
private TextField textFieldMajEtudiantEmail;

@FXML
private Button btnConfirmMajEtudiant;

@FXML
private Button btnCancelMajEtudiant;

@FXML
private VBox vbModifier111;

@FXML
private DatePicker dpMajEtudiantDateN;

@FXML
private TextField textFieldMajEtudiantLieuN;

@FXML
private TextField textFieldMajEtudiantNationlatiy;

@FXML
private TextField textFieldMajEtudiantGpSanguin;

@FXML
private RadioButton rbMasculinMaj;

@FXML
private RadioButton rbFemininMaj;

@FXML
private RadioButton rbMarieeMaj;

@FXML
private RadioButton rbCelibataireMaj;

@FXML
private RadioButton rbAutreMaj;



@FXML
private Button btnConfirmAddEtudiant;

@FXML
private Button btnCancelAddEtudiant;

@FXML
private TextField textFieldIdEtudiantDelete;

@FXML
private TextField textFieldEtudiantIdToUpdate;

@FXML
private Button btnConfrimeDeleteEtudiant;

@FXML
private Button btnCancelDeleteEtudiant;

@FXML
private Button btnSelectEtudiantIdToMaj;

@FXML
private Button btnCancelSelectEtudiantIdToMaj;


//	 GESTION ETUDIANT END *****************************************************

@FXML
private RadioButton rbMasculin;

@FXML
private RadioButton rbFeminin;

@FXML
private RadioButton rbMarie;

@FXML
private RadioButton rbCelibataire;

@FXML
private RadioButton rbAutre;

@FXML
private AnchorPane anchorPaneGestionEtudiant;

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


// GESTION GROUPE PROPERTIES ***********************************************
@FXML
private AnchorPane anchorPaneGroupe;

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


//End GestionGroupe Properties ------------------------------------------------------------------- */


/* GESTION PROFESSEUR FXML BUTTON START */

@FXML
private Button btnActualiserGesETudiant;

/*
@FXML
private Button btnActualiserGesProf;

*/

@FXML
private Button btnActualiserGesGroupe;

/* GESTION PROFESSEUR FXML BUTTON END ---------------------------------------------------------   */

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

        anchorPaneStudent.toFront();
        tabViewEtudiant.toFront();
	}
	else if(event.getSource()==btnGroupe) {
		pnLabel.setText("/home/groupe");
		pnText.setText("Gestion Groupe");
		//btnAdd.setText("Ajouter un groupe");
		anchorPaneGroupe.toFront();
		
		}
	else if(event.getSource()==btnProfesseur) {
		pnLabel.setText("/home/professeur");
		pnText.setText("Gestion professeur");
		//btnAdd.setText("Ajouter un professeur");
		anchorPaneProfesseur.toFront();
		
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
	   anchorPaneGestionEtudiant.toFront();
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

private String sexeSelected="M";
@FXML
void getSexe(ActionEvent event) {
	if(rbMasculin.isSelected()) {
		sexeSelected="M";
		}
	else
	{
		sexeSelected="F";
	}
	
}

private String etatCivilSelected="Célibataire";

@FXML
void getEtatCivil(ActionEvent event) {
	if(rbCelibataire.isSelected()) {
		etatCivilSelected=rbCelibataire.getText();
	}
	else if(rbMarie.isSelected())
	{
		etatCivilSelected=rbMarie.getText();
	}
	else {
		etatCivilSelected=rbAutre.getText();
	}
	
}

//reinitialiser les buttons pour l'ajout d'etudiant
//void 
//void inserer un etudiant dans la bd
@FXML
void insetEtudiantToDb(ActionEvent event) {
	GestionEtudiantController ge = new GestionEtudiantController();
	
	String dateN = dpAddEtudiantDateN.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
	Etudiant etudiant = new Etudiant(textFieldAddEtudiantMatricule.getText(),sexeSelected,textFieldAddEtudiantNom.getText(),textFieldAddEtudiantPrenom.getText(),
			textFieldAddEtudiantAdresse.getText(),textFieldAddEtudiantLieuN.getText(),dateN,textFieldAddEtudiantNationlatiy.getText()
			,etatCivilSelected,textFieldAddEtudiantTel.getText(),textFieldAddEtudiantEmail.getText(),textFieldAddEtudiantGpSanguin.getText());
	
	ge.add(etudiant);
	anchorPaneStudent.toFront();
	
	
}

//void modifier un étudiant
@FXML
void selectEtudiantIdToMaj(ActionEvent event) { 
	String btnValue = textFieldEtudiantIdToUpdate.getText();
	
	if(event.getSource()==btnSelectEtudiantIdToMaj) {
		String idString =btnValue;
		int idToDel =  Integer.valueOf(idString).intValue();
		
		Etudiant etToMaj = new GestionEtudiantController().getById(idToDel);
		if(etToMaj!=null) {
			setEtudiantDatatoTextField(etToMaj);
			anchorPaneModifEtudiant.toFront();
			textFieldEtudiantIdToUpdate.clear();
		}
		else {
			System.out.println("Etudiant indisponible");
		}
	}
	else
	{
		textFieldEtudiantIdToUpdate.clear();
	}
}

// void confirmMajEtudiant Maj etudiant

@FXML
void confirmMajEtudiant(ActionEvent event) {
	
GestionEtudiantController ge = new GestionEtudiantController();
	
	String dateN = dpMajEtudiantDateN.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			
	Etudiant etudiant = new Etudiant(textFieldMajEtudiantMatricule.getText(),sexeSelected,textFieldMajEtudiantNom.getText(),textFieldMajEtudiantPrenom.getText(),
			textFieldMajEtudiantAdresse.getText(),textFieldMajEtudiantLieuN.getText(),dateN,textFieldMajEtudiantNationlatiy.getText()
			,etatCivilSelected,textFieldMajEtudiantTel.getText(),textFieldMajEtudiantEmail.getText(),textFieldMajEtudiantGpSanguin.getText());
	
	ge.update(etudiant);
	
	anchorPaneStudent.toFront();
}

//void get to update etudiant data 

void setEtudiantDatatoTextField(Etudiant etd) {
	textFieldMajEtudiantMatricule.setText(etd.getMatricule());
	textFieldMajEtudiantNom.setText(etd.getNom());
	textFieldMajEtudiantPrenom.setText(etd.getPrenom());
	textFieldMajEtudiantAdresse.setText(etd.getAdresse());
	textFieldMajEtudiantLieuN.setText(etd.getLieuNaissance());
	
	textFieldMajEtudiantNationlatiy.setText(etd.getNationalite());
	textFieldMajEtudiantTel.setText(etd.getTel());
	textFieldMajEtudiantEmail.setText(etd.getEmail());
	textFieldMajEtudiantGpSanguin.setText(etd.getGroupeSanguin());
	String genre = etd.getGenre();
	String dateN= etd.getDateNaissance();
	String etatCivilSelected = etd.getSituationMatrimoniale();
	
	//String dateN = dpAddEtudiantDateN.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	dpMajEtudiantDateN.setValue(null);
	/*
	try {
		//LocalDate dateNaissance=new SimpleDateFormat("dd-MM-yyyy").format(dateN);
		dpMajEtudiantDateN.setValue(null);
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	*/
	
	if(etatCivilSelected.toLowerCase().contentEquals("marié(e")) {
		rbMarieeMaj.setSelected(true);
	}
	else if(etatCivilSelected.toLowerCase().contentEquals("célibataire")) {
		rbCelibataireMaj.setSelected(true);
	}
	else if(etatCivilSelected.toLowerCase().contentEquals("autre")) {
		rbAutreMaj.setSelected(true);
	}
	else {
		rbAutreMaj.setSelected(false);
		rbCelibataireMaj.setSelected(false);
		rbMarieeMaj.setSelected(false);
	}
	
	if(genre.toLowerCase().contentEquals("f")) {
		rbFemininMaj.setSelected(true);
	}
	else if(genre.toLowerCase().contentEquals("m"))  {
		rbMasculinMaj.setSelected(true);
	}
	else {
		//rbFemininMaj.setSelected(false);
		//rbMasculinMaj.setSelected(false);
	}
}
//Anuller l'ajout d'un etudiant dans la Bd
@FXML
void cancelAddEtudiantToDdb(ActionEvent event) {
	
}

//function deleteEtudiant
@FXML
void confrimeDeleteEtudiant(ActionEvent event) {
	String btnValue = textFieldIdEtudiantDelete.getText();
	try {
		
	if(btnValue.isEmpty()) {
		System.out.println("veuillez entrer un identifiant");
	}
	else {
		String idString =btnValue;
		int idToDel =  Integer.valueOf(idString).intValue();
		Etudiant etToMaj = new GestionEtudiantController().getById(idToDel);
		if(etToMaj!=null) {
			//new GestionEtudiantController().update(idToDel);;
			System.out.println(idToDel+" a été supprimé avec succes");
		}
	}
	}
	catch(NumberFormatException e) {
		System.out.println("Entrer un entier ");
	}
	
}


@FXML
void cancelDeleteEtudiant(ActionEvent event) {
	
}

void refreshTabViewEtudiant() {
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
	tabViewEtudiant.refresh();
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

/******************************************************************************************************************
    GESTION PROFESSEUR START 
  */

@FXML
void btnActualiserMouseEntered(MouseEvent event) {
    
}

@FXML
void actualiserTabview(MouseEvent event) {
	if(event.getSource()==btnActualiserGesGroupe) {
		System.out.println("actualise la tabView ges ");
    }
	else if(event.getSource()==btnActualiserGesETudiant) {
		System.out.println("actualise la tabView etd");
		refreshTabViewEtudiant();
	}
	/*
	if(event.getSource()==btnActualiserGesProf) {
		btnActualiserGesProf.setStyle("-fx-background-color:#1131bd");
    }
	*/
}

/******************************************************************************************************************
GESTION PROFESSEUR END 
*/
 
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
	
	refreshTabViewEtudiant();
	
	anchorPaneStudent.toFront();
	tabViewEtudiant.toFront();
}

}


