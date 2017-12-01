<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--COLLEGAMENTO AL CSS BOOTSTRAP-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../Style.css">
<!-- Fine collegamento css bootstrap -->

<title>Insert title here</title>
</head>
<body>

<div class="container"> <!--INIZIO CLASSE CONTAINER-->
<div class="row"><!--INIZIO CLASSE ROW-->

		
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <img class="fotoMercury" src="mercury.png">
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Newsletter</a></li>
        <li><a href="#">Eventi</a></li>
        <li><a href="#">Chi Siamo</a></li>
        <li><a href="#">Area Riservata</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


	<!--inizio siderbar-->
	<div class="siderbar">
		<h2 class="benvenuto"><center> Benevenuti in Mercury</center></h2>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh 
		euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
	</div>
	<!--Fine siderbar -->


	<!-- inizio campi ricerca -->
	
	<div class="col-md-3" id="post">

	<h3>Ricerca Evento</h3>
	<br>
	<div>
    <span id="campiricerca">
	
			<label class="selRicerca">Regione
				<input type="" name="regione" placeholder="Scegli Regione">
			</label>
	</span>
	<br>
	<br>
	<span id="campiricerca">	
		
			<label class="selRicerca">Provincia
				<input type="" name="provincia" placeholder="Scegli Provincia">
			</label>
		
	</span>
	<br>
	<br>
	<span id="campiricerca">
		
			<label class="selRicerca">Comune
				<input type="" name="comune" placeholder="Scegli comune">
			</label>
			<input type="date" name="data">
	</span>
	<br>
	<br>
	<span id="campiricerca">
		<p class="selRicerca">TipoEvento </p>
		
		<form class="selRicerca">
		  <input type="checkbox" name="tipo1" value="Teatro">Teatro</option>
		  <input  type="checkbox" name="tipo2" value="Concerto">Concerto</option>
		  <input  type="checkbox" name="tipo3" value="Film">Film</option>
		  <input  type="checkbox" name="tipo4" value="Mostra">Mostra</option>
		</form> 
		<br>
		<br>
		<button type="submit" class="selRicerca">Invia</button>	
	</span>
	</div>
	
	<!-- fine campi ricerca -->
	</div><!-- chiusura div class post -->


	<!--inzio ultimi eventi -->
	<div id="eventiHome" class="col-md-8">
		<form class="testoEventi">
			<h2>Ultimi eventi</h2>
			<p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur? At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere

			</p>
		</form>
	</div>

	
	<!-- fine ultimi eventi-->

	</div><!-- FINE CLASS CONTAINER-->
	</div><!--FINE CLASSE RAW-->






</body>
 <!--INIZO SCRIPT BOOTSTRAP -->
 	<script type="text/javascript" src="app.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP -->	
   

</html>
