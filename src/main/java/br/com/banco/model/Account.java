package br.com.banco.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Account {
    private int idClient;
    private String cpf;
    private String nome;
    private float valor_compra;
    private String forma_pag;
    private String status;
    private String telefone_cliente;
    private LocalDateTime dataCompra;

    private ArrayList<Produtos> produtos;


    public Account(int idClient, String cpf, String nome, float valor_compra, String forma_pag, String status, String telefone_cliente, LocalDateTime dataCompra) {
        this.idClient = idClient;
        this.cpf = cpf;
        this.nome = nome;
        this.valor_compra = valor_compra;
        this.forma_pag = forma_pag;
        this.status = status;
        this.telefone_cliente = telefone_cliente;
        this.dataCompra = dataCompra;
        this.produtos = new ArrayList<>();

    }

    public Account( String cpf, String nome, Float valorCompra, String formaPag, String status, String telefoneCliente, LocalDateTime dataCompra) {
        //this.idClient = idClient;
        this.cpf = cpf;
        this.nome = nome;
        this.valor_compra = valorCompra;
        this.forma_pag = formaPag;
        this.status = status;
        this.telefone_cliente = telefoneCliente;
        this.dataCompra = dataCompra;
        this.produtos = new ArrayList<>();
    }

    public Account() {

    }

    // CRIAMOS OS GETTER E SETTERS DA CLASSE

    public void adicionarProdutos(Produtos produto){
        this.produtos.add(produto);
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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


    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

}
