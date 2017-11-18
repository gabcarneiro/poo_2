package persistence;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import domain.Passageiro;
import javax.persistence.EntityTransaction;

public class PassageiroDAO implements IEntity<Passageiro>{

    private EntityManager em;
    
    public PassageiroDAO(){
        em=JPAUtil.getEntityManager();
    }

    @Override
    public void save(Passageiro passageiro) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(passageiro);
        tx.commit();
        em.close();
    }

	@Override
	public void delete(Passageiro passageiro) {
    	EntityTransaction tx = em.getTransaction();
    	tx.begin();
    	em.remove(em.merge(passageiro));
        tx.commit();
        em.close();
	}
    
    @Override
    public Passageiro find(Long id) {
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Passageiro result = em.find(Passageiro.class, id);
		tx.commit();
		em.close();
		return result;
    }

    @Override
    public void update(Passageiro passageiro) {
    	EntityTransaction tx = em.getTransaction();
    	
		tx.begin();
		Passageiro result = em.find(Passageiro.class, passageiro.getId());
    	
		result.setCategoria(passageiro.getCategoria());
		result.setCpf(passageiro.getCpf());
		result.setNome(passageiro.getNome());
		
		tx.commit();
		em.close();
    }

    @Override
    public List<Passageiro> findAll() {
	    Query query = em.createQuery("SELECT e FROM Passageiro e");
	    return (List<Passageiro>) query.getResultList();
	    
    }


    
}
