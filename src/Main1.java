public class Main1 {
    public static void main(String[] args) {
        DadosVeiculo bancoVeiculo = new DadosVeiculo();
        Locadora locadora = new Locadora();

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

        bancoVeiculo.cadastrar(fox);
        bancoVeiculo.cadastrar(fox2);
        bancoVeiculo.cadastrar(cg);
        bancoVeiculo.cadastrar(scania);
        bancoVeiculo.cadastrar(hillux);
        bancoVeiculo.listarTodos();
        bancoVeiculo.buscar(bancoVeiculo.listaDeVeiculos,"Fox");
        bancoVeiculo.buscar(bancoVeiculo.listaDeVeiculos, "CG");

        DadosCliente banco = new DadosCliente();
//                "1999","KEO-3100",300054.22,"8");
        ClientePF pedro = new ClientePF ("2",
                /* LocalDateTime.of(2023,10,2,8,45),
                LocalDateTime.of(2023,11,2,8,34),*/
                "Pedro","34655544433");
        ClientePF pedro2 = new ClientePF ("26",
                /*LocalDateTime.of(2023,10,2,8,45),
                LocalDateTime.of(2023,11,2,8,34),*/
                "Pedro","346555444335");
        ClientePJ fabrica = new ClientePJ ("99",
                /*LocalDateTime.of(2023,10,2,8,45),
                LocalDateTime.of(2023,11,2,8,34),*/
                "Fabrica do Caio","549592906246956");
        ClientePJ fabrica2 = new ClientePJ ("8",
                /*LocalDateTime.of(2023,10,2,8,45),
                LocalDateTime.of(2023,11,2,8,34),*/
                "Loja da Amanda","6536056035356353503");
        ClientePF carla = new ClientePF ("6",
                /*LocalDateTime.of(2023,10,2,8,45),
                LocalDateTime.of(2023,11,2,8,34),*/
                "Carla","34655544433");

        banco.cadastrar(pedro);
        banco.cadastrar(pedro2);
        banco.cadastrar(fabrica);
        banco.cadastrar(fabrica2);
        banco.listarTodos();
        banco.buscar(banco.listaDeClientes,"Loja da Amanda");

        locadora.alugar(pedro2, fox, fox.getTipo());
        locadora.listarVeiculosAlugados();
        locadora.devolver(fox, fox.getTipo());

    }
}
