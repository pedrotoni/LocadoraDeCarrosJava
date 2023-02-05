import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ClientePJ extends Cliente{
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

}
