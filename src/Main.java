import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // url = "jdbc:mysql://localhost:3306/数据库名"
        String url = "jdbc:mysql://localhost:3306/zhangtest";
        String user = "root";
        String pwd = "123456";
        // jdbc驱动
        String Driver = "com.mysql.cj.jdbc.Driver";

        try {
            // 注册jdbc驱动
            Class.forName(Driver);
            Connection connection = DriverManager.getConnection(url,user,pwd);
            if(!connection.isClosed()){
                System.out.println("数据库连接成功！");

            }
            //创建一个statement对象
            Statement s = connection.createStatement();

            //执行SQL语句,最后的分号可有可不有
            /*for(int i=6;i<100;i++){
                String sql = "insert into person values("+i+",'aaa',10)";
                s.execute(sql);
            }*/
            String sql1 = "select * from person";
            s.execute(sql1);
     connection.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库驱动未找到！");
        }
    }
}