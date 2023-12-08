package br.com.bancoVaiNaWeb.conta;

import br.com.bancoVaiNaWeb.cliente.Cliente;

public class Conta {

    private int numero;
    public double saldo;
    private int tipoConta;
    public static Cliente cliente;

    public Conta(int numero, double saldo, Cliente cliente, int tipoConta) {
        this.saldo = saldo;
        Conta.cliente = cliente;
        this.numero = numero;
        this.tipoConta = tipoConta;
        
    }


    public void visualizarDadosConta() {
        if (cliente != null) {
            System.out.println("NOME: " + cliente.nome);
            if(tipoConta == 1) {
            	System.out.println("TIPO DE CONTA: POUPANÇA" );
            	System.out.println("CPF: " + cliente.cpf);
            } else if (tipoConta == 2) {
            	System.out.println("TIPO DE CONTA: CORRENTE" );
            	System.out.println("CPF: " + cliente.cpf);
            } else if (tipoConta == 3){
            	System.out.println("TIPO DE CONTA: JURÍDICA" );
            	System.out.println("CNPJ: " + cliente.cnpj);
            }
            
            System.out.println("NÚMERO DA CONTA " + numero);
            System.out.println("SALDO: " + saldo);
        } else {
            System.out.println("CLIENTE NÃO ENCONTRADO PARA ESSA CONTA.");
        }
    }
}
