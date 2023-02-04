public class Carro extends Veiculo {
    private Integer idCarro;

    public Carro(String modelo, String marca, Integer ano, String placa, Double quilometragem, Integer idCarro) {
        super(modelo, marca, ano, placa, quilometragem);
        this.idCarro = idCarro;
    }

    public Integer getIdCarro() {
        return this.idCarro;
    }
}
