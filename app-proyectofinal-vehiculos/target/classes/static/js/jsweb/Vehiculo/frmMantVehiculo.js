
$(document).on("click", "#btnagregaravehiculo", function() {
	$("#txtplaca").val("");
	$("#txtpartida").val("");
	$("#cboidtipovehiculo").val("0");
	$("#hddidvehiculo").val("0");
	$("#modalvehiculo").modal("show");
});

$(document).on("click", ".btnactualizarvehiculo", function() {
	$("#txtplaca").val($(this).attr("data-placavehiculo"));
	$("#txtpartida").val($(this).attr("data-partidaregistralvehiculo"));
	$("#cboidtipovehiculo").val($(this).attr("data-idtipovehiculo"));
	$("#hddidvehiculo").val($(this).attr("data-idvehiculo"));
	$("#modalvehiculo").modal("show");
});

$(document).on("click", ".btneliminarvehiculo", function(){
	$("#hddidvehiculoeliminar").val("0");
	$("#mensajeeliminar").text("¿Está seguro de eliminar el Vehiculo de placa: "+ $(this).attr("data-placavehiculo")+" ?");
	$("#hddidvehiculoeliminar").val($(this).attr("data-idvehiculo"));
	
	$("#modalvehiculoeliminar").modal("show");
});

$(document).on("click", "#btnregistrarvehiculo", function() {
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/Vehiculo/registrarVehiculo',
		data: JSON.stringify({
			idvehiculo: $("#hddidvehiculo").val(),
			placavehiculo: $("#txtplaca").val(),
			partidaregistralvehiculo: $("#txtpartida").val(),
			idtipovehiculo: $("#cboidtipovehiculo").val()
		}),
		success: function(resultado) {
			if (resultado.respuesta) {
				alert(resultado.mensaje);
                ListarVehiculo()
			}
			else {
				alert(resultado.mensaje);
			}
		}
	});
	$("#modalvehiculo").modal("hide");
});

$(document).on("click", "#btneliminaridvehiculo", function() {
	$.ajax({
		type: 'DELETE',
		contentType: 'application/json',
		url: '/Vehiculo/eliminarVehiculo',
		data: JSON.stringify({
			idvehiculo: $("#hddidvehiculoeliminar").val()
		}),
		success: function(resultado) {
			if (resultado.respuesta) {
				alert(resultado.mensaje);
                ListarVehiculo()
			}
			else {
				alert(resultado.mensaje);
			}
		}
	});
	$("#modalvehiculoeliminar").modal("hide");
});

function ListarVehiculo(){
	$.ajax({
		type: 'GET',
		url: '/Vehiculo/listarVehiculo',
		dataType: 'json',
		success: function(resultado){
			$("#tblvehiculo > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblvehiculo > tbody").append(`
                <tr>
                    <td>${value.idvehiculo}</td>
                    <td>${value.placavehiculo}</td>
                    <td>${value.partidaregistralvehiculo}</td>
                    <td>${value.clasecategoriavehiculo}</td>
                    <td>
                        <button type="button" class="btn btn-dark btnactualizarvehiculo"
                            data-idvehiculo="${value.idvehiculo}"
                            data-placavehiculo="${value.placavehiculo}"
                            data-partidaregistralvehiculo="${value.partidaregistralvehiculo}"
                            data-idtipovehiculo="${value.idtipovehiculo}">
                            Actualizar</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger	btneliminarvehiculo"
                            data-idvehiculo="${value.idvehiculo}"
                            data-placavehiculo="${value.placavehiculo}">Eliminar</button>
                    </td>
                </tr>
                `)
			});
		}		
	});	
}










