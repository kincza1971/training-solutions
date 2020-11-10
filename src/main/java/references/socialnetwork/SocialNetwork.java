package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {
    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        Member member = new Member(name);
        members.add(member);
    }

    public List<String> bidirectionalConnections(){
        List<String> biConn= new ArrayList<>();
        for (Member member : members) {
            for (Member connected : member.getConnections()) {
                for (Member reConnected : connected.getConnections())
                if (reConnected.getName().equals(member.getName())) {
                    biConn.add(member.getName() + " - " + connected.getName());
                }
            }
        }
        return  biConn;
    }

    public Member findByName(String name) {
        Member result = new Member("");
        for (Member member : members) {
            if (member.getName().equals(name)) {
                result = member;
            }
        }
        return result;
    }

    public void connect(String name, String otherName) {
        Member member = new Member("");
        Member otherMember = new Member("");
        member=findByName(name);
        otherMember = findByName(otherName);
        member.connectMember(otherMember);
    }

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.addMember("Joe");
        socialNetwork.addMember("John");
        socialNetwork.addMember("Jane");
        socialNetwork.addMember("Richard");

        socialNetwork.connect("Joe", "John");
        socialNetwork.connect("John", "Joe");

        System.out.println(socialNetwork.bidirectionalConnections());
    }
}
