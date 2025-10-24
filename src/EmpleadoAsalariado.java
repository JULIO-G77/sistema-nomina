/**
 * Empleado con salario fijo mensual
 * Beneficio: Bono del 10% si tiene más de 5 años
 */
public class EmpleadoAsalariado extends Empleado {
    private int anosEnEmpresa;
    private static final double BONO_ANTIGUEDAD = 0.10;
    
    public EmpleadoAsalariado(String nombre, String id, double salarioBase, int anosEnEmpresa) {
        super(nombre, id, salarioBase);
        this.anosEnEmpresa = anosEnEmpresa;
    }
    
    @Override
    public double calcularSalarioBruto() {
        double salario = salarioBase;
        
        // Bono por antigüedad
        if (anosEnEmpresa > 5) {
            salario += salarioBase * BONO_ANTIGUEDAD;
        }
        
        // Beneficio adicional para permanentes
        salario += 1000000; // Bono alimentación
        
        return salario;
    }
    
    public int getAnosEnEmpresa() { return anosEnEmpresa; }
}