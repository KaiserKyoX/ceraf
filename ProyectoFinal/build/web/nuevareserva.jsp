<%-- 
    Document   : nuevareserva
    Created on : 21/07/2015, 03:11:46 PM
    Author     : cclavijo
--%>

<%@page import="Modelo.ModeloEspacios"%>
<%@page import="Modelo.ModeloTipoEspacio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>Sistema de Reservas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="blurBg-false" style="background-color:#EBEBEB">



<!-- Start Formoid form-->
<link rel="stylesheet" href="reservaconfirmacion_files/formoid1/formoid-solid-blue.css" type="text/css" />
<script type="text/javascript" src="reservaconfirmacion_files/formoid1/jquery.min.js"></script>
<form action="/ProyectoFinal/CreaReserva" class="formoid-solid-blue" style="background-color:#FFFFFF;font-size:14px;font-family:'Roboto',Arial,Helvetica,sans-serif;color:#34495E;max-width:480px;min-width:150px"  method="post"><div class="title"><h2>Sistema de Reservas</h2></div>
    
    <% 
            ArrayList<ModeloEspacios> list = (ArrayList<ModeloEspacios>) request.getAttribute("list");
    %>
    

    
    <div class="element-multiple"><label class="title"></label><div class="item-cont"><div class="large"><select data-no-selected="Nothing selected" name="elemento" multiple="multiple" >

                       <%  for(int i = 0; i < list.size(); i++) {
           String option = list.get(i).getDireccion();
   %>
   <option value="<%= i+1 %>"><%= option %></option>
   <% } %>
               
                </select>
                
                
                <span class="icon-place"></span></div></div></div>
    
    <label class="title"><h4>Fecha Inicial</h4></label>
    
	<label class="title"></label><div class="item-cont"><input class="large" data-format="yyyy-mm-dd" type="date" name="fechainicial" placeholder="Fecha de Reserva"/><span class="icon-place"></span></div>
    
    <label class="title"></label><div class="item-cont"><input type="time" class="large" name="horainicial"><span class="icon-place"></span></div>
    
    
    <label class="title"><h4>Fecha Final</h4></label>
    <label class="title"></label><div class="item-cont"><input class="large" data-format="yyyy-mm-dd" type="date" name="fechafinal" placeholder="Fecha de Reserva"/><span class="icon-place"></span></div>
    
     <label class="title"></label><div class="item-cont"><input type="time" class="large" name="horafinal"><span class="icon-place"></span></div>
    
    
    
	<div class="element-textarea"><label class="title"></label><div class="item-cont"><textarea class="medium" name="comentarios" cols="20" rows="5" placeholder="Justificacion de la Reserva"></textarea><span class="icon-place"></span></div></div>
    
	<div class="element-phone"><label class="title"></label><div class="item-cont"><input class="large" type="tel" pattern="[+]?[\.\s\-\(\)\*\#0-9]{3,}" maxlength="24" name="phone" placeholder="Ingrese su Telefono" value=""/><span class="icon-place"></span></div></div>
    
    
    
<div class="submit"><input type="submit" value="Submit"/></div></form>
<!-- Stop Formoid form-->



</body>
</html>
