public class AlphaCoronavirus extends Virus {

  public AlphaCoronavirus(double probability) {
    super("Alpha Coronavirus", probability);
  }

  @Override
  public Virus spread(double random) {
    if (random <= this.probability) {
      return new SARS_CoV_2(this.probability);
    } else {
      double newProbability = SimulationParameters.VIRUS_MUTATION_PROBABILITY_REDUCTION * this.probability;
      return new AlphaCoronavirus(newProbability);
    }
  }
}
