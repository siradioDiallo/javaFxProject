package interfaces;

import java.util.List;

public interface IModification <T> {
	
	void add(T toAdd);
	void delete(T toDel);
	void update(T toMaj);
	void showDetail(int id);
	void showAll();
     List<T> findAll();
	 T getById(int id);

	
	

}