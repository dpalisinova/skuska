package sk.upjs.ics.databaza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.postgresql.ds.PGPoolingDataSource;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;

public class mainn {

    private JdbcTemplate jdbcTemplate;
    private PGSimpleDataSource source;
    private SkuskaDao skuskaDao;

    public SkuskaDao getSkuskaDao() {
        if (this.skuskaDao == null) {
            this.skuskaDao = new DatabazovaSkuska(jdbcTemplate);
        }
        return this.skuskaDao;
    }

    public JdbcTemplate jdbcTemplate() {
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(d());
        }
        return this.jdbcTemplate;
    }

    public DataSource d() {
        /* jdbc dataSource = new PGSimpleDataSource();
         dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
         dataSource.setDatabaseName("postgres");
         dataSource.setUser("postgres");
         dataSource.setPassword("dominika");
         this.dataSource = dataSource;*/

        PGSimpleDataSource source = new PGSimpleDataSource();
        //  source.setDataSourceName("A Data Source");
        source.setUrl("jdbc:postgresql://localhost:5432/postgres");
        source.setDatabaseName("postgres");
        source.setUser("postgres");
        source.setPassword("dominika");
        //source.setMaxConnections(10);

        Connection conn = null;
        try {
            conn = source.getConnection();
            System.out.println(source.getDatabaseName());
            java.sql.Statement st = conn.createStatement();
            String sql = "SELECT * FROM \"Osoba\";";
            BeanPropertyRowMapper<Skuska> mapper = BeanPropertyRowMapper.newInstance(Skuska.class);
            
            System.out.println(jdbcTemplate.query(sql, mapper));

            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                String id = result.getString("ID");
                String meno = result.getString("Meno");
                String priezvisko = result.getString("Priezvisko");
                System.out.println("ID: " + id + " Meno: " + meno + " Priezvisko: " + priezvisko);
            }

            // use connection
        } catch (SQLException e) {

        }

        return source;
    }

}
