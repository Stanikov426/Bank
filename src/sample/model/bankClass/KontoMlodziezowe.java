package sample.model.bankClass;

public class KontoMlodziezowe extends Konto {
    private final int minAge = 16;
    private final int maxAge = 24;

    public KontoMlodziezowe(int numerKonta, String haslo, double srodki){
        super(numerKonta, haslo, srodki);
    }
}
