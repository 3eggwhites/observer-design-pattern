package main.java;

public class GrabStocks {

    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver observer1 = new StockObserver(stockGrabber);

        Runnable ibmStock = new UpdateStockPrice(stockGrabber, 10.00, "IBM");
        Runnable aaplStock = new UpdateStockPrice(stockGrabber, 250.00, "AAPL");
        Runnable googStock = new UpdateStockPrice(stockGrabber, 200.00, "GOOG");

        new Thread(ibmStock).start();
        new Thread(aaplStock).start();
        new Thread(googStock).start();
    }
}
