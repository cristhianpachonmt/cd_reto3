package Domingo_Reto3.Reto3.model;

//@author Nigth Crawler

public class ContadorClientes {
    private Long total;
    private Cliente cliente;

    public ContadorClientes(Long total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}