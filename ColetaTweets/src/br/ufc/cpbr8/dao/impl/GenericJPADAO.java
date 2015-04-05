package br.ufc.cpbr8.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import br.ufc.cpbr8.dao.GenericDAO;
import br.ufc.cpbr8.util.JPAUtil;

public abstract class GenericJPADAO<T> implements GenericDAO<T> {

	protected EntityManager em = JPAUtil.getEntityManager();
	protected Class<T> persistentClass;

	public void save(T entity) {
		em.persist(entity);
	}

	public void delete(T entity) {
		em.refresh(entity);
		em.remove(entity);
	}

	public void update(T entity){
		//em.refresh(entity);
		em.merge(entity);
		
	}
	
	public T find(Object id) {
		return em.find(persistentClass, id);
	}

	public List<T> find() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(persistentClass);
		cq.from(persistentClass);
		return em.createQuery(cq).getResultList();
	}
	
	public List<T> find(String query) {
		Query q = em.createNamedQuery(query);
		return q.getResultList();
	}
	
	public void beginTransaction() {
		if(!em.getTransaction().isActive())
			em.getTransaction().begin();
	}

	public void commit() {
		em.getTransaction().commit();
	}

	public void rollback() {
		em.getTransaction().rollback();
	}

	public void close() {
		JPAUtil.closeEntityManager();
	}
}
