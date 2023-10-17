package service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ImplIDAO implements IDAO{

    @Override
    public <T> List<T> getAll(String nameQuery, Class<T> clazz) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try {
            //es una query escrita
            //namedquery un alias para una sentencia SQL
            TypedQuery<T> query = em.createNamedQuery(nameQuery, clazz);
            return query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public <T> void insert(T entity) {
        //cuando hacemos algo en la BD se guarda en el redlog, que es una BD temporal.
        /*cuando hacemos flush, limpia todo lo que esta en el espacio temperal y hace commit.
         */
    }
    @Override
    public <T> T update(T entity) {
        return null;
    }

    @Override
    public <T> void remove(T entity) {
        EntityManager em = EntityManagerAdmin.getInstance();
        try{
            em.getTransaction().begin();
            em.remove(em.merge(entity));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }

    @Override
    public <T> T findById(Class<T> clazz, Integer id) {
        EntityManager em =EntityManagerAdmin.getInstance();
        try {
            T entity = em.find(clazz, id);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            em.close();
        }
    }
}
