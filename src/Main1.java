import java.time.LocalDateTime;

public class Main1 {
    public static void main(String[] args) {

                /*
        Criar uma aplicação que gerencie o aluguel de veículos, onde cada item abaixo seja considerado:

    Itens obrigatórios
    Cadastrar os veículos; ok
    Alterar um veículo cadastrado; ok
    Buscar um veículo por parte do nome; ok
    Cadastrar o cliente (pessoa física e jurídica) ok
    Alterar o cliente (pessoa física e jurídica) ok
    Alugar um veículo para pessoa física e jurídica; ok
    Devolver um veículo para pessoa física e jurídica;
    Regras de negócio
    RN1: Os veículos não podem ser repetidos; Pode utilizar a placa como identificador de unicidade; ok
    RN2: Tipos de veículos que serão considerados: Carro, Moto, Caminhões; ok
    RN3: Os aluguéis e devoluções terão o local, data e horário; ok
    RN4: Considere aluguel em horas quebradas como uma diária completa. Exemplo: uma devolução de um veículo alugado no dia 25 de janeiro às 15h30 será cobrado uma (1) diária até dia 26 de janeiro às 15h30, a partir desse horário já serão cobradas duas (2) diárias e assim por diante.
    RN5: Os veículos que estiverem alugados não poderão estar disponíveis; ok
    RN6: Clientes não podem estar duplicados; Considerar CPF (Pessoa Física) e CNPJ (Pessoa Jurídica) como identificadores de unicidade;
    RN7: Regras de devolução:
    Caso o cliente pessoa física tenha ficado com o carro mais que 5 diárias terá direito a 5% de desconto. ok
    Caso o cliente pessoa jurídica tenha ficado com o carro mais que 3 diárias terá direito a 10% de desconto. ok
    Valores base da diária por tipo de veículo:

    Tipo de Veículo	Valor por dia ok
    pequeno	R$ 100,00
    medio	R$ 150,00
    SUV	R$ 200,00

    Falta MenuInterativo
    Organizar as pastas
                 */
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
//        ClientePF pedro = new ClientePF ("2",
//                LocalDateTime.of(2023,10,2,8,45),
//                LocalDateTime.of(2023,11,2,8,34)),
//                "Pedro","34655544433");

        ClientePF pedro = new ClientePF("2", LocalDateTime.of(1999,2,8,8,45), LocalDateTime.of(2023,11,2,8,34), "Pedro", "2541184");
//        ClientePF pedro2 = new ClientePF ("26",
//                /*LocalDateTime.of(2023,10,2,8,45),
//                LocalDateTime.of(2023,11,2,8,34),*/
//                "Pedro","346555444335");
//        ClientePJ fabrica = new ClientePJ ("99",
//                /*LocalDateTime.of(2023,10,2,8,45),
//                LocalDateTime.of(2023,11,2,8,34),*/
//                "Fabrica do Caio","549592906246956");
//        ClientePJ fabrica2 = new ClientePJ ("8",
//                /*LocalDateTime.of(2023,10,2,8,45),
//                LocalDateTime.of(2023,11,2,8,34),*/
//                "Loja da Amanda","6536056035356353503");
//        ClientePF carla = new ClientePF ("6",
//                /*LocalDateTime.of(2023,10,2,8,45),
//                LocalDateTime.of(2023,11,2,8,34),*/
//                "Carla","34655544433");

        banco.cadastrar(pedro);
//        banco.cadastrar(pedro2);
//        banco.cadastrar(fabrica);
//        banco.cadastrar(fabrica2);
        banco.listarTodos();
        banco.buscar(banco.listaDeClientes,"Jarbas");
        bancoVeiculo.buscar(bancoVeiculo.listaDeVeiculos,"Fox");
        bancoVeiculo.buscar(bancoVeiculo.listaDeVeiculos,"Mercedes");

        locadora.alugar(pedro,fox,fox.getTipo());
        locadora.devolver(fox,fox.getTipo());

    }
}
