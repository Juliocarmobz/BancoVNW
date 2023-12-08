package br.com.bancoVaiNaWeb;

import br.com.bancoVaiNaWeb.conta.Conta;
import br.com.bancoVaiNaWeb.operacoes.CriarConta;

import java.util.InputMismatchException;
import java.util.Scanner;

import static br.com.bancoVaiNaWeb.operacoes.Calculadora.calcularGastos;
import static br.com.bancoVaiNaWeb.operacoes.RealizarDeposito.realizarDeposito;
import static br.com.bancoVaiNaWeb.operacoes.RealizarSaque.realizarSaque;


public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Conta conta = null;
        int opcao = -1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("BEM VINDO AO BANCO VNW\n" + "PARA SELECIONAR UMA OPÇÃO, ESCOLHA UMA ÇÃO ABAIXO:");
        while (opcao != 0) {
            try {
                System.out.println("[1] CALCULAR GASTOS");
                System.out.println("[2] CRIAR CONTA"); // Crie uma conta
                System.out.println("[3] REALIZAR UM DEPÓSITO");
                System.out.println("[4] REALIZAR UM SAQUE");
                System.out.println("[5] VERIFICAR OS DADOS DA SUA CONTA ");
                System.out.println("[0] SAIR");

                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        calcularGastos();
                        separadorMenu();
                        break;
                    case 2:
                        conta = CriarConta.criarConta();
                        separadorMenu();
                        break;

                    case 3:
                        if (conta != null) {
                            System.out.println("DIGITE O VALOR A SER DEPOSITADO: ");
                            double valor = scanner.nextDouble();
                            realizarDeposito(conta, valor);
                        } else {
                            System.out.println("É NECESSÁRIO CRIAR UMA CONTA NO BANCO");
                        }
                        break;
                    case 4:
                        if (conta != null) {
                            System.out.println("DIGITE O VALOR A SER SACADO: ");
                            double valor = scanner.nextDouble();

                            realizarSaque(conta, valor);
                        } else {
                            System.out.println("É NECESSÁRIO CRIAR UMA CONTA NO BANCO");
                        }
                        break;
                    case 5:
                        if (conta != null) {
                            conta.visualizarDadosConta();
                        } else {
                            System.out.println("É NECESSÁRIO CRIAR UMA CONTA NO BANCO");
                        }
                        separadorMenu();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("OPÇÃO INVÁLIDA. DIGITE UM NÚMERO INTEIRO");
                scanner.next();
            } catch (Exception err) {
                System.out.println("OCORREU UM ERRO INESPERADO " + err.getMessage());
            }
        }
        scanner.close();
    }

    public static void separadorMenu() {
        System.out.println("----------------------------------------------");
    }
}
