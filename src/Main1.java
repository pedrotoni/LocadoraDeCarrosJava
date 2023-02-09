public class Main1 {
    public static void main(String[] args) {
        DadosVeiculo banco = new DadosVeiculo();

        Carro fox = new Carro(TipoVeiculo.Tipo.PEQUENO,"Fox","Volkswagen","2005",
                "AKE-3010",30503.33,"1");
        Carro fox2 = new Carro(TipoVeiculo.Tipo.PEQUENO,"Fox","Volkswagen","2008",
                "KYO-5004",6456.43,"66");

        Carro hillux = new Carro(TipoVeiculo.Tipo.SUV,"Hillux","Toyota","2023",
                "KYO-5577",856.43,"69");
        Moto cg = new Moto(TipoVeiculo.Tipo.PEQUENO,"CG","Honda","2010",
                "BIE-3445",2000.00,"3");
        Caminhao scania = new Caminhao(TipoVeiculo.Tipo.MEDIO,"Truck","Scania",
                "1999","KEO-3100",300054.22,"8");

        banco.cadastrar(fox);
        banco.cadastrar(fox2);
        banco.cadastrar(cg);
        banco.cadastrar(scania);
        banco.cadastrar(hillux);
        banco.listarTodos();
        banco.buscar(banco.listaDeVeiculos,"Fox");
        banco.buscar(banco.listaDeVeiculos, "CG");

    }
}
