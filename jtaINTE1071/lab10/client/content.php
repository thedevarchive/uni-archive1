<?php
	session_start();
	if(!isset($_SESSION['login'])){
		header('Location: login.html');
	}
	
	$user = $_SESSION['uname']; 
	echo "<h2>Lab 10 Content</h2><br/><br/>Hi! ".$user."<br/><br/>Here is the content";
?>

<html>
<body>
<form action="../server/logout.php" method="POST">
<button type="submit">Logout</button>
</form>


</body>
</html>
