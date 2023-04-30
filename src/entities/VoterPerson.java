package entities;

public class VoterPerson extends Person {
    private String cpf;

    public VoterPerson(String name, String cpf) {
        super(name);
        this.cpf = cpf;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
