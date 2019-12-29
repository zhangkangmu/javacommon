package 设计模式.strategy;

public class TranficCalculator {

	CalculateStrategy calculateStrategy;

	public void calculatePrice(CalculateStrategy calculateStrategy, Integer km) {

		this.calculateStrategy = calculateStrategy;
		calculateStrategy.calculatePrice(km);
	}

}
