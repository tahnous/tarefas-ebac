package br.com.tahnous.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_MARCA")
public class Marca {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="marca_seq")
    @SequenceGenerator(name="marca_seq", sequenceName="sq_marca", initialValue = 1, allocationSize = 1)
    private  Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private  String  codigo;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "marca")
    private List<Carro> carros;

    @OneToMany(mappedBy = "marca")
    private List<Acessorio> acessorios;

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public Long getId() {
        return id;
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


}
