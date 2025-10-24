/**
 * Empleado con salario base + comisión por ventas
 * Bono adicional del 3% si ventas > $20,000,000
 */
public class EmpleadoPorComision extends Empleado {
    private double ventasRealizadas;
    private double porcentajeComision;
    private static final double MONTO_BONO = 20000000;
    private static final double PORCENTAJE_BONO = 0.03;
    
    public EmpleadoPorComision(String nombre, String id, double salarioBase, 
                              double porcentajeComision, double ventasRealizadas) {
        super(nombre, id, salarioBase);
        if (ventasRealizadas < 0) throw new IllegalArgumentException("Ventas no pueden ser negativas");
        
        this.ventasRealizadas = ventasRealizadas;
        this.porcentajeComision = porcentajeComision;
    }
    
    @Override
    public double calcularSalarioBruto() {
        double comision = ventasRealizadas * porcentajeComision;
        double salario = salarioBase + comision;
        
        // Bono por ventas altas
        if (ventasRealizadas > MONTO_BONO) {
            salario += ventasRealizadas * PORCENTAJE_BONO;
        }
        
        // Bono alimentación para permanentes
        salario += 1000000;
        
        return salario;
    }
}