import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;

public abstract class Cliente extends Aluguel {
    private String idCliente;

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void alugar(TipoVeiculo.Tipo tipo) {
        super.alugar(tipo);
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public String getNomeCliente() {
        return null;
    }
    public String getCpfCliente() {
        return null;
    };
    public String getRazaoSocialCliente() {
        return null;
    };
    public String getCnpjCliente() {
        return null;
    };

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                '}';
    }


}
