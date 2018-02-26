package es.salesianos.repository;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import es.salesianos.models.Elemento;


@Component
public class ElementoRepository {

	private static Logger log = LogManager.getLogger(ElementoRepository.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Elemento elementoFormulario) {
		log.debug("el log funciona");
		String sql = "INSERT INTO Elementos (name,Estado)" + "VALUES ( :name, :Estado)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", elementoFormulario.getName());
		params.addValue("Estado", elementoFormulario.getEstado());
		namedJdbcTemplate.update(sql, params);
	}

//	public Optional<Elemento> search(Elemento elemento) {
//		String sql = "SELECT * FROM Elementos WHERE name = ?";
//		log.debug("ejecutando la consulta: " + sql);
//		Elemento element= null;
//		try {
//			element = (Elemento) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Elemento.class), elemento.getName());
//		} catch (EmptyResultDataAccessException e) {
//			log.error("error", e);
//		}
//		return Optional.ofNullable(element);
//
//	}

//	public void updateState(Elemento elemento) {
//		String sql = "UPDATE Elementos SET " + "Estado = ? WHERE name = ?";
//		jdbcTemplate.update(sql, elemento.getEstado(), elemento.getName());
//	}
	
	public void updateState(String estado,String id) {
		String sql = "UPDATE Elementos SET " + "Estado = ? WHERE name = ?";
		jdbcTemplate.update(sql, estado, id);
	}

	public List<Elemento> listElementsByState(String estado) {
		String sql = "SELECT * FROM Elementos WHERE Estado = ?";
		List<Elemento> elementos = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Elemento.class), estado);
		return elementos;
	}

	/*public void delete(String tablename, Integer id) {
		// log.debug("id: " + id.toString());
		log.debug("tablename: " + tablename);
		String sql = "DELETE FROM " + tablename + " WHERE dni = '?'";
		log.debug(sql);
		// jdbcTemplate.update(sql, id.toString());
	}*/


}
