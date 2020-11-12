package controliteration.dictionary;

import java.util.List;

public class DictionaryItem {
    private String word;
    private List<String> translations;

    public void addItem(String item) {

    }

    public DictionaryItem(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public void addTranslations(List<String> toAdd) {
        for (String newTranslation : toAdd) {
            if (!translations.contains(newTranslation)) {
                translations.add(newTranslation);
            }
        }
    }

}
