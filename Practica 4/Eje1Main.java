import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empleado[] empleados = new Empleado[5];
        // 3 empleados a tiempo completo
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese nombre del empleado tiempo completo " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese salario anual: ");
            double salarioAnual = sc.nextDouble();
            sc.nextLine(); // limpiar buffer
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
        }
        // 2 empleados por horas
        for (int i = 3; i < 5; i++) {
            System.out.println("Ingrese nombre del empleado por horas " + (i - 2) + ": ");
            String nombre = sc.nextLine();
            System.out.println("Ingrese horas trabajadas: ");
            double horas = sc.nextDouble();
            System.out.println("Ingrese tarifa por hora: ");
            double tarifa = sc.nextDouble();
            sc.nextLine(); // limpiar buffer
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }
        System.out.println("\n--- Lista de Empleados ---");
        for (Empleado e : empleados) {
            System.out.println(e.getClass().getSimpleName() + " -> " + e.toString());
        }
    }
}