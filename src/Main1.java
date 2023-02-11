import java.time.LocalDateTime;
import java.util.Locale;

public class Main1 {
    public static void main(String[] args) {
        //Por Rachel Lizandra e Pedro de Toni

        DadosVeiculo bancoVeiculos = new DadosVeiculo();
        DadosCliente bancoClientes = new DadosCliente();
        Locacao locacao = new Locacao();
        //CHECKLIST:

        //CADASTRANDO VEICULOS
        Moto suzuki = new Moto(TipoVeiculo.Tipo.MEDIO,"Ninja","Suzuki","2003",
                "SUZ-1202",25000.00,"4");
        Caminhao scania = new Caminhao(TipoVeiculo.Tipo.MEDIO,"Truck","Scania","2005",
                "SCA-5030",69999.99,"50");
        Carro palio = new Carro(TipoVeiculo.Tipo.PEQUENO,"Palio","Fiat","1998",
                "PAL-3030",25070.35,"60");
        Carro blazer = new Carro(TipoVeiculo.Tipo.SUV,"Blazer","Chevrolet","1995",
                "BLA-1000",100000.00,"200");
        bancoVeiculos.cadastrar(suzuki);
        bancoVeiculos.cadastrar(scania);
        bancoVeiculos.cadastrar(palio);
        bancoVeiculos.listarTodos();

        //ALTERANDO VEICULO JÁ CADASTRADO
        Carro fiesta = new Carro(TipoVeiculo.Tipo.PEQUENO,"Fiesta","Ford","2006",
        "FIE-3303",50060.20,"22");
        Carro fiesta2 = new Carro(TipoVeiculo.Tipo.PEQUENO,"Fiesta","Ford","2010",
                "GKW-3411",55030.20,"23");

        bancoVeiculos.atualizar(palio,fiesta);
        bancoVeiculos.listarTodos();

        //BUSCAR VEICULO (EXEMPLO COM 2 VEICULOS IGUAIS COM PLACAS DIFERENTES)
        bancoVeiculos.cadastrar(fiesta2);
        bancoVeiculos.buscar(bancoVeiculos.listaDeVeiculos,"Fiesta");

        //BUSCANDO VEICULO QUE NAO EXISTE
        bancoVeiculos.buscar(bancoVeiculos.listaDeVeiculos,"Ferrari");

        //CADASTRAR CLIENTE
        ClientePF pedro = new ClientePF("1","Pedro","403020303-20");
        ClientePF rachel = new ClientePF("2","Rachel","704404030-20");
        ClientePJ fabrica = new ClientePJ("40","Fabrica de Brinquedos",
                "43.000.222/0001-20");
        ClientePJ loja = new ClientePJ("64","Loja da Amanda","30.202.202/0001-20");
        bancoClientes.cadastrar(pedro);
        bancoClientes.cadastrar(rachel);
        bancoClientes.cadastrar(fabrica);
        bancoClientes.cadastrar(loja);
        bancoClientes.listarTodos();

        //BUSCAR CLIENTE PELO NOME
        bancoClientes.buscar(bancoClientes.listaDeClientes,"Rachel");
        bancoClientes.buscar(bancoClientes.listaDeClientes,"Fabrica de Brinquedos");

        //BUSCANDO CLIENTE QUE NAO EXISTE
        bancoClientes.buscar(bancoClientes.listaDeClientes,"Serginho Mallandro");

        //ALTERAR CLIENTE PF
        ClientePF bruna = new ClientePF("68","Bruna","501020000-11");
        bancoClientes.atualizar(pedro,bruna);

        //ALTERAR CLIENTE PJ
        ClientePJ padaria = new ClientePJ("102","Padaria da Joana","40.202.111/0002-22");
        bancoClientes.atualizar(fabrica,padaria);
        bancoClientes.listarTodos();

        //DEVOLVER VEICULO PF
        locacao.alugar(fiesta,rachel,LocalDateTime.of(2023,1,2,12,30), Locale.JAPAN);
        //DADOS DO ALUGUEL: PESSOA FISICA / 10 DIAS / VEICULO PEQUENO -> 100 X 10 - (100 X 10 x 0.05) = 950
        locacao.devolver(fiesta,rachel,LocalDateTime.of(2023,1,12,12,30),Locale.JAPAN);

        //DEVOLVER VEICULO PJ
        locacao.alugar(blazer,padaria,LocalDateTime.of(2023,1,1,15,0),Locale.ITALY);
        //DADOS DO ALUGUEL: PESSOA JURIDICA / 5 DIAS / VEICULO SUV = 200 * 5 - (200 * 5 * 0,1) = 900
        locacao.devolver(blazer,padaria,LocalDateTime.of(2023,1,6,15,0),Locale.ITALY);
        //TENTANDO DEVOLVER VEICULO NÃO ALUGADO
        locacao.devolver(suzuki,rachel,LocalDateTime.of(2023,1,12,12,30),Locale.JAPAN);

        /*RN1: VEICULOS NAO PODEM SER REPETIDOS (PLACA COMO IDENTIFICAÇÃO) - OBS: DESCOMENTE PARA TESTAR
        Moto hondacross = new Moto(TipoVeiculo.Tipo.MEDIO,"Cross","Honda","2003",
                "SUZ-1202",25000.00,"8");
        bancoVeiculos.cadastrar(hondacross);*/

        //RN2: VEICULOS SÃO MOTO CAMINHÃO E CARRO -> OK
        //RN3: ALUGUEL TEM QUE TER DATA HORARIO E LOCAL -> OK

        //RN4: ALUGUEL/DEVOLUCAO TEM QUE CONSIDERAR HORAS QUEBRADAS COMO DIÁRIA COMPLETA

        //UMA DIÁRIA EXATA
        locacao.alugar(suzuki,loja,LocalDateTime.of(2023,1,1,15,0),Locale.ITALY);
        //DADOS DO ALUGUEL: PESSOA JURIDICA / DO DIA 01/01/2023 AS 15H00 ÀS 02/01/2023 AS 15H00 / VEICULO MEDIO = 150 * 1 = 150
        locacao.devolver(suzuki,loja,LocalDateTime.of(2023,1,2,15,0),Locale.ITALY);

        //UM MINUTO ANTES DE COMPLETAR UMA DIÁRIA
        locacao.alugar(suzuki,loja,LocalDateTime.of(2023,1,1,15,0),Locale.ITALY);
        //DADOS DO ALUGUEL: PESSOA JURIDICA / DO DIA 01/01/2023 AS 15H00 ÀS 02/01/2023 AS 14H59 / VEICULO MEDIO = 150 * 1 = 150
        locacao.devolver(suzuki,loja,LocalDateTime.of(2023,1,2,14,59),Locale.ITALY);

        //UM MINUTO DEPOIS DE COMPLETAR UMA DIÁRIA
        locacao.alugar(suzuki,loja,LocalDateTime.of(2023,1,1,15,0),Locale.ITALY);
        //DADOS DO ALUGUEL: PESSOA JURIDICA / DO DIA 01/01/2023 AS 15H00 ÀS 02/01/2023 AS 15H01 / VEICULO MEDIO = 150 * 2 = 300
        locacao.devolver(suzuki,loja,LocalDateTime.of(2023,1,2,15,1),Locale.ITALY);

        //RN5: VEICULO ALUGADO NÃO PODE ESTAR DISPONIVEL
        locacao.alugar(fiesta,rachel,LocalDateTime.of(2023,1,1,15,0),Locale.CANADA);
        locacao.alugar(fiesta,rachel,LocalDateTime.of(2023,1,1,15,0),Locale.CANADA);

        //RN6: CLIENTE PF/PJ NÃO PODE ESTAR DUPLICADO. - OBS: DESCOMENTE PARA TESTAR
        /*
        ClientePF rachel2 = new ClientePF("2","Rachel","704404030-20");
        ClientePJ padaria2 = new ClientePJ("102","Padaria da Joana","40.202.111/0002-22");
        bancoClientes.cadastrar(rachel2);
        bancoClientes.cadastrar(padaria2);*/

        //RN7: REGRAS DE DEVOLUÇÃO -> JÁ DEMONSTRADO DAS LINHAS 71 A 81 DESTA CLASSE MAIN.

        //OUTROS TESTES:
        /*
        //ERRO - DATA DE DEVOLUÇÃO ANTES DA DATA DE LOCAÇÃO - OBS: DESCOMENTE PARA TESTAR.
        locacao.alugar(scania,padaria,LocalDateTime.of(2023,10,10,10,0),Locale.FRANCE);
        locacao.devolver(scania,padaria,LocalDateTime.of(2023,10,10,9,0),Locale.FRANCE);*/

        //REMOÇÃO DE CLIENTES E VEICULOS
        bancoClientes.deletar(rachel);
        bancoClientes.deletar(loja);
        bancoClientes.deletar(bruna);
        bancoClientes.deletar(padaria);
        bancoVeiculos.deletar(fiesta);
        bancoVeiculos.deletar(scania);
        bancoVeiculos.deletar(fiesta2);
        bancoVeiculos.deletar(suzuki);

        //MENSAGEM DE LISTA VAZIA (CLIENTES & VEICULOS)
        bancoClientes.listarTodos();
        bancoVeiculos.listarTodos();
    }
}
