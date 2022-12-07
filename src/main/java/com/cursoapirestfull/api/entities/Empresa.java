package com.cursoapirestfull.api.entities;




import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Table(name = "empresa")
@Entity
public class Empresa implements Serializable {
    static final long serialVersionUID = 42L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "razao_social",nullable = false)
    private String razaoSocal;
    @Column(name = "cnpj",nullable = false)
    private String cnpj;
    @Column(name = "dt_criacao",nullable = false)
    private Date dataCriacao;
    @Column(name = "dt_atualizacao",nullable = false)
    private Date dataAtualizacao;
    @ManyToMany(mappedBy = "empresa",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;

    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = new Date();
    }
    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao=atual;
        dataAtualizacao=atual;
    }

    public Empresa() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRazaoSocal() {
        return razaoSocal;
    }

    public void setRazaoSocal(String razaoSocal) {
        this.razaoSocal = razaoSocal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", razaoSocal='" + razaoSocal + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
