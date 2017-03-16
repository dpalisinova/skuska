/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.databaza;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class DatabazovaSkuska implements SkuskaDao {

    private JdbcTemplate jdbcTemplate;

    private static final String TABLE_NAME = "Osoba";

    public DatabazovaSkuska(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Skuska> dajVsetky() {
        String sql = "SELECT * FROM \"Osoba\";";
        
        BeanPropertyRowMapper<Skuska> mapper = BeanPropertyRowMapper.newInstance(Skuska.class);

        
        return jdbcTemplate.query(sql, mapper);
    }

    @Override
    public void pridaj(Skuska skuska) {
        String sql = "INSERT INTO" + TABLE_NAME + "VALUES(?,?)";
        jdbcTemplate.update(sql, skuska.getId(), skuska.getMeno());
    }

    @Override
    public void odstran(Skuska skuska) {
        String sql = "DELETE * FROM " + TABLE_NAME + "WHERE id=?";
        jdbcTemplate.update(sql, skuska.getId());
    }

   
}
