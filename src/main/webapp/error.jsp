<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="omni"
          uri="/WEB-INF/tlds/OmniTagLibrary.tld" %>

<omni:OmniHandler bootStrapStyle="omni-template"
                 pageHandlerName="com.mseefelder.omnistore.mainPageHandler">

    <div id="divmiolo_1" class="divmiolo">
        <font size="5" style="font-weight:bolder;">ERRO</font>
        <br>
        <br>
        ${CONTROLLER_EXCEPTION}
    </div>
</omni:OmniHandler>
