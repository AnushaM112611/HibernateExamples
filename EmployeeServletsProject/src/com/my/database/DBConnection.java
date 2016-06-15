/*    */ package com.my.database;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.SQLException;
/*    */ 
/*    */ public class DBConnection
/*    */ {
/*    */   public static Connection getConnection()
/*    */     throws ClassNotFoundException, SQLException
/*    */   {
/* 11 */     Class.forName("com.mysql.jdbc.Driver");
/* 12 */     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
/* 13 */     if (conn == null) {
/* 14 */       throw new NullPointerException("Database connection instantiation failed");
/*    */     }
/* 16 */     return conn;
/*    */   }
/*    */ }

/* Location:           C:\Users\Arjun\workspace2\EmployeeProject\build\classes\
 * Qualified Name:     com.my.database.DBConnection
 * JD-Core Version:    0.6.0
 */