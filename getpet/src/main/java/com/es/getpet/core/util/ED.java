package com.es.getpet.core.util;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ED {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash += 71 * (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object objeto) {
        boolean r;
        if (objeto != null) {
            r = objeto instanceof ED;
            if (r) {
                Long objId = ((ED) objeto).getId();
                r = getId() != null && getId().equals(objId) || (objId == null && getId() == null);
            }
        } else {
            r = false;
        }
        return r;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
