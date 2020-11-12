package controliteration.dictionary;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<DictionaryItem> aDictionary;

    public List<String> findTranslations(String word){
        List<String> result = new ArrayList<>();
        for (DictionaryItem anItem : aDictionary) {
            if (anItem.getWord().equals(word)) {
                return anItem.getTranslations();
            }
        }
        return result;
    }

    public void addItem(String newWord, List<String> newTranslations) {
        boolean isNew = true;
        DictionaryItem oldItem = null;
        for (DictionaryItem anItem : aDictionary) {
            if (anItem.getWord().equals(newWord)){
                isNew=false;
                oldItem = anItem;
            }
        }
        if (isNew) {
            aDictionary.add(new DictionaryItem(newWord,newTranslations));
        } else {
            oldItem.addTranslations(newTranslations);
        }
    }


    public Dictionary(List<DictionaryItem> aDictionary) {
        this.aDictionary = aDictionary;
    }
}
