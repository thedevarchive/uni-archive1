<?php 
include('rsa.php');
session_start(); 
?>

<html>
    <body>
        <?php 
            //Receive input form client side
            $user = $_POST['uname']; 
            $pass = $_POST['pass'];

            //echo "Find the user: ".$user."</br></br>"; 

            $privateKey = get_rsa_privatekey('private.key');
            $decrypted = rsa_decryption($pass, $privateKey);

            //echo "Decrypted received password: ".$decrypted."</br></br>";

            //check if input exist
            $exist = 0; 
            $diff = 0; 
            //read the file line by line 
            foreach(file('../database/database.txt') as $line)
            {
                list($a, $b) = explode(",", $line);
                $split_value = explode("&", $decrypted);

                //echo "Split decrypted value as two parts: </br>".$split_value[0]."</br>".$split_value[1]."</br></br>"; 

                $timestamp = time();
                //echo "Get current timestamp: ".$timestamp."<br/>"; 

                $diff = $split_value[1] - $timestamp; 
                //compare the content of the input and the line
                if($a == $user && $b == $split_value[0]."\n")
                {
                    $exist = 1; 
                    break; 
                }
            }


            if($exist == 1 && $diff < 150)
            {
                $_SESSION['login'] = "YES"; 
                $_SESSION['uname'] = $user; 
                header('Location: ../client/shoppingcart.php');
            }
            else if($diff >= 150)
            {
                echo "Unresponsive server.<br/><br/>Go <a href='http://titan.csit.rmit.edu.au/~s3674651/'>back</a>";
            }
            else
            {
                echo "Wrong username or password.<br/><br/>Go <a href='http://titan.csit.rmit.edu.au/~s3674651/'>back</a> to register, login or check the users.txt";
            }
        ?>
    </body>
</html>