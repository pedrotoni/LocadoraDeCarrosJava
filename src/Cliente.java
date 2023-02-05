import java.time.LocalDateTime;

public abstract class Cliente {
    private String idCliente;

    private LocalDateTime dataDaLocacao;

    private LocalDateTime dataDaDevolucao;

    public Cliente(String idCliente, LocalDateTime dataDaLocacao, LocalDateTime dataDaDevolucao) {
        this.idCliente = idCliente;
        this.dataDaLocacao = dataDaLocacao;
        this.dataDaDevolucao = dataDaDevolucao;
    }

    public String getIdCliente() {
        return this.idCliente;
    }

    public LocalDateTime getDataDaLocacao() {
        return dataDaLocacao;
    }

    public LocalDateTime getDataDaDevolucao() {
        return dataDaDevolucao;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                '}';
    }
}
