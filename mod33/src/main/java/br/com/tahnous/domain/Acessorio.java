package br.com.tahnous.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_ACESSORIO")
public class Acessorio {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="acessorio_seq")
    @SequenceGenerator(name="acessorio_seq", sequenceName="sq_acessorio", initialValue = 1, allocationSize = 1)
    private  Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private  String  codigo;
    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String  descricao;


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_carro_fk",
            foreignKey =  @ForeignKey(name = "fk_acessorio_carro"),
            referencedColumnName = "id", nullable = false
    )
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_acessorio_marca"),
            referencedColumnName = "id", nullable = false
    )
    private Marca marca;




    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
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
