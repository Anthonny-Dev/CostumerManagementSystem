package br.com.banco.model;

import java.util.ArrayList;

public class Produtos {

    private int id_produto;
    private int quantidade;
    private String nomeProduto;
    private String descricao;
    private double valor;


    private ArrayList<Produtos> produtos;

    public Produtos(int id_produto, int quantidade, String nomeProduto, String descricao, double valor) {
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produtos(int quantidade, String nomeProduto, String descricao, double valor) {
        this.quantidade = quantidade;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

}
