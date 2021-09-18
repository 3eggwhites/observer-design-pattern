package main.java;

public class StockObserver implements IObserver{

    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    private static int observerIDTracker;
    private int observerID;

    private StockGrabber stockGrabber;

    public StockObserver(StockGrabber stockGrabber) {
        this.stockGrabber = stockGrabber;
        stockGrabber.register(this);
        observerID = ++observerIDTracker;
        System.out.println("New Observer ID: " + observerID);
    }


    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printPrices();
    }

    private void printPrices() {
        System.out.println(
                "Observer ID: " + observerID
                        + "\nIBM: " + ibmPrice
                        + "\nAAPL: " + aaplPrice
                        + "\nGOOG: " + googPrice + "\n"
        );
    }
}
