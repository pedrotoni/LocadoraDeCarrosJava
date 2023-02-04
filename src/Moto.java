public class Moto extends Veiculo{
    private Integer idMoto;

    public Moto(String modelo, String marca, Integer ano, String placa, Double quilometragem, Integer idMoto) {
        super(modelo, marca, ano, placa, quilometragem);
        this.idMoto = idMoto;
    }

    public Integer getIdMoto() {
        return this.idMoto;
    }
}
