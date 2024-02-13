<?php

	session_start();
	
	unset($_SESSION['login']);
	
	echo "If you see this page, it is because you either logged out, or the session expired.";
	
	echo "<br/><br/>Go back to <a href='../client/login.html'>login</a> page";
?>
