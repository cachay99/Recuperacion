package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.model.Character;
import es.salesianos.util.DbQueryConstants;
@org.springframework.stereotype.Repository("characterRepository")
public class CharacterRepository implements Repository<Character> {

	@Autowired
	protected AbstractConnection manager;

	@Override
	public void insert(Character character) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement(DbQueryConstants.INSERT_CHARACTER);
			preparedStatement.setString(1, character.getName());
			preparedStatement.setString(2, character.getCarrier());
			preparedStatement.setInt(3, character.getCodRace());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	@Override
	public List<Character> listAll() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		ArrayList<Character> characters = new ArrayList<Character>();
		try {
			preparedStatement = conn.prepareStatement(DbQueryConstants.SELECT_ALL_CHARACTER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Character character = new Character();
				character.setId(resultSet.getInt("id"));
				character.setName(resultSet.getString("nombre"));
				character.setCarrier(resultSet.getString("portador"));
				character.setCodRace(resultSet.getString("codRaza"));
				characters.add(character);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return characters;
	}

	@Override
	public void update(Character character) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			updateCarrier();
			preparedStatement = conn.prepareStatement(DbQueryConstants.UPDATE_CHARACTER);
			preparedStatement.setString(1, character.getName());
			preparedStatement.setString(2, character.getCarrier());
			preparedStatement.setInt(3, character.getCodRace());
			preparedStatement.setInt(4, character.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	@Override
	public void delete(Integer idCharacter){
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(DbQueryConstants.DELETE_CHARACTER);
			preparedStatement.setInt(1, idCharacter);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	//este metodo pone a todos los personajes como NO portador del anillo
	public void updateCarrier() {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(DbQueryConstants.UPDATE_CARRIER);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Character selectById(Integer idCharacter) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		Character character;
		try {
			preparedStatement = conn.prepareStatement(DbQueryConstants.SELECT_CHARACTER_BY_ID);
			preparedStatement.setInt(1, idCharacter);
			ResultSet resultSet = preparedStatement.executeQuery();

			resultSet.next();

			character = new Character();
			character.setId(resultSet.getInt("id"));
			character.setName(resultSet.getString("nombre"));
			character.setCarrier("portador");
			character.setCodRace(resultSet.getString("codRaza"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return character;
	}
}
