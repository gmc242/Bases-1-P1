package Model.expresiones;

/**
 * @author gmc_2
 */

public abstract class ExpresionRelacional {
    public String predicado;
    public ExpresionRelacional relacion;
    public String tablaResultante;

    //public abstract void realizarOperacion() throws Exception; // Realiza la operacion del algebra relacional en sql

    // Obtiene el query que se hará en sql asociado a la operacion del algebra relacional.
    // Servirá como auxiliar de realizarOperacion, además daría campo a anidar operaciones
    public abstract String obtenerQuery() throws Exception;

    protected abstract String procesarPredicado() throws Exception; // Genera un string con base en el predicado que sea apto para el query

    //Se encarga de revisar la inyeccion SQL y que el predicado sea valido
    protected abstract void validarPredicado() throws Exception;
}