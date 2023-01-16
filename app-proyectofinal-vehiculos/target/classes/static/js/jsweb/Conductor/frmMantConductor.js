

$(document).on("click", "#btnAgregarConductor", function(){
	$("#hddidconductor").val("0");
	$("#txtdni").val("");
	$("#txtnombre").val("");
	$("#txtapellido").val("");
	$("#txtdireccion").val("");
	$("#txttelefono").val("");
	$("#cbosexo").val("N");
	$("#txtdistrito").val("");
	$("#cbotipolicencia").val("0");	
	$("#cbotipovehiculo").val("0");	
	$("#cboestado").val("-1");	
	
	$("#modalConductor").modal("show");
});

$(document).on("click", ".btnactualizarconductor", function(){

    $("#hddidconductor").val($(this).attr("data-id"));
	$("#txtdni").val($(this).attr("data-dni"));
	$("#txtnombre").val($(this).attr("data-nombre"));
	$("#txtapellido").val($(this).attr("data-apellido"));
	$("#txtdireccion").val($(this).attr("data-direccion"));
	$("#txttelefono").val($(this).attr("data-telefono"));
	$("#cbosexo").val($(this).attr("data-sexo"));
	$("#txtdistrito").val($(this).attr("data-distrito"));
	$("#cbotipolicencia").val($(this).attr("data-idtipolicencia"));	
	$("#cbotipovehiculo").val($(this).attr("data-idvehiculo"));	
	$("#cboestado").val($(this).attr("data-estado"));	
	
	$("#modalConductor").modal("show");

});


$(document).on("click", ".btneliminarconductor", function(){
	$("#hddidconductoreliminar").val("0");
	$("#mensajeeliminar").text("¿Está seguro de eliminar el Conductor: "+ $(this).attr("data-nombre")+" ?");
	$("#hddidconductoreliminar").val($(this).attr("data-idconductor"));
	
	$("#modaleliminarconductor").modal("show");
});


$(document).on("click", "#btnregistrarconductor", function(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/Conductor/registrarConductor',
		data: JSON.stringify({
            idconductor: $("#hddidconductor").val(),
            dniconductor: $("#txtdni").val(),
            nombreconductor: $("#txtnombre").val(),
            apellidoconductor: $("#txtapellido").val(),
            direccionconductor: $("#txtdireccion").val(),
            telefonoconductor: $("#txttelefono").val(),
            sexoconductor: $("#cbosexo").val(),
            distritoconductor: $("#txtdistrito").val(),
            estadoconductor: $("#cboestado").val(),
            idtipolicencia: $("#cbotipolicencia").val(),	
            idvehiculo: $("#cbotipovehiculo").val()	
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarConductor();
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modalConductor").modal("hide");
});

$(document).on("click", "#btneliminarconductor", function(){
	$.ajax({
		type: 'DELETE',
		contentType: 'application/json',
		url: '/Conductor/eliminarConductor',
		data: JSON.stringify({
			idconductor: $("#hddidconductoreliminar").val()
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarConductor();
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modaleliminarconductor").modal("hide");
});

function ListarConductor(){
	$.ajax({
		type: 'GET',
		url: '/Conductor/listarConductor',
		dataType: 'json',
		success: function(resultado){
			$("#tblConductor > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblConductor > tbody").append(`
					<tr>
						<th>${value.idconductor}</th>
						<td>${value.dniconductor}</td>
						<td>${value.nombreconductor}</td>
						<td>${value.apellidoconductor}</td>
						<td>${value.direccionconductor}</td>
						<td>${value.telefonoconductor}</td>
						<td>${(value.sexoconductor == 'M') ? 'Masculino': 'Femenino' }</td>
						<td>${value.distritoconductor}</td>
						<td>${value.claselicencia}</td>
						<td>${value.placavehiculo}</td>
						<td>${(value.estadoconductor == 1 ? 'Activo' :  'Inactivo')}</td>
						<td>
							<button type="button" class="btn btn-success btnactualizarconductor"
								data-id="${value.idconductor}"
								data-dni="${value.dniconductor}"
								data-nombre="${value.nombreconductor}"
								data-apellido="${value.apellidoconductor}"
								data-direccion="${value.direccionconductor}"
								data-telefono="${value.telefonoconductor}"
								data-sexo="${value.sexoconductor}"
								data-distrito="${value.distritoconductor}"
								data-idtipolicencia="${value.idtipolicencia}"
								data-idvehiculo="${value.idvehiculo}"
								data-estado="${value.estadoconductor}"
								>
								Actualizar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger btneliminarconductor"
								data-idconductor="${value.idconductor}"
								data-nombre="${value.nombreconductor}">Eliminar</button>
						</td>
					</tr>
				
				
				`)
			});
		}		
	});	
}