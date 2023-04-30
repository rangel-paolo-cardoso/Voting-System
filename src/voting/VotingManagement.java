package voting;

import java.util.ArrayList;
import java.util.List;

import entities.CandidatePerson;
import entities.VoterPerson;

public class VotingManagement {
    private List<CandidatePerson> candidatePeople = new ArrayList<>();
    private List<VoterPerson> voterPeople = new ArrayList<>();
    private List<String> computedCpf = new ArrayList<>();
    private int totalVotes;

    public void registerCandidatePerson(String personName, int personNumber) {
        boolean found = candidatePeople.stream()
                .anyMatch(p -> p.getNumber() == personNumber);

        if (found) {
            System.out.println("Candidate person number already used!");
        } else {
            candidatePeople.add(new CandidatePerson(personName, personNumber));
        }
    }

    public void registerVoterPerson(String personName, String cpf) {
        boolean found = voterPeople.stream()
                .anyMatch(p -> p.getCpf().equals(cpf));

        if (found) {
            System.out.println("Voter person already registered!");
        } else {
            voterPeople.add(new VoterPerson(personName, cpf));
        }
    }

    public void vote(String cpf, int personNumber) {
        boolean found = computedCpf.stream()
                .anyMatch(c -> c.equals(cpf));

        if (found) {
            System.out.println("Voter person already voted!");
        } else {
            candidatePeople.stream()
                    .filter(p -> p.getNumber() == personNumber)
                    .findFirst()
                    .get()
                    .receiveVote();

            totalVotes += 1;
            computedCpf.add(cpf);
        }
    }

    public void showResult() {
        if (totalVotes == 0) {
          System.out.println("You must have at least one vote to show the result.");
        } else {
          for (int index = 0; index < candidatePeople.size(); index += 1) {
            System.out.println(
                "Name: " + candidatePeople.get(index).getName()
                    + " - " + candidatePeople.get(index).getVotes() + " votes ( "
                    + calculateVotePercentage(index) + "% )");
          }
          System.out.println("Total votes: " + totalVotes);
        }
      }
    
      private double calculateVotePercentage(int index) {
        return Math.round(candidatePeople.get(index).getVotes() * 100 / (double) totalVotes);
      }
}
