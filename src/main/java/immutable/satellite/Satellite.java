package immutable.satellite;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;


    private boolean isEmpty(String str) {
        return (str == null || str.isBlank());
    }

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent){
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent =registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(
                this.destinationCoordinates.getX()+diff.getX(),
                this.destinationCoordinates.getY()+diff.getY(),
                this.destinationCoordinates.getZ()+diff.getZ()
                );
    }

    public CelestialCoordinates getDestinationCoordinates() {

        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",registerIdent,destinationCoordinates.toString());
    }



}
