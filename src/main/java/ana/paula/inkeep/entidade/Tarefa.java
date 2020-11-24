package ana.paula.inkeep.entidade;

import java.util.Objects;

public class Tarefa {
    
    private Integer id;
    private String titulo;
    private boolean concluido;

    public Tarefa(boolean concluido) {
        this.concluido = concluido;
    }

    public Tarefa(Integer id, String titulo, boolean concluido) {
        this.id = id;
        this.titulo = titulo;
        this.concluido = concluido;
    }

    public Tarefa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String modelo) {
        this.titulo = modelo;
    }

    public boolean getConcluido() {
        return concluido;
    }
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarefa other = (Tarefa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
