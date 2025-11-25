package br.com.tahnous.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="carro_seq")
    @SequenceGenerator(name="carro_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
    private  Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private  String  codigo;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false)
    private Double valor;

    public List<Acessorio> getAcessorio() {
        return acessorios;
    }

    public void setAcessorio(List<Acessorio> acessorio) {
        this.acessorios = acessorio;
    }

    @OneToMany(mappedBy = "carro",cascade = CascadeType.ALL)
    private List <Acessorio>  acessorios;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_carro_marca"),
            referencedColumnName = "id", nullable = false
    )
    private Marca marca;


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }



    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public Long getId() {
        return id;
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
    
}
