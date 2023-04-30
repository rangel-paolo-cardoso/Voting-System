import java.util.Scanner;

import voting.VotingManagement;

public class Main {

    protected static byte option;
    protected static String personName;
    protected static int personNumber;
    protected static String cpf;
    protected static Scanner sc = new Scanner(System.in);
    protected static VotingManagement votingManagement = new VotingManagement();

    /**
     * Main Method.
     * @param args is used to pass information into the program.
     */
    public static void main(String[] args) {
        registerCandidatePeople();
        registerVoterPeople();
        startVoting();
        sc.close();
        votingManagement.showResult();
    }

    static void registerCandidatePeople() {
        do {
            printMenuForCandidatePerson();
            option = sc.nextByte();
            if (option == 1) {
                print("Enter the name of the candidate person:");
                personName = sc.next();
                print("Enter the number of the candidate person:");
                personNumber = sc.nextInt();
                votingManagement.registerCandidatePerson(personName, personNumber);
            } else if (option == 2) {
                break;
            } else {
                printInvalidOption();
            }
        } while (true);
    }

    static void registerVoterPeople() {
        do {
            printMenuPessoaEleitora();
            option = sc.nextByte();
            if (option == 1) {
                print("Enter the name of the eligible voter:");
                personName = sc.next();
                print("Enter the CPF of the eligible voter:");
                cpf = sc.next();
                votingManagement.registerVoterPerson(personName, cpf);
            } else if (option == 2) {
                break;
            } else {
                printInvalidOption();
            }
        } while (true);
    }

    static void startVoting() {
        do {
            printMenuVotacao();
            option = sc.nextByte();
            if (option == 1) {
                print("Enter the voter's CPF:");
                cpf = sc.next();
                print("Enter the candidate's number:");
                personNumber = sc.nextInt();
                votingManagement.vote(cpf, personNumber);
            } else if (option == 2) {
                votingManagement.showResult();
            } else if (option == 3) {
                break;
            } else {
                printInvalidOption();
            }
        } while (true);
    }

    static void printMenuForCandidatePerson() {
        print("Register candidate person?");
        printBasicMenu();
    }

    static void printMenuPessoaEleitora() {
        print("Register voter?");
        printBasicMenu();
      }
    
      static void printMenuVotacao() {
        printBasicMessage();
        print("1 - Vote");
        print("2 - Partial Result");
        print("3 - Finish Voting");
      }
    
      static void printBasicMenu() {
        print("1 - Yes");
        print("2 - No");
        printBasicMessage();
      }
    
      static void printBasicMessage() {
        print("Enter the corresponding number for the desired option:");
      }
    
      static void print(String message) {
        System.out.println(message);
      }
    
      static void printInvalidOption() {
        System.out.println("Invalid option!");
      }
}
