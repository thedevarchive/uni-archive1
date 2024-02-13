<?php 
include('rsa.php');
?>

<html>
	<body>

		
		<?php
            // compute the ciphertext
            $encrypted = $_POST['plaintext']; 
            echo "Received encrypted message: ".$encrypted."<br/><br/>";

            // Get the private Key
            $privateKey = get_rsa_privatekey('private.key');

            // compute the decrypted value
            $decrypted = rsa_decryption($encrypted, $privateKey);

            echo 'Recovered message: ' . $decrypted . "<br/><br/>";

            $file = fopen("../database/database.txt", "a");
            fwrite($file, $decrypted."\n"); 
            //close the file
            fclose($file); 

            echo "The recovered message has been added to the ../database/database.txt <br/>";
            echo "Go <a href='http://titan.csit.rmit.edu.au/~s3674651/'>back</a> to check the ../database/database.txt";
        ?>


	</body>

</html>