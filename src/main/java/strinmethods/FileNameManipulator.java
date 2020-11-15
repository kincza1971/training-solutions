package strinmethods;

public class FileNameManipulator {

    private void stringValidator (String fName) throws IllegalArgumentException{
        if (fName == null || fName.isBlank()) {
            throw new IllegalArgumentException("Üres vagy null string nem lehet paraméter");
        }
    }

    public char findLastCharacter(String str) {
        stringValidator(str);
        return str.charAt(str.length()-1);
    }


    public String findFileExtension(String fileName) {
        stringValidator(fileName);
        int indexOfDot =fileName.lastIndexOf('.');
        if (indexOfDot==-1 || indexOfDot == fileName.length()-1) {
            throw new IllegalArgumentException("A parameter tartalmaz kiterjesztést");
        }
        return fileName.substring(indexOfDot+1);
    }


    public boolean identifyFilesByExtension(String ext, String fileName) throws IllegalArgumentException {
        stringValidator(ext);
        stringValidator(fileName);
        fileName = fileName.trim();
        ext = ext.trim();
        int indexOfDot = fileName.lastIndexOf('.');
        if (indexOfDot==-1 || indexOfDot == fileName.length()-1) {
            throw new IllegalArgumentException(" A fájlnak nincs kiterjesztése");
        }
        return(fileName.substring(indexOfDot+1).equals(ext));
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        stringValidator(searchedFileName);
        stringValidator(actualFileName);
        return searchedFileName.trim().equals(actualFileName.trim());
    }

    public String changeExtensionToLowerCase(String fileName) throws IllegalArgumentException {
        stringValidator(fileName);
        fileName = fileName.trim();
        int indexOfDot = fileName.lastIndexOf('.');
        if (indexOfDot==-1 || indexOfDot == fileName.length()-1) {
            throw new IllegalArgumentException(" A fájlnak nincs kiterjesztése");
        } else {
            return fileName.substring(0,indexOfDot) + fileName.substring(indexOfDot+1).toLowerCase();
        }
    }

    public String replaceStringPart( String fileName, String presentString, String targetString) {
        stringValidator(fileName);
        return fileName.trim().replace(presentString,targetString);
    }
}
