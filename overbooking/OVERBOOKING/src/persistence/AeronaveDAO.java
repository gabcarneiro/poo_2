package persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import domain.Aeronave;
import domain.Passageiro;
import javax.persistence.EntityTransaction;

public class AeronaveDAO implements IEntity<Aeronave>{

    private EntityManager em;
    
    public AeronaveDAO(){
        em=JPAUtil.getEntityManager();
    }

    @Override
    public void save(Aeronave aeronave) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(aeronave);
        tx.commit();
        em.close();
    }

	@Override
	public void delete(Aeronave aeronave) {
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	em.remove(em.merge(aeronave));
        tx.commit();
        em.close();
	}
    
    @Override
    public Aeronave find(Long id) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Aeronave result = em.find(Aeronave.class, id);
		tx.commit();
		em.close();
		return result;
    }

    @Override
    public void update(Aeronave aeronave) {
    	
    	EntityTransaction tx = em.getTransaction();
    	
		tx.begin();
		Aeronave result = em.find(Aeronave.class, aeronave.getId());
    	
		result.setCapacidadeTotal(aeronave.getCapacidadeTotal());
		result.setModelo(aeronave.getModelo());;
		
		tx.commit();
		em.close();
    }

    @Override
    public List<Aeronave> findAll() {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
	    Query query = em.createQuery("SELECT e FROM Aeronave e");
		tx.commit();
		em.close();
	    return (List<Aeronave>) query.getResultList();
	    
    }


    
}
