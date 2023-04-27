package convertidores;

public class ConversorTemperaturas {

    public double tipoConversion(int indice, double temperatura_actual) {

        double temp_conv = 0;

        switch (indice) {
            case 0:
                temp_conv = grados_a_fahrenheit(temperatura_actual);
                break;
            case 1:
                temp_conv = fahrenheit_a_grados(temperatura_actual);
                break;
            case 2:
                temp_conv = grados_a_kelvin(temperatura_actual);
                break;
            case 3:
                temp_conv = kelvin_a_grados(temperatura_actual);
                break;
            case 4:
                temp_conv = fahrenheit_a_kelvin(temperatura_actual);
                break;
            case 5:
                temp_conv = kelvin_a_fahrenheit(temperatura_actual);
                break;
            case 6:
                temp_conv = grados_a_rankine(temperatura_actual);
                break;
            case 7:
                temp_conv = rankine_a_grados(temperatura_actual);
                break;
            case 8:
                temp_conv = fahrenheit_a_rankine(temperatura_actual);
                break;
            case 9:
                temp_conv = rankine_a_fahrenheit(temperatura_actual);
                break;
            case 10:
                temp_conv = rankine_a_kelvin(temperatura_actual);
                break;
            case 11:
                temp_conv = kelvin_a_rankine(temperatura_actual);
                break;

        }
        
        return temp_conv;

    }

    private double grados_a_fahrenheit(double celsius) {
        
        return (celsius * 1.8) + 32;
    }

    private double fahrenheit_a_grados(double fahrenheit) {
        return (fahrenheit - 32)/1.8;
    }

    private double grados_a_kelvin(double celsius) {
        return celsius + 273.15;
    }

    private double kelvin_a_grados(double kelvin) {
        return kelvin - 273.15;
    }

    private double fahrenheit_a_kelvin(double fahrenheit) {
        return (fahrenheit - 32) / 1.8 + 273.15;
    }

    private double kelvin_a_fahrenheit(double kelvin) {
        return (kelvin - 273.15) * 1.8 + 32;
    }

    private double grados_a_rankine(double grados) {
        return  (grados + 273.15) * 1.8 ;
    }

    private double rankine_a_grados(double rankine) {
        return  (rankine - 491.67) / 1.8 - 273.15;
    }

    private double fahrenheit_a_rankine(double fahrenheit) {
        return  fahrenheit + 459.67;
    }

    private double rankine_a_fahrenheit(double rankine) {
        return  rankine - 459.67;
    }

    private double rankine_a_kelvin(double rankine) {
        return  (rankine / 1.8);
    }

    private double kelvin_a_rankine(double kelvin) {
        return kelvin * 1.8;
    }

}
