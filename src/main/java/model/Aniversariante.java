package model;

import java.util.Date;

public class Aniversariante {
    private String nome;
    private Date dataAniversario;
    private String email;

    public Aniversariante(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAniversario() {
        return dataAniversario;
    }

    public void setDataAniversario(Date dataAniversario) {
        this.dataAniversario = dataAniversario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aniversariante{" +
                "nome='" + nome + '\'' +
                ", dataAniversario=" + dataAniversario +
                ", email='" + email + '\'' +
                '}';
    }
}
