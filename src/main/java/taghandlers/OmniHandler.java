/*
 * Handles outer tag.
 */
package taghandlers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.sql.DataSource;

/**
 *
 * @author mseefelder
 */
public class OmniHandler extends BodyTagSupport {    
    private String pageName;
    private String pageHandlerName;

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public void setPageHandlerName(String pageHandlerName) {
        this.pageHandlerName = pageHandlerName;
    }
    
    /**
     * Creates new instance of tag handler
     */
    public OmniHandler() {
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
"<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n" +
"    <meta name=\"description\" content=\"\">\n" +
"    <meta name=\"author\" content=\"\">\n" +
"\n" +
"    <title>"+pageName+"</title>\n" +
"\n" +
"    <!-- Bootstrap core CSS -->\n" +
"    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"\n" +
"    <!-- Custom styles for this template -->\n" +
"    <link href=\"css/dashboard.css\" rel=\"stylesheet\">\n" +
"    </head>"
            );
        } catch (IOException ex) {
            // do something
        }
    }

    /**
     * Method called from doEndTag() Fill in this method to perform other
     * operations from doEndTag().
     */
    private void otherDoEndTagOperations() {
        try {
            JspWriter out = pageContext.getOut();
            out.println("</html>");
        } catch (IOException ex) {
            // do something
        }
    }

    /**
     * Fill in this method to process the body content of the tag. You only need
     * to do this if the tag's BodyContent property is set to "JSP" or
     * "tagdependent." If the tag's bodyContent is set to "empty," then this
     * method will not be called.
     */
    private void writeTagBodyContent(JspWriter out, BodyContent bodyContent) throws IOException, NamingException, SQLException {
       
        //Generate sidebar's buttongroup code
        String buttonGroup = buildButtons();
        
        // get the body content as a string and process it, e.g.:
        String bodyStr = bodyContent.getString();
        String result = bodyStr.replace(
"<body>", "<body>\n" +
"      <form method=\"GET\" action=\"Controller\">\n" +
"          <input type=\"hidden\" name=\"pageHandlerName\" value=\""+pageHandlerName+"\">\n" +
"    <nav class=\"navbar navbar-fixed-top\">\n" +
"      <div class=\"container-fluid\">\n" +
"        <div class=\"navbar-header\">\n" +
"          <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n" +
"            <span class=\"sr-only\">Toggle navigation</span>\n" +
"            <span class=\"icon-bar\"></span>\n" +
"            <span class=\"icon-bar\"></span>\n" +
"            <span class=\"icon-bar\"></span>\n" +
"          </button>\n" +
"          <a class=\"navbar-brand\" href=\"#\">A Forja do Alquimista</a>\n" +        
"        </div>\n" +
"      </div>\n" +
"    </nav>"+
"\n" +
"        \n" +
"    <div class=\"container\">\n" +
"      <div class=\"row\">\n" +
"        <div class=\"col-md-2 col-xs-3 col-sm-4 sidebar\">\n" +
buttonGroup +
"<p href=\"#\" style=\"color:white;\" >\n Feito por: Marcos Seefelder de Assis Araujo</p>\n" +
"<p href=\"#\" style=\"color:white;\" >Créditos:"+
" <a href=\"https://www.flickr.com/photos/filterforge/14410927724\" >[1]</a> "+
" <a href=\"https://www.flickr.com/photos/filterforge/9599276116/\">[2]</a> </p>\n" +
"        </div>"
        );
        
        result = result.replace("</body>", 
""+
"<script language=\"javascript\">\n" +
"    function setHidden(whichButton)\n" +
"    {\n" +
"        var element = document.getElementById(\"Which\");\n" +
"        element.value = whichButton;\n" +
"        return true;\n" +
"    }\n" +
"</script>"+
"</div>\n" +
"    </div>\n" +
"    </form>" +
"\n" +
"    <!-- Bootstrap core JavaScript\n" +
"    ================================================== -->\n" +
"    <!-- Placed at the end of the document so the pages load faster -->\n" +
"    <script src=\"js/jquery.min.js\"></script>\n" +
"    <script src=\"js/bootstrap.min.js\"></script>\n" +
"    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n" +
"    <script src=\"js/ie10-viewport-bug-workaround.js\"></script>\n" +
"  </body>"
        );
        out.println(result);
        
        // clear the body content for the next time through.
        bodyContent.clearBody();
    }
    
    public String buildButtons() throws NamingException, SQLException
    {
        String buttonBar = "";
        
        DataSource ds = getOmniBase();
        Connection connection = ds.getConnection();
 
        if (connection == null)
        {
            throw new SQLException("Error establishing connection!");
        }
        String query = "SELECT name FROM category";
        
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();
        
        buttonBar = "<button type=\"submit\" class=\"btn btn-default\" name=\"category\" value=\""+
                    ""+
                    "\" style=\"width:100%;\">"+"Principal"+"</button> \n";
        
        String tempName = null;
        
        while (rs.next())
        {
            tempName = rs.getString("name");
            buttonBar = buttonBar +
                    "<button type=\"submit\" class=\"btn btn-default\" name=\"category\" value=\""+
                    tempName+
                    "\" style=\"width:100%;\">"+tempName+"</button> \n";
        }
        
        connection.close();
        
        return buttonBar;
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
        throw new JspException("Error in OmniHandler tag", ex);
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
