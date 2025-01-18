import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrincipalConversor {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConversorApi consulta = new ConversorApi();
        String origen = "";
        String destino = "";
        double valor;
        int opcion = 1;

        while (opcion != 0) {
            System.out.println("""
                Conversor de Moneda
                    Seleciona una conversion:
                        1- Dólar => Peso argentino
                        2- Peso argentino => Dólar
                        3- Dólar => Real brasileñ0
                        4- Real brasileño => Dólar
                        5- Dólar => Peso chileno
                        6- Peso Chileno => Dólar
                    0- Salir.
                """);
            System.out.print("Ingrese una opcion [1-6] : ");
            opcion = lectura.nextInt();

            switch (opcion){
                case 1:
                    origen = "USD";
                    destino = "ARS";
                    break;
                case 2:
                    origen = "ARS";
                    destino = "USD";
                    break;
                case 3:
                    origen = "USD";
                    destino = "BRL";
                    break;
                case 4:
                    origen = "BRL";
                    destino = "USD";
                    break;
                case 5:
                    origen = "USD";
                    destino = "CLP";
                    break;
                case 6:
                    origen = "CLP";
                    destino = "USD";
                    break;
                case 0:
                    System.out.println("Saliendo del conversor");
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }
            if (opcion >= 1 && opcion <= 8) {
                while (true) {
                    try {
                        System.out.println("Ingrese el valor que desea convertir (debe ser un número mayor a 0):");
                        valor = lectura.nextDouble();

                        if (valor > 0) {
                            DivisasApi operation = consulta.tasaDeCambio(origen, destino, valor);
                            System.out.println("El valor de " + valor + " [" + origen + "] equivale a " +
                                    operation.conversion_result() + " [" + destino + "]");

                            new GenerarJson().archivo(operation, origen, destino);
                            break;
                        } else {
                            System.out.println("Por favor ingrese un número mayor a 0.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor ingrese un número válido.");
                        lectura.next();
                    } catch (IOException e) {
                        throw new RuntimeException("Error al generar el archivo JSON: ", e);
                    }
                }
            }
            }
        }
    }
