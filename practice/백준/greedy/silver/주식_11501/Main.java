package practice.백준.greedy.silver.주식_11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        StockController stockController = new StockController(new InputView(), new OutputView(), new StockTrader());
        stockController.run();
    }
}

class StockController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StockTrader stockTrader;

    StockController(InputView inputView, OutputView outputView, StockTrader stockTrader) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stockTrader = stockTrader;
    }

    void run() {
        int testcaseCount = inputView.readTestcaseCount();

        TradeMargins tradeMargins = IntStream.range(0, testcaseCount)
                .mapToObj(ignore -> calculateTradeMargin())
                .collect(Collectors.collectingAndThen(Collectors.toList(), TradeMargins::new));

        outputView.printResult(tradeMargins.margins());
    }

    private TradeMargin calculateTradeMargin() {
        List<Integer> stockPrices = inputView.readStockPrice();
        Stocks stocks = Stocks.from(stockPrices);
        return stockTrader.trade(stocks);
    }
}

class StockTrader {

    TradeMargin trade(Stocks stocks) {
        return new TradeMargin(stocks.trade());
    }
}

class Stock {
    private final int price;

    Stock(int price) {
        this.price = price;
    }

    int value() {
        return this.price;
    }
}

class Stocks {
    private final List<Stock> stocks;

    private Stocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    static Stocks from(List<Integer> stockPrices) {
        return new Stocks(convertToStock(stockPrices));
    }

    private static List<Stock> convertToStock(List<Integer> stockPrices) {
        return stockPrices.stream()
                .map(Stock::new)
                .collect(Collectors.toList());
    }

    long trade() {
        long maxProfit = 0;
        int maxPriceSoFar = 0;
        for (int i = stocks.size() - 1; i >= 0; i--) {
            int currentStockValue = stocks.get(i).value();
            maxPriceSoFar = Math.max(maxPriceSoFar, currentStockValue);
            maxProfit += maxPriceSoFar - currentStockValue;
        }

        return maxProfit;
    }
}


class TradeMargin {
    private final long margin;

    TradeMargin(long margin) {
        this.margin = margin;
    }

    long margin() {
        return margin;
    }
}

class TradeMargins {
    private final List<TradeMargin> margins;

    TradeMargins(List<TradeMargin> margins) {
        this.margins = margins;
    }

    List<TradeMargin> margins() {
        return margins;
    }
}

class InputView {
    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    int readTestcaseCount() {
        return Integer.parseInt(readInput());
    }

    private String readInput() {
        try {
            return BR.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException("입력받는 중 에러가 발생했습니다.");
        }
    }

    List<Integer> readStockPrice() {
        int daysCount = readDaysCount();

        List<Integer> stockPrices = parseStockPrices();

        if (daysCount != stockPrices.size()) {
            throw new IllegalArgumentException("날짜 수와 주식 가격의 수가 일치하지 않습니다.");
        }

        return stockPrices;
    }

    private List<Integer> parseStockPrices() {
        return Arrays.stream(readInput().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int readDaysCount() {
        return Integer.parseInt(readInput());
    }
}

class OutputView {

    void printResult(List<TradeMargin> tradeMargins) {
        tradeMargins.forEach(margin -> System.out.println(margin.margin()));
    }
}
