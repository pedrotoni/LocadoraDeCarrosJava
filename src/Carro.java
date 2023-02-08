public class Carro extends Veiculo {
    private String idCarro;

    public Carro(TipoVeiculo.Tipo tipo, String modelo, String marca, String ano, String placa, Double quilometragem, String idCarro) {
        super(modelo, marca, ano, placa, quilometragem);
        this.setTipo(tipo);
        this.idCarro = idCarro;
    }

    public String getIdCarro() {
        return this.idCarro;
    }

}
