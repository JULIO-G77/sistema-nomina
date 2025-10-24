/**
 * Empleado que se paga por horas trabajadas
 * Horas extras (más de 40) se pagan a 1.5x
 */
public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;
    private boolean accesoFondoAhorro;
    private int mesesTrabajando;
    
    public EmpleadoPorHoras(String nombre, String id, double tarifaPorHora, 
                           int horasTrabajadas, int mesesTrabajando) {
        super(nombre, id, 0); // Salario base 0 para este tipo
        if (horasTrabajadas < 0) throw new IllegalArgumentException("Horas no pueden ser negativas");
        if (tarifaPorHora < 0) throw new IllegalArgumentException("Tarifa no puede ser negativa");
        
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
        this.mesesTrabajando = mesesTrabajando;
    }
    
    @Override
    public double calcularSalarioBruto() {
        double salario;
        
        if (horasTrabajadas <= 40) {
            salario = horasTrabajadas * tarifaPorHora;
        } else {
            int horasExtras = horasTrabajadas - 40;
            salario = (40 * tarifaPorHora) + (horasExtras * tarifaPorHora * 1.5);
        }
        
        // Fondo de ahorro para empleados con más de 1 año
        if (mesesTrabajando > 12 && accesoFondoAhorro) {
            salario += salario * 0.02; // 2% fondo de ahorro
        }
        
        return salario;
    }
    
    public void setAccesoFondoAhorro(boolean acceso) {
        this.accesoFondoAhorro = acceso;
    }
}