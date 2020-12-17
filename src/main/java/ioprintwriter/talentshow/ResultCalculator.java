package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private static final int ID_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();


    private void processProd(String prodStr) {
        String[] fields = prodStr.split(" ");
        try {
            productions.add(new Production(Integer.parseInt(fields[ID_INDEX]), fields[NAME_INDEX]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Wrong line, not a number, " + prodStr,e);
        }
    }

    public void readTalents(Path talentFile) {
        try (BufferedReader br = Files.newBufferedReader(talentFile)) {
            String prodStr;
            while ((prodStr = br.readLine())!=null) {
                processProd(prodStr);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("IO file hiba",e);
        }
    }

    private void processVote(String voteStr) {
        try {
            int Id = Integer.parseInt(voteStr);
            for (Vote vote : votes) {
                if (vote.getId()==Id) {
                    vote.incNum();
                    return;
                }
            }
            votes.add(new Vote(Id,1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Unapble process vote, not a number, " + voteStr,e);
        }
    }

    public void calculateVotes(Path voteFile){
        try (BufferedReader br = Files.newBufferedReader(voteFile)) {
            String voteStr;
            while ((voteStr = br.readLine())!=null) {
                processVote(voteStr);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("IO file hiba",e);
        }
    }

    private Production getProductionById(int id) {
        for (Production production : productions){
            if (production.getId() == id) {
                return production;
            }
        }
        return null;
    }

    private void writeToFile(List<Vote> tempVotes, PrintWriter pw) {
        int maxVoteNumber;
        int thisVoteNumber;
        String line;
        Vote highestRanked = null;
        while (tempVotes.size()>0) {
            thisVoteNumber=0;
            maxVoteNumber=0;
            for (Vote vote : tempVotes) {
                thisVoteNumber = vote.getNumber();
                if (thisVoteNumber > maxVoteNumber) {
                    maxVoteNumber = thisVoteNumber;
                    highestRanked = vote;
                }
            }
            line = getProductionById(highestRanked.getId()).toString() + " " + Integer.toString(highestRanked.getNumber());
            pw.println(line);
            tempVotes.remove(highestRanked);
        }
    }

    public void writeResultToFile(Path resultFile) {
        try {
            PrintWriter pw = new PrintWriter(Files.newBufferedWriter(resultFile));
            writeToFile(new ArrayList<>(votes),pw);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write file, "+resultFile.toString(),e);
        }
    }

    public List<Production> getProductions() {
        return new ArrayList<>(productions);
    }

    public List<Vote> getVotes() {
        return new ArrayList<>(votes);
    }
}
