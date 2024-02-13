<?php
// refer to the des.php file, similar with link to the des.js file (the fourth highlight part in test_des.html)
include('des.php');
?>

<html>
	<body>

		
		<?php
			
			// PHP des encryption API (in des.php)
            $ciphertext = $_POST['message'];
            $key = $_POST['DES_Encryption_Key'];
			
			echo "Received encrypted Message: " . $ciphertext . "</br></br>"; 
			echo "Pre-set decryption key: " . $key . "</br></br>"; 

			// PHP des decryption API (in des.php)
			$recovered_message = php_des_decryption($key, $ciphertext);
			
			echo "Recovered plaintext message: " . $recovered_message; 

            $file = fopen("../database/database.txt", "a");
            fwrite($file, $recovered_message."\n"); 
            //close the file
            fclose($file); 
		?>

	</body>

</html>
