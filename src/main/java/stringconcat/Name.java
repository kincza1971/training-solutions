package stringconcat;

import java.beans.PropertyEditorSupport;

public class Name {
    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    private boolean isValid(String familyName, String middleName, String givenName){
        if(familyName == null || familyName == "") {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        if(givenName == null || givenName == "") {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        return !(middleName == null || middleName == "");
    }

    public Name(String familyName, String middleName, String givenName, Title title) {
        if (isValid(familyName, middleName, givenName)) {
            this.middleName =middleName;
        }else {
            this.middleName = "";
        }
        this.familyName = familyName;
        this.givenName = givenName;
        this.title =title;
    }

    public Name(String familyName, String middleName, String givenName){
        if (isValid(familyName, middleName, givenName)) {
            this.middleName =middleName;
        } else {
            this.middleName="";
        }
        this.familyName = familyName;
        this.givenName = givenName;
    }
    public String concatNameWesternStyle(){
        String result="";
        if (title != null){
            result = title.getToPrint() + " ";
        };
        result = result +  givenName + " ";
        if (!middleName.equals("")){
            result = result + middleName + " ";
        }
        result = result + familyName;
        return result;
    }


    public String concatNameHungarianStyle(){
        String result ="";
        if (title != null){
            result = title.getToPrint() + " ";
        };
        result = result + familyName + " ";
        if (!middleName.equals("")){
            result = result + middleName + " ";
        }
        result = result + givenName;
        return result;
    }
}
