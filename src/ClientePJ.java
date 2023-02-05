import java.time.LocalDateTime;

public class ClientePJ extends Cliente implements Locador, Devolvedor{
    private String razaoSocialCliente;
    private String cnpjCliente;

    public ClientePJ(String idCliente, LocalDateTime dataDaLocacao, LocalDateTime dataDaDevolucao, String razaoSocialCliente, String cnpjCliente) {
        super(idCliente, dataDaLocacao, dataDaDevolucao);
        this.razaoSocialCliente = razaoSocialCliente;
        this.cnpjCliente = cnpjCliente;
    }

    public String getRazaoSocialCliente() {
        return this.razaoSocialCliente;
    }
    public String getCnpjCliente() {
        return this.cnpjCliente;
    }


    @Override
    public void devolver() {

    }

    @Override
    public void alugar(TipoVeiculo.Tipo tipo) {

    }
}
