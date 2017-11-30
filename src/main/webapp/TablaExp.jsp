<%-- 
    Document   : TablaExp
    Created on : 28/10/2017, 06:27:56 PM
    Author     : mnieto
--%>

<%@page import="Dao.DaoRegistro"%>
<%@page import="Modelo.registro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="Style/js/jquery-3.2.0.js" type="text/javascript"></script>
        <script src="Style/js/semantic.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Style/css/semantic.css">
        <link rel="stylesheet" href="Style/css/semantic.min.css">


        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<registro> col= (ArrayList<registro>) request.getAttribute("registros");
            Integer vtotal = (Integer) request.getAttribute("total");
            int total = 0;
            if (vtotal == null) {
                total = 0;
            } else {
                total = vtotal.intValue();
            }

        %>


        <form method="GET" action="ServletConsultas" name="frr">
            <font color="white"><h2>REGISTRO PRODUCCION</h2></font>
            <br>

            <table  width="400" border="2" align="center">
                <caption align="top">
                </caption>
                <tr>
                    <th width="84" scope="col"><strong><font >Id Colmena Hija</font></strong></th>
                    <th width="84" scope="col"><strong><font >Id Colmena Madre</font></strong></th>
                    <th width="84" scope="col"><strong><font >Ubicacion</font></strong></th>
                    <th width="84" scope="col"><strong><font >Id Fabrica</font></strong></th>
                    <th width="84" scope="col"><strong><font >Kilos Producidos</font></strong></th>

                </tr>
                <%    if (request.getAttribute("registros") != null) {
                        ArrayList<registro> esqq = (ArrayList<registro>) request.getAttribute("registros");
                                      
                                       
                        for (registro e : esqq) {
                                            
                                        
                %>
                <tr>
                    <td><%= e.getIdColmenaH()%></td>
                    <td><%= e.getIdColmena() %></td>
                    <td><%= e.getUbicacion() %></td>
                    <td><%= e.getIdFabrica() %></td>
                    <td><%=e.getSumaKilos()%></td>
                    
                </tr>
                <%
                        }
                    }
                %>
            </table>
            <input type="submit" VALUE ="HISTORIAL"/><br/>  

        </form>
        <h1>Consultas</h1>
    </body>
</html>
