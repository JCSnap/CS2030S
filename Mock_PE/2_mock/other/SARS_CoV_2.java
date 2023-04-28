public class SARS_CoV_2 extends Virus {

  public SARS_CoV_2(double probability) {
    super("SARS-CoV-2", probability);
  }

  @Override
  public Virus spread(double random) {
    if (super.lowerThanProbability(random)) {
      return new BetaCoronavirus();
    } else {
      double newProbability = SimulationParameters.VIRUS_MUTATION_PROBABILITY_REDUCTION * super.getProbability();
      return new SARS_CoV_2(newProbability);
    }
  }
}
