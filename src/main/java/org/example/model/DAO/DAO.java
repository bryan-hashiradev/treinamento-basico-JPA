package org.example.model.DAO;

import javax.persistence.EntityManager;
import java.util.List;

abstract public class DAO<Entity> {
    protected EntityManager em;
    protected Class entityClass;

    public DAO(EntityManager em, Class entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void save(Entity entity) {
        em.persist(entity);
    }

    public void remove(Entity entity) {
        em.remove(entity);
    }

    public List<Entity> list() {
        String jpql = "SELECT e FROM " +
                entityClass.getSimpleName() +
                " e";
        return em.createQuery(jpql, entityClass).getResultList();
    }



    public Entity findByID(Long id) {
        return (Entity) em.find(entityClass, id);
    }
}
