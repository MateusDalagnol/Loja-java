package model;

public class Cliente {

    private String nome;
    private String email;
    private int id;
    private static int nextId = 0;
    
    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
        id = nextId++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() + ", Email: " + getEmail() + ", ID: " + getId();
    }
}
