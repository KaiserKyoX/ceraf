<!DOCTYPE html>

<%@page import="Modelo.ModeloTipoEspacio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
	<meta charset="utf-8" />
	<title>Nuevo Espacio</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="blurBg-false" style="background-color:#EBEBEB">



<!-- Start Formoid form-->
<link rel="stylesheet" href="nuevoespacio_files/formoid1/formoid-solid-blue.css" type="text/css" />


<script type="text/javascript" src="nuevoespacio_files/formoid1/jquery.min.js"></script>
<form action="/ProyectoFinal/nuevoEspacio" class="formoid-solid-blue" style="background-color:#FFFFFF;font-size:14px;font-family:'Roboto',Arial,Helvetica,sans-serif;color:#34495E;max-width:480px;min-width:150px" method="post"><div class="title"><h2>Nuevo Espacio</h2></div>
    
        <% 
            ArrayList<ModeloTipoEspacio> list = (ArrayList<ModeloTipoEspacio>) request.getAttribute("list");
    %>
    

    
    <div class="element-multiple"><label class="title"></label><div class="item-cont"><div class="large"><select data-no-selected="Nothing selected" name="elemento" multiple="multiple" >

                       <%  for(int i = 0; i < list.size(); i++) {
           String option = list.get(i).getNombre();
   %>
   <option value="<%= i+1 %>"><%= option %></option>
   <% } %>
               
                </select>
                
                
                <span class="icon-place"></span></div></div></div>
	<div class="element-number"><label class="title"></label><div class="item-cont"><input class="large" type="text" min="0" max="100" name="number" placeholder="Numero de Sillas" value=""/><span class="icon-place"></span></div></div>
	<div class="element-checkbox"><label class="title">Videbeam</label>		<div class="column column1"><label><input type="checkbox" name="Videobeam" value="Si"/ ><span>Si</span></label><label><input type="checkbox" name="Videobeam" value="No"/ ><span>No</span></label></div><span class="clearfix"></span>
</div>
	<div class="element-input"><label class="title"></label><div class="item-cont"><input class="large" type="text" name="direccion" placeholder="Direccion"/><span class="icon-place"></span></div></div>
	<div class="element-textarea"><label class="title"></label><div class="item-cont"><textarea class="medium" name="caracteristicas" cols="20" rows="5" placeholder="Caracteristicas"></textarea><span class="icon-place"></span></div></div>
<div class="submit"><input type="submit" value="Submit"/></div></form><script type="text/javascript" src="nuevoespacio_files/formoid1/formoid-solid-blue.js"></script>
<!-- Stop Formoid form-->



</body>
</html>
