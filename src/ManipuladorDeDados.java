import java.util.List;


public class ManipuladorDeDados implements Cadastrador, Exibidor {

    public void buscaVeiculo(List<Veiculo> lista, String nomeBusca) {
        System.out.println("Resultado da busca por "+nomeBusca);
        lista.stream().filter(veiculo -> nomeBusca.equals(veiculo.getModelo()))
                .forEach(veiculo -> System.out.println("Placa: "+veiculo.getPlaca()));
    }

    public void buscaCliente(List<Cliente> lista, String nomeBusca) {
        System.out.println("Resultado da busca por "+nomeBusca);
        lista.stream().filter(cliente -> nomeBusca.equals(cliente.getNomeCliente()))
                .forEach(cliente -> System.out.println("CPF: "+cliente.getCpfCliente()));

        lista.stream().filter(cliente -> nomeBusca.equals(cliente.getRazaoSocialCliente()))
                .forEach(cliente -> System.out.println("CNPJ: "+cliente.getCnpjCliente()));

    }

    @Override
    public <T extends Veiculo> void cadastrarVeiculo(T veiculo) {
        if (isPlacaDisponivel(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Veiculo de placa " + veiculo.getPlaca() +
                    " já consta no banco de dados");
        }
        listaDeVeiculos.add(veiculo);
    }

    public <T extends Veiculo> void deletarVeiculo(T veiculo) {
        if (isPlacaDisponivel(veiculo.getPlaca())) {
            listaDeVeiculos.remove(veiculo);
            System.out.println("Veiculo placa " + veiculo.getPlaca() + " foi deletado com sucesso.");
        }
    }

    public <T extends Veiculo> void atualizarVeiculo(T veiculo1, T veiculo2) {
        if (!isPlacaDisponivel(veiculo1.getPlaca())) {
            throw new IllegalArgumentException("Não foi possível atualizar veículo " +
                    "pois o mesmo ainda não foi cadastrado!");
        }
        deletarVeiculo(veiculo1);
        cadastrarVeiculo(veiculo2);
    }

    public Veiculo consultarPlaca(String placa) {
        for (Veiculo veiculo : listaDeVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    private boolean isPlacaDisponivel(String placa) {
        return consultarPlaca(placa) != null;
    }

    @Override
    public void exibirListaDeVeiculos() {
        if (listaDeVeiculos.isEmpty()) {
            System.out.println("Não há veículos cadastrados.");
        } else {
            System.out.println("Lista de Veículos: \n");
            for (Veiculo veiculo : listaDeVeiculos) {
                System.out.println("Tipo: " + veiculo.getClass().getSimpleName() +
                                "\nCategoria: " + veiculo.getTipo() +
                                "\nModelo: " + veiculo.getModelo() +
                                "\nMarca: " + veiculo.getMarca() +
                                "\nAno: " + veiculo.getAno() +
                                "\nPlaca: " + veiculo.getPlaca() +
                                "\nKms Rodados: " + veiculo.getQuilometragem());
                System.out.println("--------------------");
            }
        }
    }

    //CLIENTES
    @Override
    public <T extends Cliente> void cadastrarCliente(T cliente) {

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
    }

    public <T extends Cliente> void deletarCliente(T cliente) {
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

    public <T extends Cliente> void atualizarCliente(T cliente1, T cliente2) {
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
        deletarCliente(cliente1);
        cadastrarCliente(cliente2);
    }

    // public <T extends ClientePJ> void cadastrarCliente(T clientePJ) {
//        listaDeClientes.add(clientePJ);
//    }

    @Override
    public void exibirListaDeClientes() {
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
    }

    public Cliente consultarCliente(String numeroDocumento) {
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
    private boolean isClienteDisponivel(String numeroDocumento) {
        return consultarCliente(numeroDocumento) != null;
    }


}
