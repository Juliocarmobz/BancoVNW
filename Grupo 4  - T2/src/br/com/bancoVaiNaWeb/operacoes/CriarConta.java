package br.com.bancoVaiNaWeb.operacoes;

import br.com.bancoVaiNaWeb.cliente.Cliente;
import br.com.bancoVaiNaWeb.conta.Conta;

import java.util.InputMismatchException;
import java.util.Random;

import java.util.Scanner;

import com.sun.tools.javac.Main;

public class CriarConta {
    public static Conta criarConta() {
        Conta conta = new Conta(0, 0, null,	0);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String cpf = null, cnpj = null , nome = null;
        int tipoConta;
        do {
            try {
                System.out.println("QUE BOM QUE VOCÊ QUER SER NOSSO CLIENTE! VAMOS COMEÇAR:");
                // Vamos criar os dados do cliente
                		
                		System.out.println("QUAL TIPO DE CONTA VOCÊ DESEJA CRIAR:\n"
                				+ "[1] POUPANÇA"
                				+ " [2] CORRENTE"
                				+ " [3] JURÍDICA");
                			tipoConta = scanner.nextInt();
                			scanner.nextLine();
                     	   if(tipoConta == 1 || tipoConta == 2 ) {
                     			System.out.println("INFORME SEU NOME COMPLETO: ");
                     			nome = scanner.nextLine();
	                       	   	do {
	                       	   		System.out.println("INFORME SEU CPF: ");
	                       	   		cpf = scanner.nextLine();
	                       	   			if(cpf.length() < 11 || cpf.length() > 11 ) {
	                       	   				System.err.print("CPF INVÁLIDO.");
	                       	   				System.out.println(" POR FAVOR, TENTE NOVAMENTE...");
	                       	   			}
	                       	   	} while(cpf.length() < 11 || cpf.length() > 11);
	                       	   	
                     	   } else if(tipoConta == 3) {
                     		  System.out.println("INFORME O NOME FANTASIA: ");
                              nome = scanner.nextLine(); 
                     		  do {
                     			  System.out.println("AGORA, SEU CNPJ:");
                     			  cnpj = scanner.nextLine();
                     	   				if(cnpj.length() < 14 || cnpj.length() > 14) {
                     	   				System.err.print("CNPJ INVÁLIDO.");
                     	   				System.out.println(" POR FAVOR, TENTE NOVAMENTE...");
                     	   				}
                     	   		} while (cnpj.length() < 14 || cnpj.length() > 14);
                     		  
                     	   } else {
                     		   System.err.println("ESCOLHA INVÁLIDA.");
                     		   
                     	   }
                     	   

                Cliente cliente = new Cliente(nome, cpf, cnpj);
                	double saldo = 0;
                // Agora a conta
            	   if(tipoConta == 1) {
            		   System.out.println("DIGITE O VALOR DE CAPITAL INICIAL:");
            		   saldo = scanner.nextDouble();
            		   System.out.println("QUAL VALOR DO APORTE MENSAL?");
            		   double depMes = scanner.nextDouble();
            		   System.out.println("QUANTO TEMPO, EM MESES, VOCÊ IRÁ DEPOSITAR O APORTE? ");
            		   int tempo = scanner.nextInt();
            		   for (int i = 0 ; i < tempo; i++ ) {
            			   saldo += depMes;
            			   double juros =  saldo * 0.005;
            			   saldo += juros;
            		   }
            		   
            		   if (tempo / 12 < 1) {
            			   System.out.println("LUCRO EM  "+ tempo + " MESES, DE ACORDO COM 0,5% AO MÊS: "+ String.format("%.2f", saldo));
            		   } else {
            			   System.out.println("LUCRO EM  "+ tempo / 12 + " ANOS, DE ACORDO COM 0,5% AO MÊS: "+ String.format("%.2f", saldo)); 
            		   }
            		   
            		  
            	   }
                   
                   int numero = random.nextInt(10000000);
                   conta = new Conta(numero, saldo, cliente, tipoConta);
               
                // Se chegou até aqui sem lançar exceção, podemos sair do loop
                break;
            } catch (InputMismatchException e) {
                System.out.println("ENTRADA INVÁLIDA. VAMOS COMEÇAR NOVAMENTE.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loops infinitos
            } catch (Exception err) {
                System.out.println("OCORREU UM ERRO INESPERADO: " + err.getMessage());
                break; // Se ocorrer um erro inesperado, sai do loop
            }
        } while (true);
        
		return conta;
        
    }
}
