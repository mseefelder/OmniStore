/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taghandlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import static javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED;
import javax.servlet.jsp.tagext.BodyTagSupport;
import static javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN;
import static javax.servlet.jsp.tagext.Tag.EVAL_PAGE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import static javax.servlet.jsp.tagext.Tag.SKIP_PAGE;
import javax.sql.DataSource;

/**
 *
 * @author mseefelder
 */
public class productTagHandler extends BodyTagSupport {
    
    /**
     * Creates new instance of tag handler
     */
    public productTagHandler() {
        super();
    }

    ////////////////////////////////////////////////////////////////
    ///                                                          ///
    ///   User methods.                                          ///
    ///                                                          ///
    ///   Modify these methods to customize your tag handler.    ///
    ///                                                          ///
    ////////////////////////////////////////////////////////////////
    /**
     * Method called from doStartTag(). Fill in this method to perform other
     * operations from doStartTag().
     */
    private void otherDoStartTagOperations() {        
        try {
            JspWriter out = pageContext.getOut();
            out.println(
"<div class=\"col-md-10 col-md-offset-2 col-xs-9 col-xs-offset-3 col-sm-8 col-sm-offset-4 container-fluid main\">\n" +
"          <h1 class=\"page-header\">Produto: </h1>"
            );
        } catch (IOException ex) {
            // do something
        }
    }
    
    public String singleProductDisplay(String productName) throws NamingException, SQLException
    {
        String displayCode = "";
        
        DataSource ds = getOmniBase();
        Connection connection = ds.getConnection();
 
        if (connection == null)
        {
            throw new SQLException("Error establishing connection!");
        }
        
        String query1 = "SELECT a.* FROM product a WHERE a.name=\""+productName+"\"";
        
        PreparedStatement statement = connection.prepareStatement(query1);
        ResultSet rs = statement.executeQuery();
        
        rs.next();
        
        displayCode = 
"<div class=\"col-md-4 col-xs-4 col-sm-3\">\n" +
"            <img src=\"pics/"+productName+".jpg\" class=\"img-responsive\">\n" +
"          </div>\n" +
"          <div class=\"col-md-6 col-xs-5 col-sm-5\">\n" +
"            <p>"+rs.getString("description")+"</p><p>Custo: "+
rs.getInt("price")+" peças de ouro.</p>\n" +
"<button type=\"submit\" class=\"btn btn-default\" name=\"bought\" value=\""+
                    "yes"+
                    "\" style=\"width:100%;\">"+"Comprar"+"</button> \n"+
"          </div>";
        
        connection.close();
        
        return displayCode;
    }

    /**
     * Method called from doEndTag() Fill in this method to perform other
     * operations from doEndTag().
     */
    private void otherDoEndTagOperations() {
        // TODO: code that performs other operations in doEndTag
        //       should be placed here.
        //       It will be called after initializing variables,
        //       finding the parent, setting IDREFs, etc, and
        //       before calling shouldEvaluateRestOfPageAfterEndTag().
    }

    /**
     * Fill in this method to process the body content of the tag. You only need
     * to do this if the tag's BodyContent property is set to "JSP" or
     * "tagdependent." If the tag's bodyContent is set to "empty," then this
     * method will not be called.
     */
    private void writeTagBodyContent(JspWriter out, BodyContent bodyContent) throws IOException, NamingException, SQLException {

        // Or else get the body content as a string and process it, e.g.:
        String bodyStr = bodyContent.getString();
        bodyStr.replace("\n", "");
        //bodyStr.replace(" ", "");
        //bodyStr = "";
        String productDisplay = singleProductDisplay(bodyStr);
        out.println(
productDisplay +
"            \n" +
"          </div>");

        // clear the body content for the next time through.
        bodyContent.clearBody();
    }

    ////////////////////////////////////////////////////////////////
    ///                                                          ///
    ///   Tag Handler interface methods.                         ///
    ///                                                          ///
    ///   Do not modify these methods; instead, modify the       ///
    ///   methods that they call.                                ///
    ///                                                          ///
    ////////////////////////////////////////////////////////////////
    /**
     * This method is called when the JSP engine encounters the start tag, after
     * the attributes are processed. Scripting variables (if any) have their
     * values set here.
     *
     * @return EVAL_BODY_BUFFERED if the JSP engine should evaluate the tag
     * body, otherwise return SKIP_BODY. This method is automatically generated.
     * Do not modify this method. Instead, modify the methods that this method
     * calls.
     */
    @Override
    public int doStartTag() throws JspException {
        otherDoStartTagOperations();
        
        if (theBodyShouldBeEvaluated()) {
            return EVAL_BODY_BUFFERED;
        } else {
            return SKIP_BODY;
        }
    }

    /**
     * This method is called after the JSP engine finished processing the tag.
     *
     * @return EVAL_PAGE if the JSP engine should continue evaluating the JSP
     * page, otherwise return SKIP_PAGE. This method is automatically generated.
     * Do not modify this method. Instead, modify the methods that this method
     * calls.
     */
    @Override
    public int doEndTag() throws JspException {
        otherDoEndTagOperations();
        
        if (shouldEvaluateRestOfPageAfterEndTag()) {
            return EVAL_PAGE;
        } else {
            return SKIP_PAGE;
        }
    }

    /**
     * This method is called after the JSP engine processes the body content of
     * the tag.
     *
     * @return EVAL_BODY_AGAIN if the JSP engine should evaluate the tag body
     * again, otherwise return SKIP_BODY. This method is automatically
     * generated. Do not modify this method. Instead, modify the methods that
     * this method calls.
     */
    @Override
    public int doAfterBody() throws JspException {
        try {
            // This code is generated for tags whose bodyContent is "JSP"
            BodyContent bodyCont = getBodyContent();
            JspWriter out = bodyCont.getEnclosingWriter();
            
            writeTagBodyContent(out, bodyCont);
        } catch (Exception ex) {
            handleBodyContentException(ex);
        }
        
        if (theBodyShouldBeEvaluatedAgain()) {
            return EVAL_BODY_AGAIN;
        } else {
            return SKIP_BODY;
        }
    }

    /**
     * Handles exception from processing the body content.
     */
    private void handleBodyContentException(Exception ex) throws JspException {
        // Since the doAfterBody method is guarded, place exception handing code here.
        throw new JspException("Error in vitrineTagHandler tag", ex);
    }

    /**
     * Fill in this method to determine if the rest of the JSP page should be
     * generated after this tag is finished. Called from doEndTag().
     */
    private boolean shouldEvaluateRestOfPageAfterEndTag() {
        // TODO: code that determines whether the rest of the page
        //       should be evaluated after the tag is processed
        //       should be placed here.
        //       Called from the doEndTag() method.
        //
        return true;
    }

    /**
     * Fill in this method to determine if the tag body should be evaluated
     * again after evaluating the body. Use this method to create an iterating
     * tag. Called from doAfterBody().
     */
    private boolean theBodyShouldBeEvaluatedAgain() {
        // TODO: code that determines whether the tag body should be
        //       evaluated again after processing the tag
        //       should be placed here.
        //       You can use this method to create iterating tags.
        //       Called from the doAfterBody() method.
        //
        return false;
    }

    private boolean theBodyShouldBeEvaluated() {
        // TODO: code that determines whether the body should be
        //       evaluated should be placed here.
        //       Called from the doStartTag() method.
        return true;
    }

    private DataSource getOmniBase() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/omniBase");
    }
    
}
