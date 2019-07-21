package br.com.danieltedev.importcsv;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Pessoa
 */
@Entity
public class Pessoa {

    @Id
    private Long id;
    private String nome;
    private Long telefone;
    private String contato;
    private String texto;
    @Version
    @Transient
    private Long version;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Long telefone, String contato, String texto) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.contato = contato;
        this.texto = texto;
    }

    public Pessoa(Long id, String nome, Long telefone, String contato, String texto, Long version) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.contato = contato;
        this.texto = texto;
        this.version = version;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTelefone() {
        return this.telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getContato() {
        return this.contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) 
        && Objects.equals(nome, pessoa.nome) 
        && Objects.equals(telefone, pessoa.telefone) 
        && Objects.equals(contato, pessoa.contato) 
        && Objects.equals(texto, pessoa.texto) 
        && Objects.equals(version, pessoa.version)
        ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id
            , nome
            , telefone
            , contato
            , texto
            , version
            );
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", contato='" + getContato() + "'" +
            ", texto='" + getTexto() + "'" +
            ", version='" + getVersion() + "'" +
            "}";
    }

}