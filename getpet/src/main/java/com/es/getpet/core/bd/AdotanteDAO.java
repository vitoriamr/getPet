package com.es.getpet.core.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.util.DAO;
import com.es.getpet.core.util.PropriedadesLista;
import com.es.getpet.core.util.TipoJuncao;

public class AdotanteDAO extends DAO<Adotante> {

	@Override
    public List<Adotante> lista(Adotante ed, PropriedadesLista pl) {
		return pesquisa(ed, pl, TipoJuncao.Conjuncao);
    }

	@Override
    public List<Adotante> busca(Adotante ed, PropriedadesLista pl) {
		return pesquisa(ed, pl, TipoJuncao.Discjuncao);
    }

	@Override
	public Adotante consulta(Adotante ed) {
		Session session = getSession();
		session.beginTransaction();
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Adotante> criteria = builder.createQuery(Adotante.class);
		Root<Adotante> raiz = criteria.from(Adotante.class);
		Predicate[] arrayPredicados = { builder.equal(raiz.get("id"), ed.getId()) };
		criteria.where(builder.and(arrayPredicados));
		List<Adotante> lista = getSession().createQuery(criteria).getResultList();
		session.getTransaction().commit();
		return lista.isEmpty() ? null : lista.get(0);
    }

	private List<Adotante> pesquisa(Adotante ed, PropriedadesLista pl, TipoJuncao tipoJuncao) {
		Session session = getSession();
		session.beginTransaction();
		List<Adotante> listaAnimal = session.createQuery(montaCriteria(ed, pl, tipoJuncao)).getResultList();
		session.getTransaction().commit();
    	return listaAnimal;
	}

    private CriteriaQuery<Adotante> montaCriteria(Adotante ed, PropriedadesLista pl, TipoJuncao tipoJuncao) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Adotante> criteria = builder.createQuery(Adotante.class);
		Root<Adotante> raiz = criteria.from(Adotante.class);
		List<Predicate> listaPredicados = new ArrayList<>();
		if (ed.getNome() != null) {
			listaPredicados.add(builder.like(raiz.get("nome"), "%" + ed.getNome() + "%"));
		}
		Predicate[] arrayPredicados = new Predicate[listaPredicados.size()];
		arrayPredicados = listaPredicados.toArray(arrayPredicados);
		criteria.where(builder.and(arrayPredicados));
    	return criteria;
    }
}
