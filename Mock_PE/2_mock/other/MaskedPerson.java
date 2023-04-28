import java.util.List;
import java.util.ArrayList;

public class MaskedPerson extends Person {
  private double maskEffectiveness;

  public MaskedPerson(String name) {
    super(name);
    this.maskEffectiveness = SimulationParameters.MASK_EFFECTIVENESS;
  }

  @Override 
  public void infectWith(List<? extends Virus> listOfViruses, double random) {
    if (random <= this.maskEffectiveness) {
      // do nothing 
    } else {
      for (Virus v : listOfViruses) {
        super.getListOfViruses().add(v);
      }
    }
  }
  
  @Override
  public List<? extends Virus> transmit(double random) {
    List<Virus> toSpread = new ArrayList<>();
    List<Virus> listOfViruses = super.getListOfViruses();
    if (random <= this.maskEffectiveness) {
      // do nothing 
    } else {
      for (Virus v : listOfViruses) {
        toSpread.add(v.spread(random));
      }
    }
    return toSpread;
  }
}
