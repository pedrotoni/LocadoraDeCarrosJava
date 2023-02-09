public class ClientePF extends Cliente {
    private String nomeCliente;
    private String cpfCliente;

    public ClientePF(String idCliente, String nomeCliente, String cpfCliente) {
        super(idCliente);
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    @Override
    public void alugar(TipoVeiculo.Tipo tipo, String cpfCliente) {
        double valorAluguel = 0;

        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
            valorAluguel = calcularAluguel() * 100.00;
        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {
            valorAluguel = calcularAluguel() * 150.00;
        } else if (tipo == TipoVeiculo.Tipo.SUV) {
            valorAluguel = calcularAluguel() * 200.00;
        }
        System.out.println("O aluguel desse veículo por " + calcularAluguel() +" dias" + " irá custar: " + valorAluguel + " reais.");
    }

    @Override
    public String getNomeCliente() {
        return this.nomeCliente;
    }

    @Override
    public String getCpfCliente() {
        return this.cpfCliente;
    }


}
