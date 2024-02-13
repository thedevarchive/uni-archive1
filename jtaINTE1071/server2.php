<html>
    <body>
        <?php 
            //Receive input form client side
            $input = $_POST['enter']; 

            //check if input exist
            $exist = 0; 

            //read the file line by line 
            foreach(file('database.txt') as $line)
            {
                //compare the content of the input and the line
                if($line == $input."\n")
                {
                    $exist = 1; 
                    break; 
                }
            }
            if($exist == 1)
            {
                echo "The input exists! <br/><br/>Please enter another one via <a href='client2.html'>client2.html</a>";
            }
            else
            {
                //open file named database.textdomain
                $file = fopen("database.txt", "a");
                //insert this input (plus a newline) into the database.textdomain
                fwrite($file, $input."\n"); 
                //close the file
                fclose($file); 
                echo "The input is added to the database.txt. <br/><br/>Please try to enter the same input again via <a href='client2.html'>client2.html</a>";
            }
        ?>
    </body>
</html>