package br.com.bancoVaiNaWeb.conta;

import br.com.bancoVaiNaWeb.cliente.Cliente;

public class ContaPoupanca {

    private int numero;
    public double saldo;

    public static Cliente cliente;

    public ContaPoupanca(int numero, double saldo, Cliente cliente) {
        this.saldo = saldo;
        ContaPoupanca.cliente = cliente;
        this.numero = numero;
    }


    public void visualizarDadosConta() {
        if (cliente != null) {
            System.out.println("NOME: " + cliente.nome);
            System.out.println("CPF: " + cliente.cpf);
            System.out.println("NÚMERO DA CONTA: " + numero);
            System.out.println("SALDO: " + saldo);
        } else {
            System.out.println("CLIENTE NÃO ENCONTRADO PARA ESSA CONTA.");
        }
    }
}
