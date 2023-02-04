public class Dados implements Cadastrador{

    @Override
    public void addCarro(Carro carro) {
        listaDeCarros.add(carro);
    }

    @Override
    public void exibirListaDeCarros() {
        System.out.println("Lista de Carros: \n");
        for (Carro carro : listaDeCarros) {
            System.out.println("Modelo: "+carro.getModelo()+
                    "\nMarca: "+carro.getMarca()+
                    "\nAno: "+carro.getAno()+
                    "\nPlaca: "+carro.getPlaca()+
                    "\nKms Rodados: "+carro.getQuilometragem());
                    System.out.println("--------------------");
        }
    }

    @Override
    public void addClientePF(ClientePF clientePF) {
        listaDeClientesPF.add(clientePF);
    }

    @Override
    public void exibirListaDeClientesPF() {
        System.out.println("Lista de Clientes (Pessoa Física): \n");
        for (ClientePF clientePF : listaDeClientesPF) {
            System.out.println("ID Cliente: "+clientePF.getIdCliente()+
                    "\nNome: "+clientePF.getNomeCliente()+
                    "\nCPF: "+clientePF.getCpfCliente());
                    System.out.println("--------------------");
        }

    }

    @Override
    public void addClientePJ(ClientePJ clientePJ) {
        listaDeClientesPJ.add(clientePJ);
    }

    @Override
    public void exibirListaDeClientesPJ() {
        System.out.println("Lista de Clientes (Pessoa Jurídica): \n");
        for (ClientePJ clientePJ : listaDeClientesPJ) {
            System.out.println("ID Cliente: "+clientePJ.getIdCliente()+
                    "\nRazão Social: "+clientePJ.getRazaoSocialCliente()+
                    "\nCNPJ: "+clientePJ.getCnpjCliente());
                    System.out.println("--------------------");
        }
    }
}
