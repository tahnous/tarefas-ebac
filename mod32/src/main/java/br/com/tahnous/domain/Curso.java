package br.com.tahnous.domain;

import jakarta.persistence.*;

@Entity
@Table(name =  "TB_CURSO")
public class Curso {

    @Id
    @GeneratedValue (strategy= GenerationType.SEQUENCE, generator="curso_seq")
    @SequenceGenerator(name="curso_seq", sequenceName="sq_curso", initialValue = 1, allocationSize = 1)
    private  Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private  String  codigo;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String  descricao;

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
