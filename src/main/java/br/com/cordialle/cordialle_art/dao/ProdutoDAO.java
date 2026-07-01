package br.com.cordialle.cordialle_art.dao;

import br.com.cordialle.cordialle_art.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class ProdutoDAO {

    // O Spring injeta automaticamente o pool de conexões configurado no application.properties
    @Autowired
    private DataSource dataSource;

    public boolean inserir(Produto p) throws SQLException {
        String sql = "INSERT INTO produto(nome, descricao, preco) VALUES (?, ?, ?)";

        // Usar PreparedStatement é muito mais seguro contra SQL Injection!
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getPreco());

            return ps.executeUpdate() > 0;
        }
    }

    public boolean excluir(Produto p) throws SQLException {
        String sql = "DELETE FROM produto WHERE codigo = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getCodigo());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean atualizar(Produto p) throws SQLException {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ? WHERE codigo = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getDescricao());
            ps.setDouble(3, p.getPreco());
            ps.setInt(4, p.getCodigo());

            return ps.executeUpdate() > 0;
        }
    }

    public ArrayList<Produto> getProdutosPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        ArrayList<Produto> produtos = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + nome + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    produtos.add(mapRow(rs));
                }
            }
        }
        return produtos;
    }

    public ArrayList<Produto> getProdutos() throws SQLException {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> produtos = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                produtos.add(mapRow(rs));
            }
        }
        return produtos;
    }

    // Método auxiliar para não repetir código
    private Produto mapRow(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setCodigo(rs.getInt("codigo"));
        p.setNome(rs.getString("nome"));
        p.setDescricao(rs.getString("descricao"));
        p.setPreco(rs.getDouble("preco"));
        return p;
    }
}