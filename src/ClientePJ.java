public class ClientePJ extends Cliente {
    private String razaoSocialCliente;
    private String cnpjCliente;

    public ClientePJ(Integer idCliente, String razaoSocialCliente, String cnpjCliente) {
        super(idCliente);
        this.razaoSocialCliente = razaoSocialCliente;
        this.cnpjCliente = cnpjCliente;
    }

    public String getRazaoSocialCliente() {
        return this.razaoSocialCliente;
    }
    public String getCnpjCliente() {
        return this.cnpjCliente;
    }
}
