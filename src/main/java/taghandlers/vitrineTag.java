/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taghandlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.sql.DataSource;

/**
 *
 * @author mseefelder
 */
public class vitrineTag extends SimpleTagSupport {

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    
    public String productCategory;
    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        String products = null;
        try {
            products= productDisplay();
        } catch (NamingException ex) {
            Logger.getLogger(vitrineTag.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(vitrineTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            out.println(
"<div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\">\n" +
"          <h1 class=\"page-header\">Vitrine</h1>\n" +
"          <div class=\"row placeholders\">\n" +
"            \n" +
products +
"            \n" +
"          </div>\n" +
"          \n" +
"        </div>"
            );

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in vitrineTag tag", ex);
        }
    }
    
    public String productDisplay() throws NamingException, SQLException
    {
        String displayCode = "";
        
        DataSource ds = getOmniBase();
        Connection connection = ds.getConnection();
 
        if (connection == null)
        {
            throw new SQLException("Error establishing connection!");
        }
        
        String query1 = null;
        
        if(productCategory == null || productCategory.isEmpty())
        {
            query1 = "SELECT * FROM product";
        }
        else
        {
            query1 = "SELECT a.* FROM product a WHERE a.category_id=(SELECT b.id FROM category b WHERE b.name=\""+productCategory+"\")";
        }
        PreparedStatement statement = connection.prepareStatement(query1);
        ResultSet rs = statement.executeQuery();
        
        String tempName = null;
        
        while (rs.next())
        {
            tempName = rs.getString("name");
            displayCode = displayCode +
                    "<div class=\"col-md-4 placeholder\">\n" +
"                <input type=\"image\" src=\"pics/"+tempName.toLowerCase()+".jpg\" style=\"display: inline-block; border-radius: 25%;" +
"  max-height: 128px; " +"  max-width: 128px;\" class=\"img-responsive\" alt=\"Generic placeholder thumbnail\">\n" +
"              <h4>"+tempName+"</h4>\n" +
"              <span class=\"text-muted\">"+rs.getInt("price")+"</span>\n" +
"            </div>"+"\n" +
"            ";
        }
        
        return displayCode;
    }

    private DataSource getOmniBase() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/omniBase");
    }
    
}
