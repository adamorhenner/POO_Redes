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
        if(rotaAtual != null){
            enviarPacote(pacote);
        }else{
            System.out.println("Não foi encontrado a ROTA para destino");
        }
    }
    @Override
    public void enviarPacote(Pacote pacote){
        System.out.println("Roteador enviando pacote");
//        pacote.setIpOrigem(this.ip);
        rotaAtual.getInterfaceDaRota().receberPacote(pacote);
    }

    public RegistroRotas getRotaAtual() {
        return rotaAtual;
    }

    public void setRotaAtual(RegistroRotas rotaAtual) {
        this.rotaAtual = rotaAtual;
    }

    public List<RegistroRotas> getTabelaRota() {
        return tabelaRota;
    }

    public void setTabelaRota(List<RegistroRotas> tabelaRota) {
        this.tabelaRota = tabelaRota;
    }

//    @Override
//    public boolean verificarPacote(Pacote pacote, Host host) {
////        boolean resultado = false;
////        RegistroRotas rotas =  VerificadorIp.verificarListaRedes(pacote.getIpDestino(), this.tabelaRota);
////        if(rotas != null) {
////            resultado = true;
////        }
//        boolean souEu = false;
//
//        for (RegistroRotas rota : this.getTabelaRota()){
//
//            if(rota.getInterfaceDaRota() == host){
//                souEu = true;
//                break;
//            }
//        }
//        return souEu;
//    }

//    @Override
//    public void broadcast(Pacote pacote) {
//
//        System.out.println("Realizando Broadcast...");
//
//        for(PortaSwitch porta: this.portas){
//
//            if(!porta.getHost().verificarEnderecoMAC(pacote.getEnderecoMACOrigem(), this)){
//
//                Host host = porta.getHost();
//                host.receberPacote(pacote);
//
//            }
//        }
//    }
}
