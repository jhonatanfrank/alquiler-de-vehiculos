//Creando eventos con JQuery
$(document).on("click", "#btnagregaralumno", function(){
	//alert("Hola Jquery");
	$("#txtnomalumno").val("");
	$("#txtapealumno").val("");
	$("#txtprocedencia").val("");
	$("#cboespecialidad").val("0");	
	$("#hddidalumno").val("0");
	$("#modalalumno").modal("show");
});

$(document).on("click", ".btnactualizaralumno", function(){
	//alert("Hola Jquery");
	$("#txtnomalumno").val($(this).attr("data-nomalumno"));
	$("#txtapealumno").val($(this).attr("data-apealumno"));
	$("#txtprocedencia").val($(this).attr("data-proce"));
	$("#cboespecialidad").val($(this).attr("data-idesp"));	
	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#modalalumno").modal("show");
});

$(document).on("click", ".btneliminaralumno", function(){
	$("#hddidalumnoeliminar").val("0");
	$("#mensajeeliminar").text("¿Está seguro de eliminar al alumno: "+
			$(this).attr("data-nomalumno")+" ?");
	$("#hddidalumnoeliminar").val($(this).attr("data-codalumno"));
	$("#modaleliminaralumno").modal("show");
});

$(document).on("click", "#btnregistraralumno", function(){
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/Alumno/registrarAlumno',
		data: JSON.stringify({
			idalumno: $("#hddidalumno").val(),
			nomalumno: $("#txtnomalumno").val(),
			apealumno: $("#txtapealumno").val(),
			idesp: $("#cboespecialidad").val(),
			proce: $("#txtprocedencia").val()
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarAlumnos();
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modalalumno").modal("hide");
});

$(document).on("click", "#btneliminaralumno", function(){
	$.ajax({
		type: 'DELETE',
		contentType: 'application/json',
		url: '/Alumno/eliminarAlumno',
		data: JSON.stringify({
			idalumno: $("#hddidalumnoeliminar").val()
		}),
		success: function(resultado){
			if(resultado.respuesta){
				alert(resultado.mensaje);
				ListarAlumnos();
			}else{
				alert(resultado.mensaje);
			}
		}		
	});
	$("#modaleliminaralumno").modal("hide");
});

function ListarAlumnos(){
	$.ajax({
		type: 'GET',
		url: '/Alumno/listarAlumno',
		dataType: 'json',
		success: function(resultado){
			$("#tblalumno > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblalumno > tbody").append("<tr>"+
				"<th>"+value.idalumno+"</th>"+
				"<td>"+value.nomalumno+"</td>"+
				"<td>"+value.apealumno+"</td>"+
				"<td>"+value.nomesp+"</td>"+
				"<td><button type='button' class='btn btn-success btnactualizaralumno'"+
				" data-codalumno='"+value.idalumno+"'"+
				" data-nomalumno='"+value.nomalumno+"'"+
				" data-apealumno='"+value.apealumno+"'"+
				" data-idesp='"+value.idesp+"'"+
				" data-proce='"+value.proce+"'>Actualizar</button></td>"+
				"<td><button type='button' class='btn btn-danger btneliminaralumno'"+
				" data-codalumno='"+value.idalumno+"'"+
				" data-nomalumno='"+value.nomalumno+"'>Eliminar</button></td>"+					
				"</tr>")
			});
		}		
	});	
}
