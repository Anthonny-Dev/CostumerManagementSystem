package br.com.banco.model;

import java.util.ArrayList;


// creating the class Account
public class Account {
    private int id_cliente;
    private String cpf;
    private String nome;
    private float valor_compra;
    private String forma_pag;
    private String status;
    private String telefone_cliente;

    private ArrayList<Produtos> produtos;


    public Account(int id_cliente, String cpf, String nome, float valor_compra, String forma_pag, String status, String telefone_cliente) {
        this.id_cliente = id_cliente;
        this.cpf = cpf;
        this.nome = nome;
        this.valor_compra = valor_compra;
        this.forma_pag = forma_pag;
        this.status = status;
        this.telefone_cliente = telefone_cliente;
    }


    // CRIAMOS OS GETTER E SETTERS DA CLASSE
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor_compra() {
        return valor_compra;
    }

    public void setValor_compra(float valor_compra) {
        this.valor_compra = valor_compra;
    }

    public String getForma_pag() {
        return forma_pag;
    }

    public void setForma_pag(String forma_pag) {
        this.forma_pag = forma_pag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }
}
