<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--COLLEGAMENTO AL prova CSS BOOTSTRAP-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<link rel="stylesheet" type="text/css" href="..//css/Style.css">

</head>
<body>
  <div id="sfondo"></div>

<div class="container"> <!--INIZIO CLASSE CONTAINER-->
<div class="row"><!--INIZIO CLASSE ROW-->

<!--INIZIO NAVBAR -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <img id="fotoMercury" src="../img/nuovoLogo1.png">
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
<!-- FINE NAVBAR -->


<div class="col-md-8">
  <div class="panel panel-info">
    <h3 class="titoloEvento">Concerto</h3>
    <hr class="panel panel-info">
    <p>adgajsdgjasghjdashjkldfajlhfljahsjdh</p>
  </div>

  <div class="panel panel-info">
    <h3 class="titoloEvento" >Teatro</h3>
    <hr class="panel panel-info">
    <p>adgajsdgjasghjdashjkldfajlhfljahsjdh</p>
  </div>

  <div class="panel panel-info">
    <h3 class="titoloEvento">Mostre</h3>
    <hr class="panel panel-info">
    <p>adgajsdgjasghjdashjkldfajlhfljahsjdh</p>
  </div>

  <div class="panel panel-info">
    <h3 class="titoloEvento">Film</h3>
    <hr class="panel panel-info">
    <p>adgajsdgjasghjdashjkldfajlhfljahsjdh</p>
  </div>
</div>

<!-- inizio campi ricerca -->
  <div class="col-md-3" id="post">

  <h3 class="titoloEvento">Ricerca Evento</h3>

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
    <label>TipoEvento</label>
    <form>
        <input type="checkbox" name="tipo1" value="Teatro">Teatro
        <input type="checkbox" name="tipo2" value="Concerto">Concerto
        <input type="checkbox" name="tipo3" value="Film">Film
        <input type="checkbox" name="tipo4" value="Mostra">Mostra
    </form> 
    
    <button type="submit" class="btn btn-success">Cerca</button>  
  </span>
  </div>
  <!-- fine campi ricerca -->
  </div><!-- FINE CLASS CONTAINER-->
 </div><!--FINE CLASSE RAW-->
 

</body>


<!-- APERTURA FOOTER-->
<footer class="footer">
  <dl>
      <dt>Creato da</dt>
      <dt>Gruppo sincrono </dt>
      <dd><time datetime="2010-11-23" pubdate>Lunedi 4 Dicembre</time></dd>
      <dd>
  </dl>
  <small>Tutti i contenuti sono prottetti dalla licenza creative commons</small>
</footer>
<!-- CHIUSURA FOOTER-->



 <!--INIZO SCRIPT BOOTSTRAP -->
  <script type="text/javascript" src="..//js/app.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<!--FINE SCRIPT BOOTSTRAP --> 
   

</html>