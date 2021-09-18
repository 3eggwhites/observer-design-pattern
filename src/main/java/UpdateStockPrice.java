package main.java;
import java.text.DecimalFormat;

public class UpdateStockPrice implements Runnable {
    private ISubject stockGrabber;
    private double price;
    private String stock;

    public UpdateStockPrice(ISubject stockGrabber, double price, String stock) {
        this.stockGrabber = stockGrabber;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public void run() {
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
            double rand = (Math.random() *0.06) - 0.03;
            double newPrice = Double.valueOf(df.format(price + rand));
            if(stock == "IBM") {
                ((StockGrabber)stockGrabber).setIBMPrice(newPrice);
            }
            if(stock == "AAPL") {
                ((StockGrabber)stockGrabber).setAAPLPrice(newPrice);
            }
            if(stock == "GOOG") {
                ((StockGrabber)stockGrabber).setGOOGPrice(newPrice);
            }

            System.out.println(stock + ": " + df.format(newPrice) + " change " + df.format(rand));
            System.out.println();
        }
    }
}
