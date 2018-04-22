package sample.model.bankClass;

public class KontoOszczednosciowe extends Konto {
    private final double oprocentowanie = 0.03;

    public KontoOszczednosciowe(int numerKonta, String haslo, double srodki){
        super(numerKonta, haslo, srodki);
        setType("Savings");
    }
}
