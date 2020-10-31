package gacky.mydb;

import java.sql.*;

//連線程式，關閉程式
public class Mysql {

    public static Connection con;//連線變數,要設定為static共用
    public static Statement stmt;//建立查詢物件變數,要設定為static共用

    public static void open(String db, String acc, String pwd) {//open方法是連線,static
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //"?characterEncoding=utf-8"防止亂碼
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?characterEncoding=utf-8", acc, pwd);
            stmt = con.createStatement();
            System.out.println("資料庫連線成功");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到連線類別檔案");
        } catch (SQLException e) {
            System.out.println("資料庫無法連線!!!" + e.toString());
            System.out.println("請檢查帳號及密碼是否有誤，");
            System.out.println("或者mysql服務是否關閉。");
        }
    }

    public static void close() {//關閉方法
        try {
            con.close();
            stmt.close();
            System.out.println("關閉連線");
        } catch (Exception e) {
        }
    }
}
