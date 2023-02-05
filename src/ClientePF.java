import java.time.LocalDateTime;

public class ClientePF extends Cliente implements Locador, Devolvedor {
    private String nomeCliente;
    private String cpfCliente;

    public ClientePF(String idCliente, LocalDateTime dataDaLocacao, LocalDateTime dataDaDevolucao, String nomeCliente, String cpfCliente) {
        super(idCliente, dataDaLocacao, dataDaDevolucao);
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }
    public String getCpfCliente() {
        return this.cpfCliente;
    }

    @Override
    public void devolver() {

    }

    @Override
    public void alugar(TipoVeiculo.Tipo tipo) {
        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
            
        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {
            
        } else if (tipo == TipoVeiculo.Tipo.SUV) {
            
        }
    }
}
