package persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import domain.Cancelamento;
import javax.persistence.EntityTransaction;

public class CancelamentoDAO implements IEntity<Cancelamento>{

    private EntityManager em;
    
    public CancelamentoDAO(){
        em=JPAUtil.getEntityManager();
    }

    @Override
    public void save(Cancelamento cancelamento) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(cancelamento);
        tx.commit();
        em.close();
    }

	@Override
	public void delete(Cancelamento cancelamento) {
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	em.remove(em.merge(cancelamento));
        tx.commit();
        em.close();
	}
    
    @Override
    public Cancelamento find(Long id) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Cancelamento result = em.find(Cancelamento.class, id);
		tx.commit();
		em.close();
		return result;
    }

    @Override
    public void update(Cancelamento cancelamento) {
    	
    	EntityTransaction tx = em.getTransaction();
    	
		tx.begin();
		Cancelamento result = em.find(Cancelamento.class, cancelamento.getId());
    	
		result.setOverbooking(cancelamento.getOverbooking());
		result.setPassageiro(cancelamento.getPassageiro());
		
		tx.commit();
		em.close();
    }

    @Override
    public List<Cancelamento> findAll() {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
	    Query query = em.createQuery("SELECT e FROM Cancelamento e");
		tx.commit();
		em.close();
	    return (List<Cancelamento>) query.getResultList();
	    
    }


    
}
