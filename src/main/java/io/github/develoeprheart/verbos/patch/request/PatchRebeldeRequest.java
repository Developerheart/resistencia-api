package io.github.develoeprheart.verbos.patch.request;


import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

@Builder
public class PatchRebeldeRequest implements Serializable {

    private String nome;
    private Integer idade;
    private Character genero;

    private LocalizacaoRequest localizacao;

    public PatchRebeldeRequest(String nome, Integer idade, Character genero, LocalizacaoRequest localizacao) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacao = localizacao;

    }

    @Override
    public String toString() {
        return "RebeldeRequest{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", genero=" + genero +
                ", localizacao=" + localizacao +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatchRebeldeRequest that = (PatchRebeldeRequest) o;
        return Objects.equals(nome, that.nome) && Objects.equals(idade, that.idade) && Objects.equals(genero, that.genero) && Objects.equals(localizacao, that.localizacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, genero, localizacao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public LocalizacaoRequest getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoRequest localizacao) {
        this.localizacao = localizacao;
    }

}
