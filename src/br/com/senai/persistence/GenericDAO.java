package br.com.senai.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;


public class GenericDAO<T, ID extends Serializable> { 
	
	protected EntityManager entityManager;
	
	private Class<T> ClassePersistencia;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public GenericDAO() {
		
		this.ClassePersistencia = getClassePersistente();
		
	}
	
		
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

		
	public Class<T> getClassePersistente() {
		return ClassePersistencia;
	}
	
		
	public T getEntidade(Serializable  id, Class<T> T) {
		return (T) entityManager.find(T, id);
	}
	
	
	@Transactional
	public void  salvar(T entidade) {
		entityManager.persist(entidade);
	}
	
	
	@Transactional
	public void merge(T entidade) {
		entityManager.merge(entidade);
	}
	
	@Transactional
	public void remove(T entidade) {
		entityManager.remove(entidade);
	}
	
	/*@SuppressWarnings("unchecked")
	public List<T> findAll(String consulta) {
		
		return entityManager.createQuery(consulta).getResultList();
	}*/
	
	
	@SuppressWarnings("unchecked")
	@Transactional	
	 public <T> List <T> getLista(Class<T> classToCast, String jpql,Object ... parameters){
	        List <T> toReturn = null;
	       
	        Query qr = entityManager.createQuery(jpql);
	        for (int i = 0; i < parameters.length; i++) {
	            qr.setParameter(i+1, parameters[i]);
	                       
	        }
	        toReturn = qr.getResultList();
	        return toReturn;
	    }
	
		
	
}
