package br.com.tahnous.domain;

public class Produto {

    private Long id;
    private String codigo;
    private String nome;
    private float preco;

    public Produto() {

    }

    public Produto(String nome, String codigo, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }



}
