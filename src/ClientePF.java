import java.time.LocalDateTime;

public class ClientePF extends Cliente {
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

}
