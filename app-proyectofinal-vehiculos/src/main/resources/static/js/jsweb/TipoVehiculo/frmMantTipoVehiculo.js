
$(document).on("click", "#btnagregaratipovehiculo", function(){
	$("#hddidtipovehiculo").val("0");
	$("#txtclase").val("");
	$("#txtdescripcion").val("");
	
	$("#modaltipovehiculo").modal("show");
});

$(document).on("click", ".btnactualizartipovehiculo", function(){

    $("#hddidtipovehiculo").val($(this).attr("data-idtipovehiculo"));
    $("#txtclase").val($(this).attr("data-clasecategoriavehiculo"));
    $("#txtdescripcion").val($(this).attr("data-descripcioncategoriavehiculo"));
	
	$("#modaltipovehiculo").modal("show");

});


$(document).on("click", ".btneliminartipovehiculo", function(){
	$("#hddidtipovehiculoeliminar").val("0");
	$("#mensajeeliminar").text("¿Está seguro de eliminar el Tipo de Vehiculo: "+ $(this).attr("data-clasecategoriavehiculo")+" ?");
	$("#hddidtipovehiculoeliminar").val($(this).attr("data-idtipovehiculo"));
	
	$("#modaleliminartipovehiculo").modal("show");
});


$(document).on("click", "#btnregistrartipovehiculo", function(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/TipoVehiculo/registrarTipoVehiculo',
		data: JSON.stringify({
            idtipovehiculo: $("#hddidtipovehiculo").val(),
            clasecategoriavehiculo: $("#txtclase").val(),
            descripcioncategoriavehiculo: $("#txtdescripcion").val()
           
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarTipoVehiculo()
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modaltipovehiculo").modal("hide");
});

$(document).on("click", "#btneliminaridtipovehiculo", function(){
	$.ajax({
		type: 'DELETE',
		contentType: 'application/json',
		url: '/TipoVehiculo/eliminarTipoVehiculo',
		data: JSON.stringify({
			idtipovehiculo: $("#hddidtipovehiculoeliminar").val()
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarTipoVehiculo()
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modaleliminartipovehiculo").modal("hide");
});

function ListarTipoVehiculo(){
	$.ajax({
		type: 'GET',
		url: '/TipoVehiculo/listarTipoVehiculo',
		dataType: 'json',
		success: function(resultado){
			$("#tbltipovehiculo > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tbltipovehiculo > tbody").append(`
                <tr>
                <td>${value.idtipovehiculo}</td>
                <td>${value.clasecategoriavehiculo}</td>
                <td>${value.descripcioncategoriavehiculo}</td>
                <td>
                    <button type="button" class="btn btn-dark btnactualizartipovehiculo"
                        data-idtipovehiculo="${value.idtipovehiculo}"
                        data-clasecategoriavehiculo="${value.clasecategoriavehiculo}"
                        data-descripcioncategoriavehiculo="${value.descripcioncategoriavehiculo}">
                        Actualizar</button>
                </td>
                <td>
                    <button type="button" class="btn btn-danger	btneliminartipovehiculo"
                        data-idtipovehiculo="${value.idtipovehiculo}"
                        data-clasecategoriavehiculo="${value.clasecategoriavehiculo}">Eliminar</button>
                </td>
            </tr>
                `)
			});
		}		
	});	
}