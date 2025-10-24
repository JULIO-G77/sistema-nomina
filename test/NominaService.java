import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar cálculos de nómina
 * Principio SOLID: Single Responsibility - solo se encarga de operaciones de nómina
 */
public class NominaService {
    private List<Empleado> empleados;
    
    public NominaService() {
        this.empleados = new ArrayList<>();
    }
    
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("✅ Empleado agregado: " + empleado.getNombre());
    }
    
    public double calcularNominaTotal() {
        double total = 0;
        for (Empleado emp : empleados) {
            total += emp.calcularSalarioNeto();
        }
        return total;
    }
    
    public void generarReporteNomina() {
        System.out.println("\n=== REPORTE DE NÓMINA ===");
        System.out.printf("%-5s %-20s %-15s %-15s %-15s%n", 
                         "ID", "NOMBRE", "BRUTO", "DEDUCCIONES", "NETO");
        System.out.println("-------------------------------------------------------------------");
        
        for (Empleado emp : empleados) {
            double bruto = emp.calcularSalarioBruto();
            double deducciones = emp.calcularDeducciones();
            double neto = emp.calcularSalarioNeto();
            
            System.out.printf("%-5s %-20s $%,-12.0f $%,-12.0f $%,-12.0f%n",
                            emp.getId(), emp.getNombre(), bruto, deducciones, neto);
        }
        
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("TOTAL NÓMINA: $%,.0f%n", calcularNominaTotal());
    }
    
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }
}