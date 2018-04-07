package com.dadan.study.mybatis.executor;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleExecutor implements Executor{

	public <T> T query(Class<T> cls,String sql, Object[] args){
		T t = null;
		//声明Connection对象
        Connection con = connectionMysql();
        //遍历查询结果集
        try {
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            PreparedStatement statement = con.prepareStatement(sql);
            //3.ResultSet类，用来存放获取的结果集！！
            for(int i=0;i<args.length;i++){
            	if(args[i].getClass()==String.class)
            		statement.setString(i+1, String.valueOf(args[i]));
            	if(args[i].getClass()==Integer.class)
            		statement.setInt(i+1, Integer.parseInt(String.valueOf(args[i])));
            }
            
            ResultSet rs = statement.executeQuery();
            
            t = cls.newInstance();
            while(rs.next()){
                Field[] fields = cls.getDeclaredFields();
                for(Field field:fields){
                	try{
                		field.setAccessible(true);
                    	PropertyDescriptor pd =new PropertyDescriptor(field.getName(), cls);
                    	Method method = pd.getWriteMethod();
                    	if(field.getType()==String.class)
                    		method.invoke(t, rs.getString(field.getName()));
                    	else if(field.getType()==int.class)
                    		method.invoke(t, rs.getInt(field.getName()));
                	}catch (IntrospectionException e) {
						e.printStackTrace();
					}

                }
            }
            rs.close();
            con.close();
        } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
        	try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
		return t;
	}
	public Connection connectionMysql(){
		//声明Connection对象
        Connection con = null;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/mybatis";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url,user,password);
        } catch(ClassNotFoundException e) {   
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");   
            e.printStackTrace();   
            } catch(SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();  
            }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            System.out.println("数据库数据成功获取！！");
        }
        return con;
	}
}
