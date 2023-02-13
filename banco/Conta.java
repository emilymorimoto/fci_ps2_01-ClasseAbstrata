package banco;

abstract class Conta{
    public abstract double consultarLimite();
    public abstract void alterarLimite(double limite);
}