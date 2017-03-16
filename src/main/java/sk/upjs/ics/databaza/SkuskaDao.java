
package sk.upjs.ics.databaza;

import sk.upjs.ics.databaza.Skuska;
import java.util.List;

public interface SkuskaDao {
  public List<Skuska> dajVsetky();
  public void pridaj(Skuska skuska);
  public void odstran(Skuska skuska);
}
