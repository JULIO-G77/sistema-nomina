/**
 * Clase principal para demostrar el funcionamiento del sistema
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 SISTEMA DE NÓMINA - ACTIVIDAD UNIDAD 3");
        System.out.println("===========================================\n");
        
        // Crear servicio de nómina
        NominaService nominaService = new NominaService();
        
        System.out.println("📝 CREANDO EMPLEADOS...");
        
        // 1. Empleado Asalariado (con bono por antigüedad)
        EmpleadoAsalariado asalariado = new EmpleadoAsalariado("Juan Pérez", "A001", 3000000, 6);
        
        // 2. Empleado por Horas (con horas extras)
        EmpleadoPorHoras porHoras = new EmpleadoPorHoras("María García", "H001", 25000, 45, 15);
        porHoras.setAccesoFondoAhorro(true);
        
        // 3. Empleado por Comisión (con bono por ventas)
        EmpleadoPorComision porComision = new EmpleadoPorComision("Carlos López", "C001", 1500000, 0.08, 22000000);
        
        // 4. Empleado Temporal (sin bonos)
        EmpleadoTemporal temporal = new EmpleadoTemporal("Ana Martínez", "T001", 1800000, 6);
        
        // Agregar empleados al servicio
        nominaService.agregarEmpleado(asalariado);
        nominaService.agregarEmpleado(porHoras);
        nominaService.agregarEmpleado(porComision);
        nominaService.agregarEmpleado(temporal);
        
        // Generar reporte
        nominaService.generarReporteNomina();
        
        System.out.println("\n✅ SISTEMA IMPLEMENTADO EXITOSAMENTE");
        System.out.println("   - Principios SOLID aplicados");
        System.out.println("   - 4 tipos de empleados funcionando");
        System.out.println("   - Cálculo automático de deducciones del 4%");
        System.out.println("   - Validaciones de negocio implementadas");
    }
}