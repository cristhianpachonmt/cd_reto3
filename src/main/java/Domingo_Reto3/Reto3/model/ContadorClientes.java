package Domingo_Reto3.Reto3.model;

//@author Nigth Crawler

public class ContadorClientes {
    private Long total;
    private Cliente client;

    public ContadorClientes(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return client;
    }

    public void setCliente(Cliente client) {
        this.client = client;
    }
    
}
