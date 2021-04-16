package com.order.util;
/*
* @封装结果为map对象
* */

import org.apache.commons.lang.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {
    private static DBUtil_pool  dbp = new DBUtil_pool();
    private static Connection conn=dbp.getConnection();
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;
    //private static final String QUER_USER_BY_USERNAME_PASSWORD="select * from order_user where UserFname=? and UserPassword=?";

//    public static void main(String[] args) {
//        String user = "hayami";
//        String sql = "select * from order_user where userFname = '"+user+"'";
//        Object[] ob = null;
//        try {
//            execQuery(sql,ob);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 封装为List<map>对象
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> execQuery(String sql, Object[] args) throws Exception {
        //Connection conn = getConn();
        PreparedStatement ps = conn.prepareCall(sql);
        //ResultSet rs = null;
        //寻找有多少个？
        int count = StringUtils.countMatches(sql, "?");

        //变量赋值。。。。。。
        for (int i = 1; i <= count; i++) {
            ps.setObject(i, args[i-1]);
        }

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        rs = ps.executeQuery();

        ResultSetMetaData metaData = rs.getMetaData();
        //注意。。metaData.getColumnName 获取字段名，rs.getObject 获取属性 是从 1 开始的，而不是从0 开始
        while (rs.next()) {
            int rowSize = metaData.getColumnCount();
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= rowSize; i++) {
                String labelName = metaData.getColumnName(i);
                Object obj = rs.getObject(labelName);
                map.put(labelName, obj);
            }
            list.add(map);
        }

        System.out.println(list);
//        close(conn, ps, rs);
        //关闭连接
//        dbp.closeReSource(stat,rs,conn);
        return list;
    }


//    /**
//     * @param conn
//     * @param ps
//     * @param rs
//     * @throws Exception
//     */
//    private static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws Exception {
//        rs.close();
//        ps.close();
//        conn.close();
//    }
}
