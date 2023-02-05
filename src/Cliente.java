import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class Cliente implements Locador, Devolvedor{
    private String idCliente;

    private LocalDateTime dataDaLocacao;

    private Locale local;

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

    @Override
    public void devolver() {

    }

    public Duration getTempoDecorrido() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return Duration.between(getDataDaLocacao(),getDataDaDevolucao());
    }


    @Override
    public void alugar(TipoVeiculo.Tipo tipo) {
        //int dias = getTempoDecorrido();
        //int horas =
        //int minutos =
        double valorAluguel = 0;

        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
            //valorAluguel = getTempoDecorrido() * 100.00;
        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {

        } else if (tipo == TipoVeiculo.Tipo.SUV) {

        }
    }
}
