package com.es.getpet.core.bd;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;

import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.util.DAO;
import com.es.getpet.core.util.PropriedadesLista;


public class AnimalDAO extends DAO<Animal> {

    public List<Animal> lista(Animal ed, PropriedadesLista pl) {
        return null;
    }

    public List<Animal> busca(Animal ed, PropriedadesLista pl) {
        return null;
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



}
