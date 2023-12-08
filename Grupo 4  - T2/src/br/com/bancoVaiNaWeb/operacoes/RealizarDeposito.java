package br.com.bancoVaiNaWeb.operacoes;

import br.com.bancoVaiNaWeb.conta.Conta;

public class RealizarDeposito {

    public static void realizarDeposito(Conta conta, double valorDeposito) {
        if (valorDeposito > 0) {
            double novoSaldo = conta.saldo + valorDeposito;
            conta.saldo = novoSaldo;
            System.out.println("DEPÓSITO REALIZADO COM SUCESSO!");
            System.out.println("NOVO SALDO " + novoSaldo);
        } else {
            System.out.println("VALOR INVÁLIDO PARA DEPÓSITO");
        }
    }
}
