<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!--COLLEGAMENTO AL CSS BOOTSTRAP-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="..//css/Style.css">
<!-- Fine collegamento css bootstrap -->
<sql:query var="concerto" dataSource="jdbc/mercury">
<!--select eventoPrevisto.nomeEvento,eventoPrevisto.dataInizio,eventoPrev from eventoPrevisto where idTipoEvento=2-->
</sql:query>

<title>HOME PAGE</title>
</head>
<body>
<div id="sfondo"></div> 

	<div class="container"> <!--INIZIO CLASSE CONTAINER-->
	<div class="row"><!--INIZIO CLASSE ROW-->
					
	  <nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	  
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <img id="fotoMercury" src="../img/nuovoLogo1.png">
	    </div>

	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active" id="navbar"><a href="#">Home <span class="sr-only">(current)</span></a></li>
	        <li><a id="navbar">Newsletter</a></li>
	        <li><a id="navbar">Eventi</a></li>
	        <li><a id="navbar">Chi Siamo</a></li>
	        <li><a id="navbar">Area Riservata</a></li>
	        
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>



		<!--inizio siderbar-->
		<div class="col-md-3"></div>
		<div id="sidebar" class="col-md-6">
			<h2 class="benvenuto">Benevenuti in Mercury</h2>
			<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh 
			euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
		</div>
		<!--Fine siderbar -->
		

		<!--inzio ultimi eventi -->
		<div id="eventiHome" class="col-md-8">
			<form>

				<div class="panel panel-info">
				  <h3 class="titoloEvento">ciao</h3>
				  <hr class="panel panel-info">
				  <p class="testoEventi"> Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
				</div>

				<div class="panel panel-info">
				  <h3 class="titoloEvento">Film</h3>
				  <hr class="panel panel-info">
				  <p class="testoEventi">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
				</div>

				<div class="panel panel-info">
				  <h3 class="titoloEvento">Teatro</h3>
				  <hr class="panel panel-info">
				  <p class="testoEventi">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
				</div>

				<div class="panel panel-info">
				  <h3 class="titoloEvento">Mostre</h3>
				  <hr class="panel panel-info">
				  <p class="testoEventi">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
				</div>

			</form>
		</div>
		<!-- fine ultimi eventi-->

		<!-- inizio campi ricerca -->
		<div class="col-md-3" id="post">

		<h3 class="titoloEvento">Ricerca Evento</h3>
		<div>
	    <span id="campiricerca">
		
				<label>Regione
					<input type="" name="regione" placeholder="Scegli Regione">
				</label>
		</span>

		<span id="campiricerca">	
			
				<label>Provincia
					<input type="" name="provincia" placeholder="Scegli Provincia">
				</label>
			
		</span>
		
		<span id="campiricerca">
			
				<label>Comune
					<input type="" name="comune" placeholder="Scegli comune">
				</label>
			<label>Scegli data
				<input type="date" name="data">
			</label>
		</span>
		
		<span id="campiricerca">
			<label>TipoEvento </label>
			
			<form action="ServletRicerca.java">
			  <input type="checkbox" name="tipo1" value="Teatro">Teatro</input>
			  <input type="checkbox" name="tipo2" value="Concerto">Concerto</input>
			  <input type="checkbox" name="tipo3" value="Film">Film</input>
			  <input type="checkbox" name="tipo4" value="Mostra">Mostra</input>
			 	<button type="submit" class="btn btn-success">Cerca</button>	
			
			</form>
		</span>
		</div>
		<!-- fine campi ricerca -->
		</div><!-- chiusura div class post -->


		</div><!-- FINE CLASS CONTAINER-->
		</div><!--FINE CLASSE RAW-->

</body>

<!-- APERTURA FOOTER-->
<footer class="footer">
<<<<<<< HEAD
  <dl>
    	<dt>Creato da Gruppo Sincrono </dt>
    	
  </dl>
=======

    	<dd> Creato da: Gruppo SINCRONO - <time datetime="2010-11-23" pubdate>Lunedi 4 Dicembre</time></dd>
    	
 
>>>>>>> 91d8d7b80e7c3d4701e4dc073fcdde6ff1d9d27c
	<small>Tutti i contenuti sono prottetti dalla licenza creative commons</small>
</footer>
<!-- CHIUSURA FOOTER-->





 <!--INIZO SCRIPT BOOTSTRAP -->
 	<script type="text/javascript" src="..//js/app.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP -->	
   

</html>
