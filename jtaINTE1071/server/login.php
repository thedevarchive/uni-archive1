<html>
    <body>
        <?php 
            //Receive input form client side
            $user = $_POST['uname']; 
            $pass = $_POST['pass'];

            //check if input exist
            $exist = 0; 

            //read the file line by line 
            foreach(file('../database/users.txt') as $line)
            {
                list($a, $b) = explode(",", $line);
                //compare the content of the input and the line
                if($a == $user && $b == $pass."\n")
                {
                    $exist = 1; 
                    break; 
                }
            }
            if($exist == 1)
            {
                echo "Login successful!<br/><br/>Go <a href='http://titan.csit.rmit.edu.au/~s3674651/'>back</a> to register, login or check the users.txt";
            }
            else
            {
                echo "Wrong username or password.<br/><br/>Go <a href='http://titan.csit.rmit.edu.au/~s3674651/'>back</a> to register, login or check the users.txt";
            }
        ?>
    </body>
</html>