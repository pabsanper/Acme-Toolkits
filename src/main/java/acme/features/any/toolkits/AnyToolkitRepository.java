package acme.features.any.toolkits;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Item;
import acme.entities.Toolkit;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyToolkitRepository extends AbstractRepository{
	
	@Query("select t from Toolkit t where t.published=:True")
	Collection<Toolkit> findAllToolkit(boolean True);
	
	@Query("select t from Toolkit t where t.id = :id")
	Toolkit findOneToolkitById(int id);
	
	@Query("select q.item from Quantity q where q.toolkit.id = :id")
	Collection<Item> findItemsFromToolkitId(int id);
	
	@Query("select sum(q.item.retailPrice.amount * q.itemsNumber) from Quantity q where q.toolkit.id =:id")
	Double calculateToolkitPrice(int id);

}
