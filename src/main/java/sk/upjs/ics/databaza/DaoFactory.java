package sk.upjs.ics.databaza;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.postgresql.ds.PGPoolingDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public enum DaoFactory {

    INSTANCE;
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
            this.jdbcTemplate = new JdbcTemplate(dataSource());
            
        }
        return this.jdbcTemplate;
    }

    public DataSource dataSource() {
        /* jdbc dataSource = new PGSimpleDataSource();
         dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
         dataSource.setDatabaseName("postgres");
         dataSource.setUser("postgres");
         dataSource.setPassword("dominika");
         this.dataSource = dataSource;*/

        PGSimpleDataSource source = new PGSimpleDataSource();
        source.setUrl("jdbc:postgresql://localhost:5432/postgres");
        source.setDatabaseName("postgres");
        source.setUser("postgres");
        source.setPassword("dominika");

        Connection conn = null;
        try {
            conn = source.getConnection();

            // use connection
        } catch (SQLException e) {

        }

        return source;
    }

}
