import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DadosCliente implements RespositoryCliente {

    List<Cliente> listaDeClientes = new ArrayList<>();
    @Override
    public void buscar(List<Cliente> lista, String nomeBusca) {
        System.out.println("Resultado da busca por: "+nomeBusca);

        List<Cliente> resultadoNome = lista.stream()
                .filter(cliente -> nomeBusca.equals(cliente.getNomeCliente())).toList();

        List<Cliente> resultadoRazaoSocial = lista.stream()
                .filter(cliente -> nomeBusca.equals(cliente.getRazaoSocialCliente())).toList();

        if (!resultadoNome.isEmpty() || !resultadoRazaoSocial.isEmpty()) {
            resultadoNome.forEach(cliente -> System.out.println("CPF: "+cliente.getCpfCliente()));
            resultadoRazaoSocial.forEach(cliente -> System.out.println("CNPJ: "+cliente.getCnpjCliente()));
            System.out.println("--------------------");
        } else {
            System.out.println("Nenhum resultado encontrado para cliente "+nomeBusca+".");
            System.out.println("--------------------");
        }
    }


    @Override
    public <T extends Cliente> void cadastrar(T cliente) {
        if (isClienteDisponivel(cliente.getCnpjCliente())) {
            throw new IllegalArgumentException("Cliente CNPJ nº " + cliente.getCnpjCliente() +
                    " já consta no banco de dados");
        }

        if (isClienteDisponivel(cliente.getCpfCliente())) {
            throw new IllegalArgumentException("Cliente CPF nº " + cliente.getCpfCliente() +
                    " já consta no banco de dados");
        }

        listaDeClientes.add(cliente);
        System.out.println("Novo cadastro de cliente realizado com sucesso!");
        System.out.println("--------------------");
    }

    private boolean isClienteDisponivel(String numeroDocumento) {
        return consultar(numeroDocumento) != null;
    }


    @Override
    public <T extends Cliente> void deletar(T cliente) {
        if (cliente.getClass().getSimpleName().equals("ClientePJ")) {
            if (isClienteDisponivel(cliente.getCnpjCliente())) {
                listaDeClientes.remove(cliente);
                System.out.println("Cliente CNPJ nº " + cliente.getCnpjCliente() + " foi deletado com sucesso.");
            }
        } else {
            if (isClienteDisponivel(cliente.getCpfCliente())) {
                listaDeClientes.remove(cliente);
                System.out.println("Cliente CPF nº " + cliente.getCpfCliente() + " foi deletado com sucesso.");
            }
        }
    }

    @Override
    public <T extends Cliente> void atualizar(T cliente1, T cliente2) {
        if (cliente1.getClass().getSimpleName().equals("ClientePJ")) {
            if (!isClienteDisponivel(cliente1.getCnpjCliente())) {
                throw new IllegalArgumentException("Não foi possível atualizar cliente CNPJ nº "
                        + cliente1.getCnpjCliente() + " pois o mesmo ainda não foi cadastrado.");
            }
        } else {
            if (!isClienteDisponivel(cliente1.getCpfCliente())) {
                throw new IllegalArgumentException("Não foi possível atualizar cliente CPF nº "
                        + cliente1.getCpfCliente() + " pois o mesmo ainda não foi cadastrado.");
            }
        }
        deletar(cliente1);
        cadastrar(cliente2);
    }

    @Override
    public Cliente consultar(String numeroDocumento) {
        for (Cliente cliente : listaDeClientes) {
            if (cliente.getClass().getSimpleName().equals("ClientePJ")) {
                if (cliente.getCnpjCliente().equals(numeroDocumento)) {
                    return cliente;
                }
            } else if (cliente.getCpfCliente().equals(numeroDocumento)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        if (listaDeClientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
        } else {
            System.out.println("Lista de Clientes: \n");
            for (Cliente cliente : listaDeClientes) {
                if (cliente.getClass().getSimpleName().equals("ClientePJ")) {
                    System.out.println("Tipo: " + cliente.getClass().getSimpleName() +
                            "\nID: " + cliente.getIdCliente() +
                            "\nCNPJ: " + cliente.getCnpjCliente() +
                            "\nRazão Social: " + cliente.getRazaoSocialCliente());
                    System.out.println("--------------------");
                } else {
                    System.out.println("Tipo: " + cliente.getClass().getSimpleName() +
                            "\nID: " + cliente.getIdCliente() +
                            "\nCPF: " + cliente.getCpfCliente() +
                            "\nNome: " + cliente.getNomeCliente());
                    System.out.println("--------------------");
                }
            }
        }
        return listaDeClientes;
    }
}
