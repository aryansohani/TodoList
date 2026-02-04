package lovejava;
import java.sql.*;

public class Model {

    private String task;
    private Connection connect;
    private PreparedStatement pstm;
    private int row;
    private ResultSet rs;

    public void settask(String task) {
        this.task = task;
    }

    public int add() {
        try {
            connect = JDBCutil.getconnection();
            String query = "INSERT INTO todo(task) VALUES(?)";
            pstm = connect.prepareStatement(query);
            pstm.setString(1, task);
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeAll(connect, pstm);
        }
        return row;
    }

    //show
    public ResultSet show() {
        try {
            connect = JDBCutil.getconnection();
            String query = "SELECT * FROM todo";
            pstm = connect.prepareStatement(query);
            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Close AFTER usage
    public void close() {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (connect != null) connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int delete(int id) {
        int row = 0;
        try {
            connect = JDBCutil.getconnection();
            String query = "DELETE FROM todo WHERE id=?";
            pstm = connect.prepareStatement(query);
            pstm.setInt(1, id);
            row = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCutil.closeAll(connect, pstm);
        }
        return row; // 1 = deleted, 0 = not found
    }
    
}
