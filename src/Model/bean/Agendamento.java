/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana
 */
public class Agendamento {
    
    private int id;
    private String nome_cliente;
    private String nome_servico;
    private String valor;
    private String data;
    private String hora;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_Cliente() {
        return nome_cliente;
    }

    public void setNome_Cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_Servico() {
        return nome_servico;
    }

    public void setNome_Servico(String nome_servico) {
        this.nome_servico = nome_servico;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}
