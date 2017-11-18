package persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import domain.Passageiro;
import domain.Voo;

import javax.persistence.EntityTransaction;

public class VooDAO implements IEntity<Voo>{

    private EntityManager em;
    
    public VooDAO(){
        em=JPAUtil.getEntityManager();
    }

    @Override
    public void save(Voo voo) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(voo);
        tx.commit();
        em.close();
    }

	@Override
	public void delete(Voo voo) {
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	em.remove(em.merge(voo));
        tx.commit();
        em.close();
	}
    
    @Override
    public Voo find(Long id) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Voo result = em.find(Voo.class, id);
		tx.commit();
		em.close();
		return result;
    }

    @Override
    public void update(Voo voo) {
    	EntityTransaction tx = em.getTransaction();
    	
		tx.begin();
		Voo result = em.find(Voo.class, voo.getId());
    	
		result.setAeronave(voo.getAeronave());
		result.setOrigem(voo.getOrigem());
		result.setCancelamentos(voo.getCancelamentos());
		result.setOcupacaoAtual(voo.getOcupacaoAtual());
		result.setDestino(voo.getDestino());
		result.setReservas(voo.getReservas());
		
		tx.commit();
		em.close();
    }

    @Override
    public List<Voo> findAll() {
	    Query query = em.createQuery("SELECT e FROM Voo e");
	    return (List<Voo>) query.getResultList();
	    
    }


    
}
