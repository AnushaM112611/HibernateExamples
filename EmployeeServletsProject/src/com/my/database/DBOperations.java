/*    */ package com.my.database;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class DBOperations
/*    */ {
/*    */   public static ResultSet fetchData(Connection conn, String table)
/*    */     throws SQLException
/*    */   {
/* 11 */     PreparedStatement ps = conn.prepareStatement("select * from " + table+"");
/* 12 */     ResultSet rs = ps.executeQuery();
/* 13 */     return rs;
/*    */   }
/*    */ }

/* Location:           C:\Users\Arjun\workspace2\EmployeeProject\build\classes\
 * Qualified Name:     com.my.database.DBOperations
 * JD-Core Version:    0.6.0
 */