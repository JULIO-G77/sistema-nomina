/**
 * Clase abstracta que representa un empleado base
 * Principio SOLID: Open/Closed - abierta para extensión, cerrada para modificación
 */
public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected double salarioBase;
    
    public Empleado(String nombre, String id, double salarioBase) {
        if (salarioBase < 0) throw new IllegalArgumentException("El salario no puede ser negativo");
        this.nombre = nombre;
        this.id = id;
        this.salarioBase = salarioBase;
    }
    
    // Método abstracto - cada hijo implementa su forma de calcular
    public abstract double calcularSalarioBruto();
    
    // Método concreto - reutilizable (principio DRY)
    public double calcularDeducciones() {
        double salarioBruto = calcularSalarioBruto();
        return salarioBruto * 0.04; // 4% seguro social y pensión
    }
    
    public double calcularSalarioNeto() {
        double salarioBruto = calcularSalarioBruto();
        double deducciones = calcularDeducciones();
        double salarioNeto = salarioBruto - deducciones;
        
        if (salarioNeto < 0) {
            throw new IllegalStateException("El salario neto no puede ser negativo");
        }
        return salarioNeto;
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public double getSalarioBase() { return salarioBase; }
}