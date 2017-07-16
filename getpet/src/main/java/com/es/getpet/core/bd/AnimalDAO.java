package com.es.getpet.core.bd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.es.getpet.core.ed.Adocao;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.util.DAO;
import com.es.getpet.core.util.PropriedadesLista;
import com.es.getpet.core.util.TipoJuncao;


public class AnimalDAO extends DAO<Animal> {

	@Override
    public List<Animal> lista(Animal ed, PropriedadesLista pl) {
		return pesquisa(ed, pl, TipoJuncao.Conjuncao);
    }

	@Override
    public List<Animal> busca(Animal ed, PropriedadesLista pl) {
		return pesquisa(ed, pl, TipoJuncao.Discjuncao);
    }

	@Override
	public Animal consulta(Animal ed) {
		Session session = getSession();
		session.beginTransaction();
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
		Root<Animal> raiz = criteria.from(Animal.class);
		Predicate[] arrayPredicados = { builder.equal(raiz.get("id"), ed.getId()) };
		criteria.where(builder.and(arrayPredicados));
		List<Animal> lista = getSession().createQuery(criteria).getResultList();
		session.getTransaction().commit();
		return lista.isEmpty() ? null : lista.get(0);
    }

	private List<Animal> pesquisa(Animal ed, PropriedadesLista pl, TipoJuncao tipoJuncao) {
		Session session = getSession();
		session.beginTransaction();
		List<Animal> listaAnimal = session.createQuery(montaCriteria(ed, pl, tipoJuncao)).getResultList();
		session.getTransaction().commit();
    	return listaAnimal;
	}

    private CriteriaQuery<Animal> montaCriteria(Animal ed, PropriedadesLista pl, TipoJuncao tipoJuncao) {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
		Root<Animal> raiz = criteria.from(Animal.class);
		List<Predicate> listaPredicados = new ArrayList<>();
		if (ed.getNome() != null) {
			listaPredicados.add(builder.like(raiz.get("nome"), "%" + ed.getNome() + "%"));
		}
		Predicate[] arrayPredicados = new Predicate[listaPredicados.size()];
		arrayPredicados = listaPredicados.toArray(arrayPredicados);
		criteria.where(builder.and(arrayPredicados));
    	return criteria;
    }

    public List<Animal> getListaAnimaisDisponiveis() {
    	Session session = getSession();
    	session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
		Root<Animal> raiz = criteria.from(Animal.class);
		Join<Animal, Adocao> adocao = raiz.join("adocao", JoinType.LEFT);

		List<Predicate> listaPredicados = new ArrayList<>();
		listaPredicados.add(builder.isNull(raiz.get("adocao")));
		listaPredicados.add(builder.greaterThan(adocao.get("statusAdocao"), 2));

		Predicate[] arrayPredicados = new Predicate[listaPredicados.size()];
		arrayPredicados = listaPredicados.toArray(arrayPredicados);
		criteria.where(builder.or(arrayPredicados));

		List<Animal> lista = session.createQuery(criteria).getResultList();
		session.getTransaction().commit();
		return lista;
    }

    public List<Animal> getListaAnimaisCuidador(Cuidador cuidador) {
    	Session session = getSession();
    	session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
		Root<Animal> raiz = criteria.from(Animal.class);
		Join<Animal, Adocao> adocao = raiz.join("adocao", JoinType.LEFT);

		List<Predicate> listaPredicados = new ArrayList<>();
		listaPredicados.add(builder.isNull(raiz.get("adocao")));
		listaPredicados.add(builder.greaterThan(adocao.get("statusAdocao"), 2));

		Predicate[] arrayPredicados = new Predicate[listaPredicados.size()];
		arrayPredicados = listaPredicados.toArray(arrayPredicados);
		criteria.where(builder.and(builder.equal(raiz.get("cuidador"), cuidador), builder.or(arrayPredicados)));

		List<Animal> lista = session.createQuery(criteria).getResultList();
		session.getTransaction().commit();
		return lista;
    }

}