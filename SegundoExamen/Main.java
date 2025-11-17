public class Main {
    public static void main(String[] args) {
        MiTeleferico mt = new MiTeleferico();

        Persona p1 = new Persona("Ana", 20, 60f);  
        Persona p2 = new Persona("Luis", 30, 75f);  
        Persona p3 = new Persona("Carmen", 65, 68f); 
        Persona p4 = new Persona("Pedro", 50, 90f); 
        Persona p5 = new Persona("María", 22, 55f); 

        mt.agregarPersonaFila(p1, "Amarillo");
        mt.agregarPersonaFila(p2, "Amarillo");
        mt.agregarPersonaFila(p3, "Rojo");
        mt.agregarPersonaFila(p4, "Verde");
        mt.agregarPersonaFila(p5, "Amarillo");

        // probar agregar cabina (llama al método sin parámetros)
        mt.agregarCabina("Amarillo"); 

        Persona p6 = new Persona("Javier", 28, 80f);
        boolean ok = mt.agregarPrimeraPersonaACabina(6, p6); // intenta ubicar en cabina nro 6 si existe
        System.out.println("Agregado a cabina nro6?: " + ok);

        // verificar reglas
        System.out.println("Reglas cumplen todas las cabinas? " + mt.verificarReglasTodasLineas());

        // ingreso total
        System.out.println("Ingreso total: " + mt.calcularIngresoTotalTodasLineas());

        // linea con mas ingreso regular
        Linea mejor = mt.lineaConMasIngresoRegular();
        if (mejor != null) System.out.println("Linea con mas ingreso regular: " + mejor.getColor());

        mt.mostrarResumen();
    }
}