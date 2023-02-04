public class ClientePF extends Cliente {
    private String nomeCliente;
    private String cpfCliente;

    public ClientePF(Integer idCliente, String nomeCliente, String cpfCliente) {
        super(idCliente);
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
