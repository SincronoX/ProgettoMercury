
function controllo(){
	var pref1=document.getElementById("idPreferenza1").checked;
	var pref2=document.getElementById("idPreferenza2").checked;
	var pref3=document.getElementById("idPreferenza3").checked;
	var pref4=document.getElementById("idPreferenza4").checked;
	var pref5=document.getElementById("idPreferenza5").checked;
	if(pref1||pref2||pref3||pref4||pref5)
		return true;
	else
	{
		alert("selezionare almeno una preferenza");
		return false;
	}
};


$(document).ready(function() {
	$("#regioni").change(
			function(event) {
				var regione = $("select#regioni").val();
				$.get("../ServletLuogo", {
					idRegione : regione
				}, function(response) {
					var select = $("#province");
					select.find("option").remove();
					$.each(response, function(index, obj) {
						$("<option>").val(obj.idProvincia).text(obj.nomeProvincia).appendTo(select);
					});
					$("<option>").text("Selezionare").prependTo(select).attr("selected","selected");
					$("#comuni").find("option").remove();
				});
			});
});



$(document).ready(function() {
	$("#province").change(
			function(event) {
				var provincia = $("select#province").val();
				$.get("../ServletLuogo", {
					idProvincia : provincia
				}, function(response) {
					var select = $("#comuni");
					select.find("option").remove();
					$.each(response, function(index, obj) {
						$("<option>").val(obj.idComune).text(obj.nomeComune).appendTo(select);
					});
					$("<option>").text("Selezionare").prependTo(select).attr("selected","selected");
				});
			});
});
