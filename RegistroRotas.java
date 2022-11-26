public class RegistroRotas {
    private EnderecoRede enderecoRede;
    private Host InterfaceDaRota;

    public RegistroRotas(EnderecoRede enderecoRede, Host interfaceDaRota) {
        this.enderecoRede = enderecoRede;
        InterfaceDaRota = interfaceDaRota;
    }

    public EnderecoRede getEnderecoRede() {
        return enderecoRede;
    }

    public void setEnderecoRede(EnderecoRede enderecoRede) {
        this.enderecoRede = enderecoRede;
    }

    public Host getInterfaceDaRota() {
        return InterfaceDaRota;
    }
}
