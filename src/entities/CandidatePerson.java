package entities;

public class CandidatePerson extends Person {
    private int number;
    private int votes;

    public CandidatePerson(String name, int number) {
        super(name);
        this.number = number;
        this.votes = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void receiveVote() {
        this.votes += 1;
      }
}
