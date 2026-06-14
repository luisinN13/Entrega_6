package Entrega6;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        ArrayList<Notificacao> notificacoes = new ArrayList<>();

        notificacoes.add(new NotificacaoEmail());
        notificacoes.add(new NotificacaoSms());
        notificacoes.add(new NotificacaoWhatsApp());

        ServicoNotificacao servico = new ServicoNotificacao();

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println(" SISTEMA DE NOTIFICAÇÕES");
            System.out.println("==============================\n");
            System.out.println("1 - E-mail 📧");
            System.out.println("2 - SMS 📱");
            System.out.println("3 - WhatsApp 💬");
            System.out.println("0 - Sair\n");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite a mensagem: ");
                    String mensagemEmail = sc.nextLine();
                    servico.notificarCliente(notificacoes.get(0), mensagemEmail);
                    break;

                case 2:
                    System.out.print("\nDigite a mensagem: ");
                    String mensagemSms = sc.nextLine();
                    servico.notificarCliente(notificacoes.get(1), mensagemSms);
                    break;

                case 3:
                    System.out.print("\nDigite a mensagem: ");
                    String mensagemWhats = sc.nextLine();
                    servico.notificarCliente(notificacoes.get(2), mensagemWhats);
                    break;

                case 0:
                    System.out.println("\nPrograma encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }
}

interface Notificacao {
    void enviar(String mensagem);
}

class NotificacaoEmail implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

class NotificacaoSms implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS: " + mensagem);
    }
}

class NotificacaoWhatsApp implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando WhatsApp: " + mensagem);
    }
}

class ServicoNotificacao {

    public void notificarCliente(Notificacao notificacao, String mensagem) {
        notificacao.enviar(mensagem);
	}
}
