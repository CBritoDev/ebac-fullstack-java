package br.com.cbritodev;

import br.com.cbritodev.dao.ClienteMapDAO;
import br.com.cbritodev.dao.IClienteDAO;
import br.com.cbritodev.domain.Cliente;
import br.com.cbritodev.domain.Endereco;

import javax.swing.*;

/**
 * @author carlos.brito
 * Criado em: 19/06/2025
 */
public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args){

        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite o número correspondente as opções abaixo:\n" +
                "1 - Cadastrar novo cliente\n2 - Consultar cliente\n3 - Excluir cliente\n" +
                        "4 - Alterar dados do cliente\n5 - Sair",
                "Cadastro",JOptionPane.INFORMATION_MESSAGE);


        while(!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida, digite uma das opções abaixo:\n" +
                            "1 - Cadastrar novo cliente\n2 - Consultar cliente\n3 - Excluir cliente\n" +
                            "4 - Alterar dados do cliente\n5 - Sair",
                    "Cadastro",JOptionPane.INFORMATION_MESSAGE);

        }

        while(isOpcaoValida(opcao)){
            if (isOpcaoValida(opcao)) {
                if (isOpcaoSair(opcao)) {
                    sair();
                } else if (isOpcaoCadastro(opcao)) {
                    String dadosPrincipais = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente separados por virgula, conforme exemplo:" +
                                    " Nome, CPF, Telefone", "Cadastro", JOptionPane.INFORMATION_MESSAGE
                    );
                    String dadosEndereco = JOptionPane.showInputDialog(null,
                            "Digite seu endereço separado por vírgula conforme exemplo: " +
                                    "Rua, Número, CEP, Bairro, Cidade, Estado (Sigla)",
                            "Dados de endereço", JOptionPane.INFORMATION_MESSAGE
                    );
                    cadastrar(dadosPrincipais, dadosEndereco);
                } else if(isConsultar(opcao)){
                    String dadoCPF = JOptionPane.showInputDialog(null, "Digite o CPF do cliente: ", "Verificação de dados",
                            JOptionPane.INFORMATION_MESSAGE);
                    consultar(dadoCPF);
                }else if(isExcluir(opcao)){
                    String dadoCPF = JOptionPane.showInputDialog(null, "Digite o CPF do cliente: ", "Verificação de dados",
                            JOptionPane.INFORMATION_MESSAGE);
                    excluirCliente(dadoCPF);
                }else if(isAlterar(opcao)){
                    String dadoCPF = JOptionPane.showInputDialog(null, "Digite o CPF do cliente: ", "Verificação de dados",
                            JOptionPane.INFORMATION_MESSAGE);
                    alterarDados(dadoCPF);
                }
                opcao = JOptionPane.showInputDialog(null,
                        "Digite o número correspondente as opções abaixo:\n" +
                                "1 - Cadastrar novo cliente\n2 - Consultar cliente\n3 - Excluir cliente\n" +
                                "4 - Alterar dados do cliente\n5 - Sair",
                        "Cadastro",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private static void alterarDados(String dadoCPF) {
        String formatacaoCPF = dadoCPF.replaceAll("\\D", "");
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(formatacaoCPF.trim()));
        Cliente clienteCopiaSeguranca = alteracaoCopiaSegurancaCliente(cliente);

        if(cliente != null){
            while(true){
                String opcao = JOptionPane.showInputDialog(null,
                        "Digite a opção desejada para o cliente: \n"+
                                "1 - Alterar nome\n2 - Alterar telefone\n3 - Alterar endereço" +
                                "\n4 - Salvar\n5 - Cancelar",
                        "Cadastro",JOptionPane.INFORMATION_MESSAGE);
                try{
                    if(isOpcaoValida(opcao)){
                        switch (opcao) {
                            case "1" -> {
                                String novoNome = JOptionPane.showInputDialog(null, "Digite o novo nome: ",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
                                String confirmacao = JOptionPane.showInputDialog(null, "Nome anterior: "+ cliente.getNome() +"\nNome digitado: " + novoNome + "\nDigite 1 para CONFIRMAR ou 2 para CANCELAR",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);

                                if (isOpcaoValida(confirmacao)) {
                                    if (confirmacao.equals("1")) {
                                        clienteCopiaSeguranca.setNome(novoNome);
                                    } else if (confirmacao.equals("2")) {
                                        continue;
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Opção inválida. Digite novamente","ERRO",JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                            }
                            case "2" -> {
                                String novoTelefone = JOptionPane.showInputDialog(null, "Digite o novo número: ",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
                                String confirmacao = JOptionPane.showInputDialog(null,"Número anterior: "+ cliente.getTel() +"\nNúmero digitado: " + novoTelefone + "\nDigite 1 para CONFIRMAR ou 2 para CANCELAR",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
                                novoTelefone.replaceAll("\\D", "");
                                if (isOpcaoValida(confirmacao)) {
                                    if (confirmacao.equals("1")) {
                                        clienteCopiaSeguranca.setTel(Long.parseLong(novoTelefone));
                                    } else if (confirmacao.equals("2")) {
                                        continue;
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Opção inválida. Digite novamente","ERRO",JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                            }
                            case "3" -> {
                                String novoEndereco = JOptionPane.showInputDialog(null, "Digite o novo endereço conforme exemplo a seguir, separado por vírgula\n" +
                                                "Rua, Numero, CEP, Bairro, Cidade, Estado(Sigla)\n'ATENÇÃO! PREENCHA TODOS OS CAMPOS' ",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
                                String[] enderecoDadosSeparados = novoEndereco.split(",");

                                if (!validarDados(enderecoDadosSeparados, 6, "endereco")) {
                                    continue;
                                }

                                Endereco endereco = new Endereco(enderecoDadosSeparados[0], Integer.parseInt(enderecoDadosSeparados[1]), enderecoDadosSeparados[2], enderecoDadosSeparados[3],
                                        enderecoDadosSeparados[4], enderecoDadosSeparados[5]);


                                String confirmacao = JOptionPane.showInputDialog(null, "Endereço anterior: "+ cliente.getEndereco() +"\nEndereço digitado:\n " + endereco.toString() + "\nDigite 1 para CONFIRMAR ou 2 para CANCELAR",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);
                                if (isOpcaoValida(confirmacao)) {
                                    if (confirmacao.equals("1")) {
                                        clienteCopiaSeguranca.setEndereco(endereco);
                                    } else if (confirmacao.equals("2")) {
                                        continue;
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Opção inválida. Digite novamente","ERRO",JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                            }
                            case "4" -> {

                                String confirmacao = JOptionPane.showInputDialog(null, "Deseja confirmar as alterações feitas no cliente:\n " + clienteCopiaSeguranca.toString()+"\n\nDigite 1 para SIM ou 2 para NÃO" +"\n",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);

                                if (isOpcaoValida(confirmacao)) {
                                    if (confirmacao.equals("1")) {
                                        cliente.setNome(clienteCopiaSeguranca.getNome());
                                        cliente.setTel(clienteCopiaSeguranca.getTel());
                                        cliente.setEndereco(clienteCopiaSeguranca.getEndereco());
                                        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!\nVoltando ao menu principal...", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    } else if (confirmacao.equals("2")) {
                                        JOptionPane.showMessageDialog(null, "Voltando ao menu anterior...", "Confirmação de Dados", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }

                            }
                            case "5" -> {

                                String confirmacao = JOptionPane.showInputDialog(null, "Deseja sair sem salvar as alterações feitas no cliente:\n " + clienteCopiaSeguranca.getNome() + "\nDigite 1 para SIM ou 2 para NÃO",
                                        "Alteração de dados", JOptionPane.INFORMATION_MESSAGE);

                                if (isOpcaoValida(confirmacao)) {
                                    if (confirmacao.equals("1")) {
                                        JOptionPane.showMessageDialog(null, "Operação cancelada. Voltando ao menu principal...", "Cancelando operação", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    } else if (confirmacao.equals("2")) {
                                        JOptionPane.showMessageDialog(null, "Voltando ao menu anterior...", "Cancelando operação", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }
                            }
                        }
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Erro inesperado!","ERRO",JOptionPane.INFORMATION_MESSAGE);
                }
            }

        }
    }



    private static Cliente alteracaoCopiaSegurancaCliente(Cliente cliente){
        return new Cliente(cliente.getNome(),cliente.getCpf(),cliente.getTel(),cliente.getEndereco());
    }

    private static boolean isAlterar(String opcao) {
        return "4".equals(opcao);
    }

    private static void excluirCliente(String dadoCPF) {
        String formatacaoCPF = dadoCPF.replaceAll("\\D", "");
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(formatacaoCPF.trim()));
        if(cliente != null){
            while(true){
                try {
                    String opcao = JOptionPane.showInputDialog(null, "Tem certeza que deseja excluir o cliente: " + cliente.getNome() + " ?" +
                                    "\n" + "Digite 1 para SIM ou 2 para NÃO",
                            "Confirmação", JOptionPane.INFORMATION_MESSAGE);
                    int escolha = Integer.parseInt(opcao);
                    if (escolha == 1) {
                        iClienteDAO.excluir(Long.parseLong(formatacaoCPF.trim()));
                        JOptionPane.showMessageDialog(null, "Exclusão bem sucedida!", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else if (escolha == 2) {
                        JOptionPane.showMessageDialog(null, "Operação cancelada.\nVoltando ao menu principal", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção inválida!", "Cliente", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Opção não válida. Digite apenas os números das opções apresentas!", "Erro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não encontrado", "Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isExcluir(String opcao) {
        return "3".equals(opcao);
    }

    private static void consultar(String dadoCPF) {

        String formatacaoCPF = dadoCPF.replaceAll("\\D", "");
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(formatacaoCPF.trim()));
        if(cliente != null){
            JOptionPane.showMessageDialog(null,"Cliente encontrado:\n" + cliente.toString(),"Cliente",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Cliente não encontrado","Cliente",JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static void cadastrar(String dadosPrincipais, String dadosEndereco) {
        String[] dadosSeparados = dadosPrincipais.split(",");
        if(!validarDados(dadosSeparados, 3, "cliente")){
            sair();
        }
        String[] dadosSeparadosEndereco = dadosEndereco.split(",");
        if(!validarDados(dadosSeparadosEndereco, 6, "endereco")){
            sair();
        }
        Endereco endereco = new Endereco(dadosSeparadosEndereco[0], Integer.parseInt(dadosSeparadosEndereco[1].trim()), dadosSeparadosEndereco[2],
                dadosSeparadosEndereco[3],dadosSeparadosEndereco[4], dadosSeparadosEndereco[5]);

        Cliente cliente = new Cliente(dadosSeparados[0],Long.parseLong(dadosSeparados[1].trim()), Long.parseLong(dadosSeparados[2].trim()), endereco);

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);

        if (isCadastrado){
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!","Cadastro concluído",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Cliente já cadastrado no sistema!","Cadastro anulado",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean validarDados(String[] dados, int esperado, String contexto){
        if(dados.length != esperado) {
            JOptionPane.showMessageDialog(null, "Dados não preenchidos corretamente.\n " +
                    "Preencha todos os dados necessários!", "Erro de cadastro", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo!","Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao);
    }



}
