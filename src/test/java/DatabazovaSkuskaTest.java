/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sk.upjs.ics.databaza.DaoFactory;
import sk.upjs.ics.databaza.Skuska;
import sk.upjs.ics.databaza.SkuskaDao;


public class DatabazovaSkuskaTest {
    SkuskaDao skuskaDao = DaoFactory.INSTANCE.getSkuskaDao();
  
    
 @Test
    public void dajVsetkyTest() {
       List<Skuska> skusky = skuskaDao.dajVsetky();
       
       assertEquals(3, skusky.size());
    }
    
}
