package com.cursoapirestfull.api.entities;

import com.cursoapirestfull.api.enums.TipoEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data",nullable = false)
    private Date data;
    @Column(name = "descricao",nullable = true)
    private String descricao;
    @Column(name = "localizacao",nullable = true)
    private String localizacao;
    @Column(name = "dt_criacao",nullable = false)
    private Date dataCriacao;
    @Column(name = "dt_atualizacao",nullable = false)
    private Date dataAtualizacao;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo",nullable = false)
    private TipoEnum tipo;
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario funcionario;

    public Lancamento(){

    }
    @PreUpdate
    public void preUpdate(){
        dataAtualizacao = new Date();
    }
    @PrePersist
    public void PrePersist(){
        final Date atual = new Date();
        dataAtualizacao = atual;
        dataCriacao = atual;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
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

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Lancamento{" +
                "id=" + id +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", localizacao='" + localizacao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", tipo=" + tipo +
                ", funcionario=" + funcionario +
                '}';
    }
}
