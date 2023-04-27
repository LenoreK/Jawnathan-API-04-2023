package jawnathan.data;

import jawnathan.data.mappers.VenueMapper;
import jawnathan.models.Venue;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class VenueJdbcTemplateRepository implements VenueRepository{

    private final JdbcTemplate jdbcTemplate;

    public VenueJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Venue> findAll() {
        // limit until we develop a paging solution
        final String sql = "select venue_id, venue_name, url, address, city, state, zipcode, photo from venue;";
        return jdbcTemplate.query(sql, new VenueMapper());
    }

    @Override
    public Venue findById(int venueId){
        final String sql = "select venue_id, venue_name, url, address, city, state, zipcode, photo "
                + "from venue "
                + "where venue_id = ?;";
        return jdbcTemplate.query(sql, new VenueMapper(), venueId).stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Venue add(Venue venue){
        final String sql = "insert into venue (venue_name, url, address, city, state, zipcode, photo)"
                + "values (?,?,?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, venue.getName());
            ps.setString(2, venue.getUrl());
            ps.setString(3, venue.getAddress());
            ps.setString(4, venue.getCity());
            ps.setString(5, venue.getState());
            ps.setString(6, venue.getZipcode());
            ps.setString(7, venue.getPhoto());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0){
            return null;
        }

        venue.setVenueId(keyHolder.getKey().intValue());
        return venue;
    }

    @Override
    public boolean update(Venue venue){
        final String sql = "update venue set "
                + "venue_name = ?, "
                + "url = ?, "
                + "address = ?, "
                + "city = ?, "
                + "state = ?, "
                + "zipcode = ?, "
                + "photo = ? "
                + "where venue_id = ?;";

        return jdbcTemplate.update(sql,
                venue.getName(),
                venue.getUrl(),
                venue.getAddress(),
                venue.getCity(),
                venue.getState(),
                venue.getZipcode(),
                venue.getPhoto(),
                venue.getVenueId()) > 0;
    }

    @Override
    @Transactional
    public boolean deleteById(int venueId) {
        jdbcTemplate.update("delete from gig where venue_id = ?", venueId);
        return jdbcTemplate.update("delete from venue where venue_id = ?", venueId) > 0;
    }
}
