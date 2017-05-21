package com.es.getpet.core.util;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.es.getpet.core.ed.Animal;

public abstract class DAO<E extends ED> {

	public E salva(E ed) {
        Session session = getSession();
        try {
            try {
                session.beginTransaction();
                session.save(ed);
                session.flush();
                session.clear();
                session.getTransaction().commit();
            } catch (HibernateException e) {
                if (session.getTransaction() != null && session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
                throw new IllegalStateException(e.getMessage());
            }
        } finally {
            session.close();
        }
        return ed;
    }

    public void remove(E animal) {
        Session session = getSession();
        try {
            try {
                session.beginTransaction();
                session.delete(animal);
                session.flush();
                session.clear();
                session.getTransaction().commit();
            } catch (HibernateException e) {
                if (session.getTransaction() != null && session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
                throw new IllegalStateException(e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    public void remove(List<E> lista) {
    	StringBuilder sb = new StringBuilder(lista.size());
        sb.append("delete from ").append(lista.get(0).getClass().getSimpleName()).append(" where id in (");
        boolean primeiro = true;

        for (E e : lista) {
        	if (primeiro) {
        		primeiro = false;
        	} else {
        		sb.append(",");
        	}
        	sb.append(e.getId());
        }

        sb.append(")");
        Session session = getSession();
        try {
            try {
                session.beginTransaction();
                Query q = session.createQuery(sb.toString());
                q.executeUpdate();
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction() != null && session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
                throw new IllegalStateException(e.getMessage());
            }
        } finally {
            session.close();
        }
    }

    public E atualiza(E animal) {
        Session session = getSession();
        try {
            try {
                session.beginTransaction();
                session.update(animal);
                session.flush();
                session.clear();
                session.getTransaction().commit();
            } catch (HibernateException e) {
                if (session.getTransaction() != null && session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
                throw new IllegalStateException(e.getMessage());
            }
        } finally {
            session.close();
        }
        return animal;
    }

    public abstract List<E> lista(E ed, PropriedadesLista pl);

    public abstract E consulta(E ed);

    public abstract List<E> busca(E ed, PropriedadesLista pl);

    protected Session getSession() {
        Session session;
        try {
        	session = HibernateUtil.getSession();
        } catch (SecurityException | IllegalArgumentException ex) {
            session = null;
        }
        return session;
    }

}