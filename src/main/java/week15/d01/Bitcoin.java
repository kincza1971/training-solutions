package week15.d01;

import java.util.List;

public class Bitcoin {
    private List<Integer> changingRates;

    public Bitcoin(List<Integer> changingRates) {
    }

    private Position createPosition(int numberOfDay, int price) {
        return new Position(numberOfDay,price);
    }

    private Position findMaximumPositionAfterThisDay(int day) {
        int maxValue =Integer.MIN_VALUE;
        int dayOfMaxValue =0;
        for (int i = day+1; i< changingRates.size() ;i++) {
            if (changingRates.get(i)> maxValue) {
                maxValue=changingRates.get(i);
                dayOfMaxValue=i;
            }
        }
        return new Position(dayOfMaxValue,maxValue);
    }

    public Offer whenToTrade(List<Integer> changingRates) {
        this.changingRates = changingRates;
        Position thisPosition =new Position(0,changingRates.get(0));
        Position maxPositionAfterThisPosition = findMaximumPositionAfterThisDay(0);
        Offer bestOffer = new Offer(thisPosition, maxPositionAfterThisPosition);
        int aktPrice;
        for (int i=1; i< changingRates.size(); i++) {
            aktPrice = changingRates.get(0);
            if(aktPrice < bestOffer.getMinPosition().getPrice()) {
                thisPosition = new Position(i,aktPrice);
                maxPositionAfterThisPosition = findMaximumPositionAfterThisDay(i);
                if (bestOffer.getMargin() < thisPosition.getMargin(maxPositionAfterThisPosition)){
                    bestOffer = new Offer(thisPosition,maxPositionAfterThisPosition);
                }
            }
        }
        return bestOffer;
    }
}
