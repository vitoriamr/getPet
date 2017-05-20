package com.es.getpet.core.bd;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.util.PropriedadesLista;
import com.es.getpet.core.util.TipoJuncao;

public class AnimalDAO {

	private Method gs;

    public Animal salva(Animal animal) {
        Session session = getSession();
        try {
            try {
                session.beginTransaction();
                session.saveOrUpdate(animal);
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

    public void remove(Animal animal) {
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

    public void remove(List<Animal> lista) {
        remove(null, lista);
    }

    public void remove(int[] indices, List<Animal> lista) {
        StringBuilder sb = new StringBuilder(11 * (indices == null ? lista.size() : indices.length) + 27);
        sb.append("delete from ").append(lista.get(0).getClass().getSimpleName()).append(" where id in (");
        boolean primeiro = true;
        if (indices != null) { //indices só deve ser nulo internamente
            for (int i : indices) {
                if (primeiro) {
                    primeiro = false;
                } else {
                    sb.append(",");
                }
                sb.append(lista.get(i).getId());
            }
        } else {
            for (Animal e : lista) {
                if (primeiro) {
                    primeiro = false;
                } else {
                    sb.append(",");
                }
                sb.append(e.getId());
            }
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

    public Animal atualiza(Animal element) {
        return salva(element);
    }

    public List<Animal> lista(Animal ed, PropriedadesLista pl) {
        return pesquisa(ed, TipoJuncao.Conjuncao, pl);
    }

    public List<Animal> busca(Animal ed, PropriedadesLista pl) {
        return pesquisa(ed, TipoJuncao.Discjuncao, pl);
    }

    @SuppressWarnings("unchecked")
	public Animal consulta(Animal ed) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(ed.getClass());
        Junction junction = Restrictions.conjunction();
        junction.add(Restrictions.eq("id", ed.getId()));

        criteria.add(junction);
		List<Animal> lista = criteria.list();
        Animal r;
        if (lista.isEmpty()) {
            r = null;
        } else {
            r = lista.get(0);
        }
        return r;
    }

    @SuppressWarnings("unchecked")
	private List<Animal> pesquisa(Animal ed, TipoJuncao tipoJuncao, PropriedadesLista pl) {
        Session session = getSession();
        List<Animal> lista;
        try {
            try {
                Criteria criteria = session.createCriteria(Animal.class);
                lista = criteria.list();
            } catch (HibernateException e) {
                throw new IllegalStateException("Erro no método lista no BD do JInfra.\n" + e.getMessage());
            }
        } finally {
            session.close();
        }
        return lista;
    }

    private Session getSession() {
        Session session;
        try {
            session = (Session) gs.invoke(null);
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            session = null;
        }
        return session;
    }

}
