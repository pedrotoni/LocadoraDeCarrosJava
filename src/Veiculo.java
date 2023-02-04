public abstract class Veiculo {
    private String modelo;
    private String marca;
    private Integer ano;
    private String placa;
    private Double quilometragem;

    public Veiculo(String modelo, String marca, Integer ano, String placa, Double quilometragem) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.placa = placa;
        this.quilometragem = quilometragem;
    }

    public String getModelo() {
        return this.modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    public Integer getAno() {
        return this.ano;
    }
    public Double getQuilometragem() {
        return this.quilometragem;
    }
    public String getPlaca() {
        return this.placa;
    }
}
