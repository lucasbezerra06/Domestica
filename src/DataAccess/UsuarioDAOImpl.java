package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataAccesInter.UsuariosDAO;
import controller.ControllTipoUsuario;
import model.TiposUsuario;
import model.Usuarios;

public class UsuarioDAOImpl implements UsuariosDAO{
	private Connection con;
	public UsuarioDAOImpl() {
		con = new ConnectionFactory().getConnection();
	}
	@Override
	public Usuarios pesquisar(int idUsuario) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void inserir(Usuarios usuario) throws SQLException {
		String sql = "INSERT INTO `usuarios` (`fk_id_tipo_usuario`, `cpf`, `rg`, `nome`, `saldo`, `mascara_cartao_credito`, `token_cartao_credito`, `conta_corrente`, `agencia`, `banco`, `cod_banco`, `senha`) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		//stmt.setInt(1, usuario.getIdUsuarios());
		//stmt.setInt(2, usuario.getTipoUsuario().getIdTipoUsuario());
		stmt.setInt(1, usuario.getTipoUsuario().getIdTipoUsuario());
		stmt.setString(2, usuario.getCpf());
		stmt.setString(3, usuario.getRg());
		stmt.setString(4, usuario.getNome());
		stmt.setFloat(5, usuario.getSaldo());
		stmt.setInt(6, usuario.getMascaraCartaoCred());
		stmt.setString(7, usuario.getTokenCartaoCred());
		stmt.setString(8, usuario.getContaCorrente());
		stmt.setString(9, usuario.getAgencia());
		stmt.setString(10, usuario.getBanco());
		stmt.setInt(11, usuario.getCodBanco());
		stmt.setString(12, usuario.getSenha());
		//executa
		stmt.execute();
		stmt.close();
		
		System.out.println("Gravado!");
		con.close();
		
	}
	@Override
	public void remover(int idUsuario) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Usuarios login(String nome, String senha) throws SQLException {
		PreparedStatement stmt = con.prepareStatement("select * from usuarios where nome = '"+nome+"' and senha = '"+senha+"'");
		//executa
		ResultSet rs = stmt.executeQuery();
		if(rs != null) {
			Usuarios usuario = new Usuarios();
			
			rs.next();
			usuario.setIdUsuarios(rs.getInt("id_usuarios"));
			System.out.println("chegou");
			System.out.println(rs.getInt("fk_id_tipo_usuario"));
			TiposUsuario t = new ControllTipoUsuario().pesquisar(rs.getInt("fk_id_tipo_usuario")); 
			usuario.setTipoUsuario(t);
			usuario.setCpf(rs.getString("cpf"));
			usuario.setRg(rs.getString("rg"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSaldo(rs.getFloat("saldo"));
			usuario.setMascaraCartaoCred(rs.getInt("mascara_cartao_credito"));
			usuario.setTokenCartaoCred("token_cartao_credito");
			usuario.setContaCorrente(rs.getString("conta_corrente"));
			usuario.setAgencia(rs.getString("agencia"));
			usuario.setBanco(rs.getString("banco"));
			usuario.setCodBanco(rs.getInt("cod_banco"));
			usuario.setSenha(rs.getString("senha"));
			stmt.close();
			con.close();
			return usuario;
		}else {
			return null;
		}
		
		
	}
	
}
