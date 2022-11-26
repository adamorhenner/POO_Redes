import java.util.ArrayList;
import java.util.List;

public class Roteador extends Switch {

    private String ip;

    private List<RegistroRotas> tabelaRota = new ArrayList<>();

    private RegistroRotas rotaAtual;

    public Roteador(ArrayList<PortaSwitch> portas, String nome, String ip) {
        super(portas, nome);
        this.ip = ip;
    }

    @Override
    public void receberPacote(Pacote pacote) {
        System.out.println("Roteador recebendo pacote!");
        rotaAtual = VerificadorIp.verificarListaRedes(pacote.getIpDestino(), this.tabelaRota);
        if (rotaAtual != null) {
            enviarPacote(pacote);
        } else {
            System.out.println("Não foi encontrado a ROTA para destino");
        }
    }

    @Override
    public void enviarPacote(Pacote pacote) {
        System.out.println("Roteador enviando pacote");
//        pacote.setIpOrigem(this.ip);
        rotaAtual.getInterfaceDaRota().receberPacote(pacote);
    }

    public List<RegistroRotas> getTabelaRota() {
        return tabelaRota;
    }
}

