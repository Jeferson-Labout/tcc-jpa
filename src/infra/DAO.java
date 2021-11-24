/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jefson
 * @param <E>
 */
public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("TCC_JPAPU");

        } catch (Exception e) {

        }

    }

    public DAO() {
        this(null);

    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();

    }

    public DAO<E> abrirTransaction() {
        em.getTransaction().begin();
        return this;

    }

    public DAO<E> fecharTransaction() {
        em.getTransaction().commit();
        return this;

    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {
       
        return this.abrirTransaction().incluir(entidade).fecharTransaction();
    }
     public List<E> obterTodos() {
        return this.obterTodos(10,0);
        
            
        }
    
     public List<E> obterTodos(int qtde,int deslocamento) {
        if(classe==null){
            throw new UnsupportedOperationException("Classe nula.");
            
        }
        String jpql= "select e from"+classe.getName() + "e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
        
        
    }
     
      public void fechar() {
        em.close();
        }
}
