function getEspecie(especie) {
	return especie === 'CAO' ? 'Cachorro' : 'Gato'
}

function getSexo(sexo) {
	return sexo === 'FEMEA' ? 'Fêmea' : 'Macho'
}

export function Animal({ castrado, cuidador, doencasLimitacoes, especie, id, idade, nome, obs, raca, sexo, tamanho, temperamento, unidade }) {
	if ( !(this instanceof Animal) )
	      return new Animal();

	this.castrado = castrado
	this.cuidador = cuidador
	this.doencasLimitacoes = doencasLimitacoes
	this.especie = getEspecie(especie)
	this.id = id
	this.idade = idade
	this.nome = nome
	this.obs = obs
	this.raca = raca
	this.sexo = getSexo(sexo)
	this.tamanho = tamanho
	this.temperamento = temperamento
	this.unidade = unidade
}
