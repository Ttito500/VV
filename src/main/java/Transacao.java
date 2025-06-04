//feito para teste de stubs
public class Transacao {
    public boolean deposita (Conta conta, int value){
        if (value > 0) {
            conta.adcionaSaldo(value);
            return true;
        }
        return false;
    }

    public boolean saca (Conta conta, int value){
        if (conta.leSaldo()>value) {
            conta.removeSaldo(value);
            return true;
        }
        return false;
    }
}
