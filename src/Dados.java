public class Dados implements Cadastrador, Exibidor{


    @Override
    public <T extends Veiculo> void cadastrarVeiculo(T veiculo) {
        if (isPlacaDisponivel(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Veículo consta no banco de dados");
        }
        listaDeVeiculos.add(veiculo);
    }

    public <T extends Veiculo> void deletarVeiculo(T veiculo) {
        if (isPlacaDisponivel(veiculo.getPlaca())) {
            listaDeVeiculos.remove(veiculo);
        }
    }
    public <T extends Veiculo> void atualizarVeiculo(T veiculo) {
        if (!isPlacaDisponivel(veiculo.getPlaca())) {
            throw new IllegalArgumentException("Veículo não disponível!");
        }
        deletarVeiculo(veiculo);
        cadastrarVeiculo(veiculo);
    }
    public Veiculo consultarPlaca(String placa) {
        for (Veiculo veiculo: listaDeVeiculos) {
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
        System.out.println("Lista de Veículos: \n");
        for (Veiculo veiculo : listaDeVeiculos) {
            System.out.println(
                    "Tipo: "+veiculo.getClass()+
                            "\nCategoria: "+veiculo.getCategoria()+
                            "\nModelo: "+veiculo.getModelo()+
                    "\nMarca: "+veiculo.getMarca()+
                    "\nAno: "+veiculo.getAno()+
                    "\nPlaca: "+veiculo.getPlaca()+
                    "\nKms Rodados: "+veiculo.getQuilometragem());
                    System.out.println("--------------------");
        }
    }

    //CLIENTES
    @Override
    public <T extends Cliente> void cadastrarCliente(T cliente) {
        listaDeClientes.add(cliente);
    }

   // public <T extends ClientePJ> void cadastrarCliente(T clientePJ) {
//        listaDeClientes.add(clientePJ);
//    }

    @Override
    public void exibirListaDeClientes() {
        System.out.println("Lista de Clientes: \n");
        for (Cliente cliente : listaDeClientes) {
            System.out.println(
                    "Tipo: "+cliente.getClass()+
                            "\nID: "+cliente.getIdCliente());
            System.out.println("--------------------");
        }
    }

    public Cliente consultarCliente(String idCliente) {
        for (Cliente cliente: listaDeClientes) {
            if (cliente.getIdCliente().equals(cliente)) {
                return cliente;
            }
        }
        return null;
    }


}
