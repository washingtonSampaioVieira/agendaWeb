package br.senai.sp.cfp127.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;

public class compromssoDao {
	
	private Compromisso compromisso;
	private PreparedStatement stm;
	private ResultSet rs;

	public ArrayList<Compromisso> getCompromissos(int codCompromisso) {
		ArrayList<Compromisso> compromisso = new ArrayList<>();

		String sql = "SELECT * FROM tbl_compromisso " + "WHERE cod_usuario = ? ORDER BY nome"+codCompromisso;
		try {
			stm = Conexao.getConexao().prepareStatement(sql);
			rs = stm.executeQuery();

			while (rs.next()) {
				this.compromisso = new Compromisso();
				this.compromisso.setCod_compromisso(rs.getInt("cod_compromisso"));
				this.compromisso.setTitulo(rs.getString("titulo"));
				this.compromisso.setData(rs.getDate("data").toString());
				this.compromisso.setPrioridade(rs.getInt("prioridade"));
	
				compromisso.add(this.compromisso);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return compromisso;
	}

}
