/**
 * Empleado temporal con contrato por tiempo definido
 * No aplican bonos ni beneficios adicionales
 */
public class EmpleadoTemporal extends Empleado {
    private int mesesContrato;
    
    public EmpleadoTemporal(String nombre, String id, double salarioBase, int mesesContrato) {
        super(nombre, id, salarioBase);
        this.mesesContrato = mesesContrato;
    }
    
    @Override
    public double calcularSalarioBruto() {
        // Solo salario base, sin bonos adicionales
        return salarioBase;
    }
}