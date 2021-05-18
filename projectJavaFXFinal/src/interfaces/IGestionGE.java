package interfaces;

import models.Etudiant;

public interface IGestionGE {
	
		void add(Etudiant e);
		void delete(int id);
		void showAll();
		Etudiant getEtudiantById(int id);
	
}
