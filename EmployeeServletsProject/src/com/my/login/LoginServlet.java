/*    */ package com.my.login;
/*    */ 
/*    */ import com.my.database.DBConnection;
/*    */ import com.my.database.DBOperations;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.sql.Connection;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.ResultSetMetaData;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.annotation.WebServlet;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ @WebServlet({"/welcome"})
/*    */ public class LoginServlet extends HttpServlet
/*    */ {
/*    */   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
/*    */     throws ServletException, IOException
/*    */   {
/* 27 */     String username = req.getParameter("username");
/* 28 */     String password = req.getParameter("password");
/* 29 */     PrintWriter pw = resp.getWriter();
/* 30 */     resp.setContentType("text/html");
/*    */     try
/*    */     {
/* 33 */       Connection conn = DBConnection.getConnection();
/* 34 */       PreparedStatement ps = conn.prepareStatement("select * from employee where name = ? and password = ?");
/* 35 */       ps.setString(1, username);
/* 36 */       ps.setString(2, password);
/* 37 */       ResultSet rs = ps.executeQuery();
/* 38 */      
/* 39 */       if (rs.next()) {
	 			
				 pw.print("<table width=50% border=1><caption>Employee Data</caption>");
/* 40 */         ResultSet rs1 = DBOperations.fetchData(conn, "employee");
/* 41 */         ResultSetMetaData meta = rs1.getMetaData();
/* 42 */         int colCount = meta.getColumnCount();
/* 43 */         pw.print("<tr>");
/* 44 */         for (int i = 1; i <= colCount; i++) {
/* 45 */           pw.print("<th>" + meta.getColumnName(i) + "</th>");
/*    */         }
/* 47 */         pw.print("</tr>");
/*    */ 
/* 51 */         while (rs1.next()) {
/* 52 */           pw.print("<tr><td>" + rs1.getInt(1) + "</td><td>" + rs1.getString(2) + "</td><td>" + rs1.getString(3) + "</td><td>" + rs1.getString(4) + 
/* 53 */             "</td><td>" + rs1.getString(5) + "</td><td>" + rs1.getString(6) + "</td><td><input type='button' name=" + rs1.getInt(1) + " value='Edit'></td><td><input type='button' name=" + rs1.getInt(1) + " value='Delete'></td></tr>");
/*    */         }
/*    */ 
/* 56 */         pw.print("</table>");
/* 57 */         System.out.println("User is available");
/*    */       } else {
/* 59 */         System.out.println("User is not available");
/* 60 */         pw.println("<h3 style='color:red'>Username/Password incorrect</h3>");
/* 61 */         RequestDispatcher rd = req.getRequestDispatcher("index.html");
/* 62 */         rd.include(req, resp);
/*    */       }
/*    */     }
/*    */     catch (java.sql.SQLException e) {
/* 66 */       e.printStackTrace();
/*    */     }
/*    */ catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}   }
/*    */ }

/* Location:           C:\Users\Arjun\workspace2\EmployeeProject\build\classes\
 * Qualified Name:     com.my.login.LoginServlet
 * JD-Core Version:    0.6.0
 */