package br.com.bancoVaiNaWeb.operacoes;

import br.com.bancoVaiNaWeb.conta.Conta;


public class RealizarSaque {

    public static void realizarSaque(Conta conta, double valorSaque) {
        if (valorSaque > 0 && valorSaque <= conta.saldo ) {
        	conta.saldo -= valorSaque;
            System.out.println("SAQUE REALIZADO COM SUCESSO!");
            System.out.println("NOVO SALDO: " + conta.saldo);
        } else {
            System.out.println("VALOR INVÁLIDO PARA SAQUE OU SALDO INSUFICIENTE!");
        }
    }
}
