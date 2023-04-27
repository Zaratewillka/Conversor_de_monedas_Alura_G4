package convertidores;

public class ConvertidorMonedas {

    public double seleccionadorTipoConversion(int indice, double tipo_dinero) {

        double convertido = 0;
        double monto = tipo_dinero;

        switch (indice) {
            case 0:
                convertido = bolivianoADolar(monto);
                break;

            case 1:
                convertido = bolivianoAEuro(monto);
                break;
            case 2:
                convertido = bolivianoALibra(monto);
                break;
            case 3:
                convertido = bolivianoAYen(monto);
                break;
            case 4:
                convertido = bolivianoAWonCoreano(monto);
                break;
            case 5:
                convertido = dolarABoliviano(monto);
                break;
            case 6:
                convertido = euroABoliviano(monto);
                break;
            case 7:
                convertido = libraABoliviano(monto);
                break;
        }

        return convertido;
    }

    private double bolivianoADolar(double boliviano) {
        System.out.println("bolivianoADolar :" + boliviano + " Resultado: " + boliviano / 6.91);
        return boliviano / 6.91;
    }

    private double bolivianoAEuro(double boliviano) {
        System.out.println("bolivianoAEuro :" + boliviano + " Resultado: " + boliviano / 7.62);
        return boliviano / 7.62;
    }

    private double bolivianoALibra(double boliviano) {
        System.out.println("bolivianoALibra :" + boliviano + " Resultado: " + boliviano / 8.61);
        return boliviano / 8.61;
    }

    private double bolivianoAYen(double boliviano) {
        System.out.println("bolivianoAYen :" + boliviano + " Resultado: " + boliviano / 0.051);
        return boliviano / 0.051;
    }

    private double bolivianoAWonCoreano(double boliviano) {
        System.out.println("bolivianoAWonCoreano :" + boliviano + " Resultado: " + boliviano / 0.0052);
        return boliviano / 0.0052;
    }

    private double dolarABoliviano(double dolar) {
        System.out.println("dolarABoliviano :" + dolar + " Resultado: " + dolar * 6.91);
        return dolar * 6.91;
    }

    private double euroABoliviano(double euro) {
        System.out.println("euroABoliviano :" + euro + " Resultado: " + euro * 7.62);
        return euro * 7.62;
    }

    private double libraABoliviano(double libra) {
        System.out.println("libraABoliviano :" + libra + " Resultado: " + libra * 8.61);
        return libra * 8.61;
    }

}
