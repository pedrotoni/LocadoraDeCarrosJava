import java.time.LocalDateTime;

public abstract class Cliente extends Locadora {
    private String idCliente;

    private LocalDateTime dataLocacao;

    private LocalDateTime dataDevolucao;

    public Cliente(String idCliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao) {
        this.idCliente = idCliente;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    //public abstract void alugar(TipoVeiculo.Tipo tipo, String idCliente);

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

    public LocalDateTime getDataLocacao() {
        return dataLocacao;
    }

    @Override
    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    @Override
    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    @Override
    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                '}';
    }


}
