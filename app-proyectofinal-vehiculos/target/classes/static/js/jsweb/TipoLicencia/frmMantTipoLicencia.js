
$(document).on("click", "#btnagregaratipolicencia", function(){
	$("#hddidtipolicencia").val("0");
	$("#txtclase").val("");
	$("#txtcategoria").val("");
	
	$("#modaltipolicencia").modal("show");
});

$(document).on("click", ".btnactualizartipolicencia", function(){

    $("#hddidtipolicencia").val($(this).attr("data-idtipolicencia"));
    $("#txtclase").val($(this).attr("data-claselicencia"));
    $("#txtcategoria").val($(this).attr("data-categorialicencia"));
	
	$("#modaltipolicencia").modal("show");

});


$(document).on("click", ".btneliminartipolicencia", function(){
	$("#hddidtipolicenciaeliminar").val("0");
	$("#mensajeeliminar").text("¿Está seguro de eliminar el Tipo de Licencia: "+ $(this).attr("data-claselicencia")+" ?");
	$("#hddidtipolicenciaeliminar").val($(this).attr("data-idtipolicencia"));
	
	$("#modaleliminartipolicencia").modal("show");
});


$(document).on("click", "#btnregistrartipolicencia", function(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/TipoLicencia/registrarTipoLicencia',
		data: JSON.stringify({
            idtipolicencia: $("#hddidtipolicencia").val(),
            claselicencia: $("#txtclase").val(),
            categorialicencia: $("#txtcategoria").val()
           
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarTipoLicencia()
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modaltipolicencia").modal("hide");
});

$(document).on("click", "#btneliminaridtipolicencia", function(){
	$.ajax({
		type: 'DELETE',
		contentType: 'application/json',
		url: '/TipoLicencia/eliminarTipoLicencia',
		data: JSON.stringify({
			idtipolicencia: $("#hddidtipolicenciaeliminar").val()
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarTipoLicencia()
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modaleliminartipolicencia").modal("hide");
});

function ListarTipoLicencia(){
	$.ajax({
		type: 'GET',
		url: '/TipoLicencia/listarTipoLicencia',
		dataType: 'json',
		success: function(resultado){
			$("#tbltipolicencia > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tbltipolicencia > tbody").append(`
                <tr>
                <td>${value.idtipolicencia}</td>
							<td>${value.claselicencia}</td>
							<td>${value.categorialicencia}</td>
							<td>
								<button type="button" class="btn btn-dark btnactualizartipolicencia"
									data-idtipolicencia="${value.idtipolicencia}"
									data-claselicencia="${value.claselicencia}"
									data-categorialicencia="${value.categorialicencia}">
									Actualizar</button>
							</td>
							<td>
								<button type="button" class="btn btn-danger	btneliminartipolicencia"
									data-idtipolicencia="${value.idtipolicencia}"
									data-claselicencia="${value.claselicencia}">Eliminar</button>
							</td>
            </tr>
                `)
			});
		}		
	});	
}