package sk.upjs.ics.databaza;

import java.util.ArrayList;
import java.util.List;

public class Taco {

    SkuskaDao skuskaDao = DaoFactory.INSTANCE.getSkuskaDao();

    public void metoda() {
        List<Skuska> vypis = new ArrayList<>();
       vypis = skuskaDao.dajVsetky();
        for (int i = 0; i < vypis.size(); i++) {

            System.out.println(vypis.get(i).getId() + ", " + vypis.get(i).getMeno() + ", " + vypis.get(i).getPriezvisko());
        }
    }

    public static void main(String[] args) {
    Taco ta= new Taco();
   ta.metoda();

    }

}
