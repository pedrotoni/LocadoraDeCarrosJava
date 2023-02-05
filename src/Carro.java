public class Carro extends Veiculo {
    private String idCarro;

    public Carro(TipoVeiculo.Tipo tipo, String modelo, String marca, String ano, String categoria, String placa, Double quilometragem, String idCarro) {
        super(modelo, marca, ano, categoria, placa, quilometragem);
        this.setTipo(tipo);
        this.idCarro = idCarro;
    }

    public String getIdCarro() {
        return this.idCarro;
    }

}
