package lambdacomparator;

import java.util.*;

public class Clouds {

//    List<CloudStorage> cloudStorages;

    public CloudStorage alphabeticallyFirst(List<CloudStorage> cloudStorages) {
        if (cloudStorages.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        cloudStorages.sort(Comparator.comparing(m -> m.getProvider().toLowerCase(Locale.ROOT)));
        return cloudStorages.stream().findFirst().get();
    }

    private List<CloudStorage> createMutableList(List<CloudStorage> param) {
        List<CloudStorage> storages = new ArrayList<>();
        storages.addAll(param);
        return storages;
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> cloudStorages) {
        cloudStorages = createMutableList(cloudStorages);
        Optional<CloudStorage> optionalCloudStorage = cloudStorages.stream().filter(m -> m.getPrice()==0).findFirst();
        if (optionalCloudStorage.isPresent()) {
            return optionalCloudStorage.get();
        } else {
            cloudStorages.sort(Comparator.comparingDouble(m -> (m.getPrice())));
            return cloudStorages.get(0);
        }
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> cloudStorages) {
        cloudStorages = createMutableList(cloudStorages);
        cloudStorages.sort(Comparator.naturalOrder());
        cloudStorages.sort(Comparator.reverseOrder());
        List<CloudStorage> result = new ArrayList<>();
        for (int i = 0; i< (Math.min(cloudStorages.size(), 3)); i++) {
            result.add(cloudStorages.get(i));
        }
        return result;
    }


    public Clouds() {
    }
}
