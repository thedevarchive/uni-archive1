<html>
    <body>
        <?php 
            //Receive input form client side
            $user = $_POST['uname']; 
            $pass = $_POST['pass'];

            //check if input exist
            $exist = 0; 

            //read the file line by line 
            foreach(file('../database/database.txt') as $line)
            {
                list($a, $b) = explode(",", $line);
                //compare the content of the input and the line
                if($a == $user)
                {
                    $exist = 1; 
                    break; 
                }
            }
            if($exist == 1)
            {
                echo "The username is taken. <br/><br/>Please enter another one via <a href='../client/register.html'>register.html</a>";
            }
            else
            {
                //open file named database.textdomain
                $file = fopen("../database/database.txt", "a");
                //insert this input (plus a newline) into the database.textdomain
                fwrite($file, $user.",".$pass."\n"); 
                //close the file
                fclose($file); 
                echo "Register successful. <br/><br/>Login via <a href='../client/login.html'>login.html</a> ";
            }
        ?>
    </body>
</html>