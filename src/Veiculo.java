public class Veiculo {
    private TipoVeiculo.Tipo tipo;
    private String modelo;
    private String marca;
    private String ano;
    private String categoria;
    private String placa;
    private Double quilometragem;

    public Veiculo(String modelo, String marca, String ano, String categoria, String placa, Double quilometragem) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.categoria = categoria;
        this.placa = placa;
        this.quilometragem = quilometragem;
    }

    public String getModelo() {
        return this.modelo;
    }
    public String getMarca() {
        return this.marca;
    }
    public String getAno() {
        return this.ano;
    }
    public Double getQuilometragem() {
        return this.quilometragem;
    }
    public String getPlaca() {
        return this.placa;
    }
    public String getCategoria() {
        return this.categoria;
    }

    public void setTipo(TipoVeiculo.Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "tipo=" + tipo +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", ano='" + ano + '\'' +
                ", categoria='" + categoria + '\'' +
                ", placa='" + placa + '\'' +
                ", quilometragem=" + quilometragem +
                '}';
    }
}


