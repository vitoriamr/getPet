package com.es.getpet.core.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.es.getpet.core.ed.Adocao;
import com.es.getpet.core.util.DAO;
import com.es.getpet.core.util.PropriedadesLista;
import com.es.getpet.core.util.TipoJuncao;

public class AdocaoDAO extends DAO<Adocao> {

	@Override
	public List<Adocao> lista(Adocao ed, PropriedadesLista pl) {
		return pesquisa(ed, pl, TipoJuncao.Conjuncao);
	}

	private List<Adocao> pesquisa(Adocao ed, PropriedadesLista pl, TipoJuncao tipoJuncao) {
		Session session = getSession();
		session.beginTransaction();
		List<Adocao> listaAnimal = session.createQuery(montaCriteria(ed, pl, tipoJuncao)).getResultList();
		session.getTransaction().commit();
    	return listaAnimal;
	}

    private CriteriaQuery<Adocao> montaCriteria(Adocao ed, PropriedadesLista pl, TipoJuncao tipoJuncao) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Adocao> criteria = builder.createQuery(Adocao.class);
		Root<Adocao> raiz = criteria.from(Adocao.class);
		List<Predicate> listaPredicados = new ArrayList<>();
		if (ed.getCuidador().getId() != null) {
			listaPredicados.add(builder.equal(raiz.get("cuidador").get("id"), ed.getCuidador().getId()));
		}
		Predicate[] arrayPredicados = new Predicate[listaPredicados.size()];
		arrayPredicados = listaPredicados.toArray(arrayPredicados);
		criteria.where(builder.and(arrayPredicados));
    	return criteria;
    }

	@Override
	public List<Adocao> busca(Adocao ed, PropriedadesLista pl) {
		// TODO Auto-generated method stub
		return null;
	}

}
