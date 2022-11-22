public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;

    private int numeroBilletesVendidos;

    private boolean billetePremiado;

    private int maximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premio, int maximo) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetePremiado = premio;
        maximoBilletes = maximo;
        numeroBilletesVendidos = 0;
    }

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(boolean premio, int maximo ){
        precioBillete = 20 ;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "León";
        estacionDestino = "Barcelona";
        billetePremiado = premio;
        maximoBilletes = maximo;
        numeroBilletesVendidos = 0;
    }

    /**
     * Devuelve el precio del billete
     */

    public int vaciarDineroDeLaMaquina() {
        int sumaRetirada = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0){
            totalDineroAcumulado = 0;
        }
        else{
            sumaRetirada = -1;
            System.out.println("Hay una operacion en curso, actualmente no se puede retirar el dinero");
        }
        return sumaRetirada;
    }       

    /**
     * Devuelve el numero de billetes vendidos
     */
    public int getNumeroBilletesVendidos() {
        return numeroBilletesVendidos;
    }

    /**
     * Devuelve el numero de billetes vendidos
     */
    public void imprimirNumeroBilletesVendidos() {
        System.out.println("Se han vendido "+ numeroBilletesVendidos +" billetes.");
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos < maximoBilletes){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }      
        }
        else{
            System.out.println(cantidadIntroducida + " La cantidad introducida no es válida");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        numeroBilletesVendidos +=1;
        if (numeroBilletesVendidos < maximoBilletes){
            if  (cantidadDeDineroQueFalta <= 0) {     
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println(); 
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // El cliente un descuento del 25%
            }
            if (numeroBilletesVendidos % 4 == 0)
                if (billetePremiado == true){
                    double descuento = precioBillete * 0.25;
                    System.out.println("¡El billete ha obtenido un premio de "+ descuento + "€ de descuento!");
                }
                else {
                    System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                }
        }
        else{    
            System.out.println("No quedan mas billetes");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
