import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;

public abstract class Cliente implements Locador, Devolvedor {
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

    @Override
    public void devolver() {

    }


    public Duration getTempoDecorrido() {
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return Duration.between(getDataDaLocacao(),getDataDaDevolucao());
    }

//    public void getTempoDecorrido(Date date1, Date date2) {
//        String pattern = "MM-dd-yyyy";
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//
//        try {
//             date1 = sdf.parse(String.valueOf(dataDaDevolucao));
//             date2 = sdf.parse(String.valueOf(dataDaLocacao));
//
//            // obtém a diferença entre duas datas em minutos
//            long elapsedms = date1.getTime() - date2.getTime();
//            long diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
//            System.out.println(diff);
//
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }



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
